package pw2.roberto;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class User {

	@GET
	@Path("jwt")
	@PermitAll
	@Produces(MediaType.TEXT_PLAIN)
	public String generate() {
		return Jwt.issuer("IssuerNoProjetoUser")
				.upn("email@falso.com")
				.groups(new HashSet<>(Arrays.asList("User", "Admin")))
				.claim(Claims.full_name, "Fulano Nome Completo")
				.innerSign()
				.encrypt();
	}

}
