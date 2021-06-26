package pl.koguciuk.initial.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static pl.koguciuk.initial.security.ApplicationUserPermission.*;
import static pl.koguciuk.initial.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // TODO
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(STUDENT_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(STUDENT_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(STUDENT_WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password123"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails admin_trainee = User.builder()
                .username("adminTrainee")
                .password(passwordEncoder.encode("password123"))
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(
                user,
                admin,
                admin_trainee
        );
    }
}
