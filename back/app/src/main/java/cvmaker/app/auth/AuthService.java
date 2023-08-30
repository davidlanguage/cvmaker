package cvmaker.app.auth;

import cvmaker.app.jwt.JwtService;
import cvmaker.app.userdata.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static cvmaker.app.utils.Validator.validateAll;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final GetUserDataEntityByUsernameDAO getUserDataEntityByUsernameDAO;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CreateUserDataDao createUserDataDao;

    public AuthResponse login(final LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        final UserDetails user = getUserDataEntityByUsernameDAO.findByUsername(
                request.getUsername());
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

        if (validateAll(request.getUsername(), request.getPassword())){

            createUserDataDao.create(userDataEntity);

            return AuthResponse
                    .builder()
                    .token(jwtService.getToken(userDataEntity))
                    .build();
        } else{

            return AuthResponse
                    .builder()
                    .build();
        }






    }
}
