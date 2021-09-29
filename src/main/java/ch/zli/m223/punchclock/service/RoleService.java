package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Role;
import netscape.javascript.JSObject;
import org.jose4j.json.internal.json_simple.JSONObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RoleService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void deleteRole(long id) {
        entityManager.remove(getRole(id));
    }

    public List<Role> getRoles() {
        var query = entityManager.createQuery("FROM Role");
        return query.getResultList();
    }

    public Role getRole(long id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    public Role createRole(Role role) {

        entityManager.persist(role);
        return role;
    }



}
