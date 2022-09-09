package fans.connectable.admin.order.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class Order {
    private final String ordererName;
    private final String ordererPhoneNumber;
    private final Long userId;

    @Builder
    public Order(String ordererName, String ordererPhoneNumber, Long userId) {
        this.ordererName = ordererName;
        this.ordererPhoneNumber = ordererPhoneNumber;
        this.userId = userId;
    }
}
