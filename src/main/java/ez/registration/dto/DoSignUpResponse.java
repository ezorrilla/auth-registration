package ez.registration.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Data
public class DoSignUpResponse implements Serializable {

  private UUID id;
  private LocalDateTime created;
  private LocalDateTime modified;
  private LocalDateTime last_login;
  private String token;
  private boolean isactive;

  public DoSignUpResponse() {}

  public DoSignUpResponse(
      final UUID id,
      final LocalDateTime created,
      final LocalDateTime modified,
      final LocalDateTime lastLogin,
      final String token,
      final boolean isactive) {
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.last_login = lastLogin;
    this.token = token;
    this.isactive = isactive;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final DoSignUpResponse that = (DoSignUpResponse) o;
    return isIsactive() == that.isIsactive()
        && Objects.equals(getId(), that.getId())
        && Objects.equals(getCreated(), that.getCreated())
        && Objects.equals(getModified(), that.getModified())
        && Objects.equals(getLast_login(), that.getLast_login())
        && Objects.equals(getToken(), that.getToken());
  }

  @Override
  public String toString() {
    return "DoSignInResponse{"
        + "id="
        + getId()
        + ", created='"
        + getCreated()
        + '\''
        + ", modified='"
        + getModified()
        + '\''
        + ", lastLogin='"
        + getLast_login()
        + '\''
        + ", token='"
        + getToken()
        + '\''
        + ", active="
        + isIsactive()
        + '}';
  }
}
