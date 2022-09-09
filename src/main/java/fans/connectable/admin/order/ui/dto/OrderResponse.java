package fans.connectable.admin.order.ui.dto;

import fans.connectable.admin.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String ordererName;
    private String ordererPhoneNumber;
    private Long userId;
    public static OrderResponse of(Order order) {
        return new OrderResponse(
            order.getOrdererName(),
            order.getOrdererPhoneNumber(),
            order.getUserId()
        );
    }
}
