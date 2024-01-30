package ez.registration.service;

import ez.registration.dto.DoSignUpRequest;
import ez.registration.dto.DoSignUpResponse;

public interface IUserService {
    public DoSignUpResponse registerUser(DoSignUpRequest doSignUpRequest);

}
