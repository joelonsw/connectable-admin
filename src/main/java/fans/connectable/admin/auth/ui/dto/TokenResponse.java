package fans.connectable.admin.auth.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {

    private String token;

    public static TokenResponse of(String token) {
        return new TokenResponse(token);
    }
}
