package fans.connectable.admin.auth.application;

import fans.connectable.admin.auth.infrastructure.JwtProvider;
import fans.connectable.admin.auth.ui.dto.LoginRequest;
import fans.connectable.admin.auth.ui.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;

    @Value("${auth.id}")
    private String authId;

    @Value("${auth.password}")
    private String authPassword;

    @Value("${auth.payload}")
    private String authPayload;

    public TokenResponse login(LoginRequest loginRequest) {
        String id = loginRequest.getId();
        String password = loginRequest.getPassword();
        if (authId.equals(id) && authPassword.equals(password)) {
            String token = jwtProvider.generateToken(authPayload);
            return TokenResponse.of(token);
        }
        throw new IllegalArgumentException("아이디/비밀번호 불일치");
    }
}
