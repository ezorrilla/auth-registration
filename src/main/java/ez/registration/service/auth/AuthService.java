package ez.registration.service.auth;

public interface AuthService {
  String login(String username, String password);

  String verifyToken(String token);
}
