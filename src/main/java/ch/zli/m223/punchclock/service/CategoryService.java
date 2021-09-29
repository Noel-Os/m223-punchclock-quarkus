package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Category add(Category category) {
        entityManager.persist(category);
        return category;
    }

    public List<Category> getCategories() {
        var query = entityManager.createQuery("FROM Category");
        return query.getResultList();
    }

    public Category getCategory(long id) {
        return entityManager.find(Category.class, id);
    }

    @Transactional
    public void deleteCategory(long id) {
        entityManager.remove(getCategory(id));
    }

}
