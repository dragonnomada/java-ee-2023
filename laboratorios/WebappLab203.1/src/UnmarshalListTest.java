import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class UnmarshalListTest {

	public static void main(String[] args) throws JAXBException, IOException {
	    JAXBContext context = JAXBContext.newInstance(TodoList.class);
	    
	    TodoList todos = (TodoList) context.createUnmarshaller()
	      .unmarshal(new FileReader("./todos.xml"));
	    
	    System.out.println(todos);
	}

}
