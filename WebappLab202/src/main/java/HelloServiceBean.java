import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.Hello;
import hello.HelloService;
import hello.HelloServiceImpl;

@ManagedBean
@SessionScoped
public class HelloServiceBean implements Serializable {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloBean.class);

	private static final long serialVersionUID = -5253582525566537392L;
	
	private HelloService helloService;
	
	public HelloServiceBean() {
		helloService = new HelloServiceImpl();
		for (int id = 1; id <= 3; id++) {
			Hello helloTest = new Hello();
			helloTest.setId(id);
			helloTest.setTitle(String.format("Hello world %d", id));
			helloService.addHello(helloTest);
		}
		logger.info("HelloService creado");
		logger.info("HelloServiceBean creado");
	}
	
	public String getTitles() {
		String text = "";
		for (Hello hello : helloService.getAllHello()) {
			text += hello.toString() + "\n";
		}
		return text;
	}
	
}
