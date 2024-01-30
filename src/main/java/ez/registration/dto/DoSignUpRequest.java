package ez.registration.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static ez.registration.util.AppConstant.*;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DoSignUpRequest implements Serializable {

    private static final long serialVersionUID = -4496080854528033222L;
    @Valid
    @NotNull(message = NAME_NULL_ERROR_MESSAGE)
    @NotBlank(message = NAME_EMPTY_ERROR_MESSAGE)
    private String name;

    @NotNull(message = EMAIL_NULL_ERROR_MESSAGE)
    @NotBlank(message = EMAIL_EMPTY_ERROR_MESSAGE)
    @Email(message = EMAIL_FORMAT_ERROR_MESSAGE)
    private String email;

    @NotNull(message = CREDENTIALS_NULL_ERROR_MESSAGE)
    @NotBlank(message = CREDENTIALS_EMPTY_ERROR_MESSAGE)
    @Pattern(regexp = PATTERN_CREDENTIALS, message = CREDENTIALS_FORMAT_ERROR_MESSAGE)
    private String password;

    @Valid
    @NotNull(message = PHONES_NULL_ERROR_MESSAGE)
    @NotEmpty(message = PHONES_EMPTY_ERROR_MESSAGE)
    private List<Phone> phones;

    public DoSignUpRequest() {
    }

    public DoSignUpRequest(
            final String name, final String email, final String password, final List<Phone> phones) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public void validatorRequest() {
        if (getName() == null || getName().isEmpty() || getName().isBlank()) {
            throw new RuntimeException(NAME_EMPTY_ERROR_MESSAGE);
        }
        if (getEmail() == null || getEmail().isEmpty() || getEmail().isBlank()) {
            throw new RuntimeException(EMAIL_EMPTY_ERROR_MESSAGE);
        }
        if (!getEmail().matches(PATTERN_EMAIL)) {
            throw new RuntimeException(EMAIL_FORMAT_ERROR_MESSAGE);
        }
        if (getPassword() == null || getPassword().isEmpty() || getPassword().isBlank()) {
            throw new RuntimeException(CREDENTIALS_EMPTY_ERROR_MESSAGE);
        }
        if (!getPassword().matches(PATTERN_CREDENTIALS)) {
            throw new RuntimeException(CREDENTIALS_FORMAT_ERROR_MESSAGE);
        }
        if (!getPhones().isEmpty()) {
            getPhones().forEach(origen -> {
                if (origen.getNumber() == null || origen.getNumber().isEmpty() || origen.getNumber().isBlank()) {
                    throw new RuntimeException(NUMBER_EMPTY_ERROR_MESSAGE);
                }
                if (!origen.getNumber().matches(PHONE_NUMBER_PATTERN)) {
                    throw new RuntimeException(NUMBER_FORMAT_ERROR_MESSAGE);
                }
                if (origen.getCitycode() == null || origen.getCitycode().isEmpty() || origen.getCitycode().isBlank()) {
                    throw new RuntimeException(CITYWIDE_EMPTY_ERROR_MESSAGE);
                }
                if (origen.getCountryCode() == null || origen.getCountryCode().isEmpty() || origen.getCountryCode().isBlank()) {
                    throw new RuntimeException(COUNTRYSIDE_EMPTY_ERROR_MESSAGE);
                }
            });
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DoSignUpRequest that = (DoSignUpRequest) o;
        return Objects.equals(getName(), that.getName())
                && Objects.equals(getEmail(), that.getEmail())
                && Objects.equals(getPassword(), that.getPassword())
                && Objects.equals(getPhones(), that.getPhones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getPassword(), getPhones());
    }

    @Override
    public String toString() {
        return "DoSignInRequest{"
                + "name='"
                + getName()
                + '\''
                + ", email='"
                + getEmail()
                + '\''
                + ", password='"
                + getPassword()
                + '\''
                + ", phones="
                + getPhones()
                + '}';
    }
}
