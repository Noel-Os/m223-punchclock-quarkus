package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import ch.zli.m223.punchclock.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auth")
public class AuthController {

    @Inject
    AuthenticationService authenticationService;

    /**
     *
     * @param user
     * @return JWT
     */
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(User user) {
        User user2 = authenticationService.getUser(user);
        if (user2 != null) {
            return authenticationService.GenerateValidJwtToken(user2.getUsername(), user2.getRole());
        } else {
            throw new NotAuthorizedException("Not authorized");
        }
    }
}
