package ez.registration.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
    String email;
    String password;
    @ElementCollection
    List<Phone> phones;
    LocalDateTime created;
    LocalDateTime modified;
    LocalDateTime lastLogin;
    String token;
    boolean active;
    @ElementCollection
    List<GrantedAuthority> authorities;
}
