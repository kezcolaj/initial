package pl.koguciuk.initial.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.koguciuk.initial.auth.repository.ApplicationUserDao;
import pl.koguciuk.initial.auth.user.ApplicationUser;
import pl.koguciuk.initial.mapper.ApplicationUserMapper;
import pl.koguciuk.initial.user.repository.UserRepository;

import java.util.Optional;

@Repository("dbApplicationUserDao")
@RequiredArgsConstructor
public class DbApplicationUserDaoImpl implements ApplicationUserDao {

    private final UserRepository userRepository;
    private final ApplicationUserMapper applicationUserMapper;

    @Override
    public Optional<ApplicationUser> findApplicationUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(applicationUserMapper::toApplicationUser);
    }
}
