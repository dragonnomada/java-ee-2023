import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Path("/pings")
public class PingsResource {

//	static final Logger logger = LoggerFactory.getLogger(PingsResource.class); 
	
	@GET
	@Path("/hi")
	public Response hi() {
		return Response.ok().entity("Hi there").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/demo/xml")
	public Demo getDemoXML() {
		Demo demo = new Demo();
		demo.setId(123L);
		demo.setTitle("This is a demo xml");
		demo.setDate(new Date());
		return demo;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/demo/new")
	public Response postDemoXML(Demo demo) {
//		logger.info(demo.toString());
		
		demo.setDate(new Date());
		
//		return Response.ok().entity(demo).build();
		return Response.ok().entity(demo.toString()).build();
	}
	
}
