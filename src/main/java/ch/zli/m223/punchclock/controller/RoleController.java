package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.service.RoleService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/roles")
@Tag(name = "Roles", description = "Handling of roles")
public class RoleController {

    @Inject
    RoleService roleService;

}
