package fans.connectable.admin.order.dao;

import fans.connectable.admin.order.domain.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    void findAllOrderDetails() {
        List<OrderDetail> allOrderDetails = orderDao.findAllOrderDetails();
        for (OrderDetail orderDetail : allOrderDetails) {
            System.out.println("orderDetail = " + orderDetail);
        }
    }

    @Test
    void findAllOrderDetailsJoinOrder() {
        List<OrderDetail> allOrderDetailsJoinOrder = orderDao.findAllOrderDetailsJoinOrder();
        for (OrderDetail orderDetail : allOrderDetailsJoinOrder) {
            System.out.println("orderDetail = " + orderDetail);
        }
    }
}
