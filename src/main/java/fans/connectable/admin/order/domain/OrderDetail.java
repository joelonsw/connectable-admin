package fans.connectable.admin.order.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class OrderDetail {
    private final Long id;
    private final Timestamp createdDate;
    private final Timestamp modifiedDate;
    private final String orderStatus;
    private final String txHash;
    private final Long ticketId;
    private final Long orderId;
    private final Order order;

    @Builder
    public OrderDetail(Long id, Timestamp createdDate, Timestamp modifiedDate, String orderStatus, String txHash,
                       Long ticketId, Long orderId, Order order) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.orderStatus = orderStatus;
        this.txHash = txHash;
        this.ticketId = ticketId;
        this.orderId = orderId;
        this.order = order;
    }
}
