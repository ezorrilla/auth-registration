package ez.registration.controller;

import ez.registration.dto.DoSignUpRequest;
import ez.registration.dto.ResponseHandler;
import ez.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody final DoSignUpRequest doSignUpRequest) {
        try {
            var doSignUpResponse = userService.registerUser(doSignUpRequest);
            return ResponseHandler.generateResponse("Successfully!", HttpStatus.OK, doSignUpResponse);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }
}
