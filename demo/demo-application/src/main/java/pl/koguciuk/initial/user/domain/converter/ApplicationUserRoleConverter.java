package pl.koguciuk.initial.user.domain.converter;

import pl.koguciuk.initial.security.ApplicationUserRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class ApplicationUserRoleConverter implements AttributeConverter<ApplicationUserRole, String> {

    @Override
    public String convertToDatabaseColumn(ApplicationUserRole role) {
        return Optional.ofNullable(role)
                .map(Enum::name)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public ApplicationUserRole convertToEntityAttribute(String role) {
        return Optional.ofNullable(role)
                .map(ApplicationUserRole::valueOf)
                .orElseThrow(IllegalArgumentException::new);
    }
}
