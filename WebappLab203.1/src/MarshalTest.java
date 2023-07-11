import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshalTest {
    public static void main(String[] args) throws JAXBException, IOException {
        Todo todo = new Todo();
        
        todo.setId(1L);
        todo.setTitle("Comprar fruta");
        todo.setChecked(true);
        todo.setCreated(new Date());

        JAXBContext context = JAXBContext.newInstance(Todo.class);
        
        Marshaller marshaller= context.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        marshaller.marshal(todo, new File("./todo.xml"));
    }
}