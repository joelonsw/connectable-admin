package fans.connectable.admin.order.ui;

import fans.connectable.admin.auth.AuthRequired;
import fans.connectable.admin.order.application.OrderService;
import fans.connectable.admin.order.ui.dto.OrderDetailFullResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @AuthRequired
    @GetMapping("/order-details")
    public ResponseEntity<List<OrderDetailFullResponse>> findAllOrderDetails() {
        List<OrderDetailFullResponse> fullOrderDetails = orderService.findFullOrderDetails();
        return ResponseEntity.ok(fullOrderDetails);
    }
}
