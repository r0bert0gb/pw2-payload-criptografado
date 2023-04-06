package pw2.roberto;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8082/service2")
@AccessToken
public interface InterfaceSegundo {

	@GET
	@Path("/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	@RolesAllowed("User")
	public int soma(@PathParam("a") int a, @PathParam("b") int b);

}
