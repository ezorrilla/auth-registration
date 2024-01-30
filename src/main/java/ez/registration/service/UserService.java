package ez.registration.service;

import ez.registration.dto.DoSignUpRequest;
import ez.registration.dto.DoSignUpResponse;
import ez.registration.model.Phone;
import ez.registration.model.User;
import ez.registration.repository.UserRepository;
import ez.registration.service.auth.AuthService;
import ez.registration.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    @Autowired

    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthService authService;


    public DoSignUpResponse registerUser(final DoSignUpRequest doSignUpRequest) {
        doSignUpRequest.validatorRequest();
        if (userRepository.findByEmail(doSignUpRequest.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        // Authorities
        var authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        // Generate Token
        var jwtToken = JwtUtils.generateToken(doSignUpRequest.getEmail());

        var phones = doSignUpRequest.getPhones().stream().map(origen -> Phone.builder().
                        number(origen.getNumber()).
                        countryCode(origen.getCountryCode()).
                        cityCode(origen.getCitycode()).
                        build())
                .collect(Collectors.toList());

        var user = this.userRepository.save(User.builder().
                name(doSignUpRequest.getName()).
                email(doSignUpRequest.getEmail()).
                password(passwordEncoder.encode(doSignUpRequest.getPassword())).
                phones(phones).
                created(LocalDateTime.now()).
                modified(LocalDateTime.now()).
                lastLogin(LocalDateTime.now()).
                token(jwtToken).
                active(true).
                authorities(authorities).
                build());

        return new DoSignUpResponse(
                user.getId(),
                user.getCreated(),
                user.getModified(),
                user.getLastLogin(),
                user.getToken(),
                user.isActive());
    }
}
