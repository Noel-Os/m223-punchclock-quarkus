package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Role;
import ch.zli.m223.punchclock.service.RoleService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/roles")
@Tag(name = "Roles", description = "Handling of roles")
public class RoleController {

    @Inject
    RoleService roleService;

    /**
     *
     * @param id
     */
    @DELETE
    @Path("/{id}")
    public void deleteRole(@PathParam("id") long id) {
        roleService.deleteRole(id);
    }

    /**
     *
     * @return Role list
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    /**
     *
     * @param id
     * @return Role
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Role getRole(@PathParam("id") long id) {
        return roleService.getRole(id);
    }

    /**
     *
     * @param role
     * @return Role
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Role createRole(Role role) {
        return roleService.createRole(role);
    }

    /**
     *
     * @param role
     * @return Role
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Role editRole(Role role) {
        return roleService.editRole(role);
    }

}
