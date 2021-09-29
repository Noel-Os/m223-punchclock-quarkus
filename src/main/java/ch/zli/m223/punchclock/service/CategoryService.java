package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;
import io.quarkus.security.Authenticated;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Category add(Category category) {
        entityManager.persist(category);
        return category;
    }

}
