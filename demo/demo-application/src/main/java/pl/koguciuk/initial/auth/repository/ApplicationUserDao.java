package pl.koguciuk.initial.auth.repository;

import pl.koguciuk.initial.auth.user.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> findApplicationUserByUsername(String username);
}
