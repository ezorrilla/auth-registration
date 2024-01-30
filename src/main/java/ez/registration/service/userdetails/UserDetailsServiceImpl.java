package ez.registration.service.userdetails;

import ez.registration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var appUser = userRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    return new User(appUser.getEmail(), appUser.getPassword(), appUser.getAuthorities());
  }
}
