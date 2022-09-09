package fans.connectable.admin.order.ui.dto;

import fans.connectable.admin.order.domain.OrderDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class OrderDetailFullResponse {

    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String orderStatus;
    private String txHash;
    private Long ticketId;
    private Long orderId;
    private OrderResponse order;

    public OrderDetailFullResponse(Long id, Timestamp createdDate, Timestamp modifiedDate, String orderStatus,
                                   String txHash, Long ticketId, Long orderId, OrderResponse order) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.orderStatus = orderStatus;
        this.txHash = txHash;
        this.ticketId = ticketId;
        this.orderId = orderId;
        this.order = order;
    }

    public static OrderDetailFullResponse of(OrderDetail orderDetail) {
        return new OrderDetailFullResponse(
            orderDetail.getId(),
            orderDetail.getCreatedDate(),
            orderDetail.getModifiedDate(),
            orderDetail.getOrderStatus(),
            orderDetail.getTxHash(),
            orderDetail.getTicketId(),
            orderDetail.getOrderId(),
            OrderResponse.of(orderDetail.getOrder())
        );
    }

    public static List<OrderDetailFullResponse> toList(List<OrderDetail> fullOrderDetails) {
        return fullOrderDetails.stream()
            .map(OrderDetailFullResponse::of)
            .collect(Collectors.toList());
    }
}
