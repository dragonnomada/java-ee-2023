import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshalListTest {

	public static void main(String[] args) throws JAXBException, IOException {
        TodoList todos = new TodoList();
        
        for (int i = 1; i <= 10; i++) {
        	Todo todo = new Todo();
        	todo.setId((long)i);
        	todo.setTitle(String.format("Todo %d", i));
        	todo.setChecked(Math.random() > 0.5);
        	todo.setCreated(new Date());
        	todos.addTodo(todo);
        }
        
        JAXBContext context = JAXBContext.newInstance(TodoList.class);
        
        Marshaller marshaller= context.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        marshaller.marshal(todos, new File("./todos.xml"));
    }
	
}
