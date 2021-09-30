package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.service.CategoryService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
@Tag(name = "Categories", description = "Handling of categories")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    /**
     *
     * @param category
     * @return Category
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category createCategory(Category category) {
        return categoryService.add(category);
    }

    /**
     *
     * @return Category list
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    /**
     *
     * @param id
     * @return Category
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@PathParam("id") long id) {
        return categoryService.getCategory(id);
    }

    /**
     *
     * @param id
     */
    @DELETE
    @Path("/{id}")
    public void removeCategory(@PathParam("id") long id) {
        categoryService.deleteCategory(id);
    }

}
