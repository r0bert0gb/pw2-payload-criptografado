package pw2.roberto;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/service1")
public class Service1 {

	@Inject
	@RestClient
	InterfaceSegundo segundo;

	@GET
	@Path("/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	@RolesAllowed("User")
	public int soma(@PathParam("a") int a, @PathParam("b") int b) {

		return segundo.soma(a, b);
	}
}
