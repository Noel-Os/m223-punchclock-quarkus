package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.User;
import io.quarkus.security.Authenticated;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public List<User> getUsers() {
        var query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }
}
