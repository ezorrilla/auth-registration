package ez.registration.service.auth;

import ez.registration.model.User;
import ez.registration.repository.UserRepository;
import ez.registration.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        var authToken = new UsernamePasswordAuthenticationToken(username, password);

        var authenticate = authenticationManager.authenticate(authToken);
        // Generate Token
        return JwtUtils.generateToken(((UserDetails) (authenticate.getPrincipal())).getUsername());
    }

    @Override
    public String verifyToken(String token) {
        var usernameOptional = JwtUtils.getUsernameFromToken(token);

        if (usernameOptional.isPresent()) {
            return usernameOptional.get();
        }

        throw new RuntimeException("Token invalid");
    }
}
