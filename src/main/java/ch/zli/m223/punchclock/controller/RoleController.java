package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Role;
import ch.zli.m223.punchclock.service.RoleService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/roles")
@Tag(name = "Roles", description = "Handling of roles")
public class RoleController {

    @Inject
    RoleService roleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Role getRole(@PathParam("id") long id) {
        return roleService.getRole(id);
    }

}
