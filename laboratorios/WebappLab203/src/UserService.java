//import javax.ejb.EJB;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@LocalBean
@Path("/users")
public class UserService {

	private Map<Long, User> users = new HashMap<Long, User>();
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/new")
	public User createUser(User user) {
		users.put(user.getId(), user);
		return user;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public User[] getUsers() {
		Set<Long> ids = users.keySet();
		User[] usersArray = new User[ids.size()];
		
		int i = 0;
		for (User user : users.values()) {
			usersArray[i++] = user;
		}
		
		return usersArray;
	}
	
}
