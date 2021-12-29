package pl.koguciuk.initial.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.koguciuk.initial.auth.repository.ApplicationUserDao;

@Service
@RequiredArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    @Qualifier("fake")
    private final ApplicationUserDao applicationUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDao
                .findApplicationUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
    }
}
