package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Role;
import ch.zli.m223.punchclock.domain.User;
import io.smallrye.jwt.build.Jwt;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.Duration;

@RequestScoped
public class AuthenticationService {

    @Inject
    private EntityManager entityManager;

    public User getUser(User user) {
        var query = entityManager.createQuery("FROM User u" +
               " WHERE u.username=:username AND u.password=:password");

        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());

        User result = (User) query.getSingleResult();

        if (result != null) {
            return result;
        }
        return null;
    }

    public String GenerateValidJwtToken(String username, Role role) {
        String token =
                Jwt.issuer("https://zli.ch/issuer")
                        .upn(username)
                        .groups(role.getRoleName())
                        .expiresIn(Duration.ofHours(1))
                        .sign();
        return token;
    }

}
