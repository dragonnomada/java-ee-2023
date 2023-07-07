import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloBean.class);
	
	private static final long serialVersionUID = 1L;
	
	public HelloBean() {
		super();

		logger.info("Hello Bean creado :D");
		
		System.out.println("Hello Bean creado XD");
	}

	private String title = "Hello JavaBeans :L";

	public String getTitle() {
		logger.info("Hello Bean getTitle :D");
		
		System.out.println("Hello Bean Title XD");
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
