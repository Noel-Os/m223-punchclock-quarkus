package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Role;
import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class RoleService {

    @Inject
    EntityManager entityManager;

    public List<Role> getRoles() {
        var query = entityManager.createQuery("FROM Role");
        return query.getResultList();
    }

    public Role getRole(long id) {
        return entityManager.find(Role.class, id);
    }

    public Role createRole(Role role){
        entityManager.persist(role);
        return role;
    }

}
