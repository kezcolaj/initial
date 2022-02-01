package pl.koguciuk.initial.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;
import pl.koguciuk.initial.auth.user.ApplicationUser;
import pl.koguciuk.initial.security.ApplicationUserRole;
import pl.koguciuk.initial.user.domain.User;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "expired", source = "expired")
    @Mapping(target = "locked", source = "locked")
    @Mapping(target = "credentialsExpired", source = "credentialsExpired")
    @Mapping(target = "enabled", source = "enabled")
    @Mapping(target = "authorities", source = "role", qualifiedByName = "mapAuthorities")
    ApplicationUser toApplicationUser(User user);

    @Named("mapAuthorities")
    static Set<? extends GrantedAuthority> mapAuthorities(ApplicationUserRole role) {
        return role.getGrantedAuthorities();
    }
}
