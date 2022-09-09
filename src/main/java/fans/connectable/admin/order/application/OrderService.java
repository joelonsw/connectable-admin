package fans.connectable.admin.order.application;

import fans.connectable.admin.order.domain.OrderDetail;
import fans.connectable.admin.order.dao.OrderDao;
import fans.connectable.admin.order.ui.dto.OrderDetailFullResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    public List<OrderDetailFullResponse> findFullOrderDetails() {
        List<OrderDetail> fullOrderDetails = orderDao.findAllOrderDetailsJoinOrder();
        return OrderDetailFullResponse.toList(fullOrderDetails);
    }
}
