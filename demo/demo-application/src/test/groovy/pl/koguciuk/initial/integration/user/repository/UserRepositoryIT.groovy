package pl.koguciuk.initial.integration.user.repository

import org.springframework.beans.factory.annotation.Autowired
import pl.koguciuk.initial.configuration.DemoIntegrationTest
import pl.koguciuk.initial.security.ApplicationUserRole
import pl.koguciuk.initial.user.domain.User
import pl.koguciuk.initial.user.repository.UserRepository
import spock.lang.Shared
import spock.lang.Specification

@DemoIntegrationTest
class UserRepositoryIT extends Specification{
    
    @Autowired
    UserRepository userRepository
    
    @Shared
    private User userToStore
    
    def "setup"() {
        userToStore = new User()
        userToStore.username = "some_user"
        userToStore.password = "password"
        userToStore.role = ApplicationUserRole.ADMIN
        userToStore.enabled = true
    }
    
    def "cleanup"() {
        userRepository.delete(userToStore)
    }
    
    def "should store user in DB and find his by username"() {
        given:
            userToStore
        
        when:
            userRepository.save(userToStore)
            def loadedUser = userRepository.findByUsername(userToStore.username)
        
        then:
            with(loadedUser.get(), {
                it.username == userToStore.username
                it.password == userToStore.password
                it.role == ApplicationUserRole.ADMIN
                it.enabled
                !it.expired
            })
    }
}
