package pl.koguciuk.initial.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koguciuk.initial.auth.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
