package fans.connectable.admin.user.ui.dto;

import fans.connectable.admin.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private Boolean isActive;
    private String klaytnAddress;
    private String nickname;
    private String phoneNumber;
    private Boolean privacyAgreement;

    public static UserResponse of(User user) {
        return new UserResponse(
            user.getId(),
            user.getIsActive(),
            user.getKlaytnAddress(),
            user.getNickname(),
            user.getPhoneNumber(),
            user.getPrivacyAgreement()
        );
    }
}
