package fans.connectable.admin.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private final Long id;
    private final Boolean isActive;
    private final String klaytnAddress;
    private final String nickname;
    private final String phoneNumber;
    private final Boolean privacyAgreement;

    @Builder
    public User(Long id, Boolean isActive, String klaytnAddress, String nickname, String phoneNumber, Boolean privacyAgreement) {
        this.id = id;
        this.isActive = isActive;
        this.klaytnAddress = klaytnAddress;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.privacyAgreement = privacyAgreement;
    }
}
