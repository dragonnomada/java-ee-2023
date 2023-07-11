import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class UnmarshalTest {

	public static void main(String[] args) throws JAXBException, IOException {
	    JAXBContext context = JAXBContext.newInstance(Todo.class);
	    Todo todo = (Todo) context.createUnmarshaller()
	      .unmarshal(new FileReader("./todo.xml"));
	    System.out.println(todo);
	}

}
