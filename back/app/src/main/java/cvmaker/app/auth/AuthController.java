package cvmaker.app.auth;

import cvmaker.app.logger.CreateLogDAO;
import cvmaker.app.logger.LoggerEntity;
import cvmaker.app.logger.LoggerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    private final CreateLogDAO createLogDAO;

    private final LoggerMapper loggerMapper;

     @PostMapping(value = "login")
     public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
         createLogDAO.create(loggerMapper.map(LoggerEntity
                 .builder()
                 .message("The user"+loginRequest.getUsername()+" has logged in")
                 .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                 .build()));
         return ResponseEntity.ok(authService.login(loginRequest));
     }

     @PostMapping(value = "register")
     public ResponseEntity<AuthResponse> registration(@RequestBody RegisterRequest requestBody){
        return ResponseEntity.ok(authService.register(requestBody));
     }
}
