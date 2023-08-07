package cvmaker.app.auth;

import cvmaker.app.jwt.JwtService;
import cvmaker.app.userdata.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDataRepository userDataRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(final LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        final UserDetails user = userDataRepository.findByUsername(
                request.getUsername()).orElseThrow();
        final String token = jwtService.getToken(user);

        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(final RegisterRequest request){
        final UserDataEntity userDataEntity = UserDataEntity
                .builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userDataRepository.save(userDataEntity);

        return AuthResponse
                .builder()
                .token(jwtService.getToken(userDataEntity))
                .build();

    }
}
