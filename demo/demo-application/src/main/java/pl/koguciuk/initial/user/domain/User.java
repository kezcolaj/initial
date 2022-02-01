package pl.koguciuk.initial.user.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.koguciuk.initial.security.ApplicationUserRole;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "USER_ID_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_ID_SEQ_GEN", sequenceName = "USER_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @Size(max = 50)
    private String username;

    @Size(max = 60)
    private String password;

    private ApplicationUserRole role;

    private boolean expired;

    private boolean locked;

    private boolean credentialsExpired;

    private boolean enabled;
}
