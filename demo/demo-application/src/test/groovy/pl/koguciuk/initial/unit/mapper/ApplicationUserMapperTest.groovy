package pl.koguciuk.initial.unit.mapper

import org.springframework.security.core.authority.SimpleGrantedAuthority
import pl.koguciuk.initial.auth.user.ApplicationUser
import pl.koguciuk.initial.mapper.ApplicationUserMapper
import pl.koguciuk.initial.mapper.ApplicationUserMapperImpl
import pl.koguciuk.initial.security.ApplicationUserRole
import pl.koguciuk.initial.user.domain.User
import spock.lang.Specification

class ApplicationUserMapperTest extends Specification {

    ApplicationUserMapper applicationUserMapper

    def "setup"() {
        applicationUserMapper = new ApplicationUserMapperImpl()
    }

    def "should map user to applicationUser"() {
        given:
            User user = new User()
            user.username = "user"
            user.password = "somePassword"
            user.role = ApplicationUserRole.ADMIN
            user.expired = false
            user.locked = false
            user.credentialsExpired = false
            user.enabled = true

        when:
            ApplicationUser applicationUser = applicationUserMapper.toApplicationUser(user)

        then:
            applicationUser.username == user.username
            applicationUser.password == user.password
            applicationUser.expired == user.expired
            applicationUser.locked == user.locked
            applicationUser.credentialsExpired == user.credentialsExpired
            applicationUser.enabled == user.enabled
            applicationUser.authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))
    }
}
