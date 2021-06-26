package pl.koguciuk.initial.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

import static pl.koguciuk.initial.security.ApplicationUserPermission.*;

@AllArgsConstructor
@Getter
public enum ApplicationUserRole {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(STUDENT_READ));

    private final Set<ApplicationUserPermission> permissions;
}
