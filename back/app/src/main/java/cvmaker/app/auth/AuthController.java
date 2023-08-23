package cvmaker.app.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

     @PostMapping(value = "login")
     public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
         return ResponseEntity.ok(authService.login(loginRequest));
     }

     @PostMapping(value = "register")
     public ResponseEntity<AuthResponse> registration(@RequestBody RegisterRequest requestBody){
        return ResponseEntity.ok(authService.register(requestBody));
     }
}
