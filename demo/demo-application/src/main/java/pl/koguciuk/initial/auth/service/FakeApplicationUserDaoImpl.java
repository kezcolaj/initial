package pl.koguciuk.initial.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import pl.koguciuk.initial.auth.user.ApplicationUser;
import pl.koguciuk.initial.auth.repository.ApplicationUserDao;

import java.util.Map;
import java.util.Optional;

import static pl.koguciuk.initial.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoImpl implements ApplicationUserDao {

    private final Map<String, ApplicationUser> USER_LIST;

    public FakeApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        USER_LIST = Map.of(
                "user", new ApplicationUser("user", passwordEncoder.encode("password"), STUDENT.getGrantedAuthorities(), true, true, true, true),
                "admin", new ApplicationUser("admin", passwordEncoder.encode("password123"), ADMIN.getGrantedAuthorities(), true, true, true, true),
                "adminTrainee", new ApplicationUser("adminTrainee", passwordEncoder.encode("password123"), ADMIN_TRAINEE.getGrantedAuthorities(), true, true, true, true)
        );
    }

    @Override
    public Optional<ApplicationUser> findApplicationUserByUsername(String username) {
        return Optional.ofNullable(USER_LIST.get(username));
    }
}
