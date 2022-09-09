package fans.connectable.admin.order.dao;

import fans.connectable.admin.order.domain.Order;
import fans.connectable.admin.order.domain.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<OrderDetail> orderDetailRowMapper = (resultSet, rowNum) -> OrderDetail.builder()
        .id(resultSet.getLong("id"))
        .createdDate(resultSet.getTimestamp("created_date"))
        .modifiedDate(resultSet.getTimestamp("modified_date"))
        .orderStatus(resultSet.getString("order_status"))
        .txHash(resultSet.getString("tx_hash"))
        .ticketId(resultSet.getLong("ticket_id"))
        .orderId(resultSet.getLong("order_id"))
        .build();

    private final RowMapper<OrderDetail> orderDetailJoinOrderRowMapper = (resultSet, rowNum) -> OrderDetail.builder()
        .id(resultSet.getLong("id"))
        .createdDate(resultSet.getTimestamp("created_date"))
        .modifiedDate(resultSet.getTimestamp("modified_date"))
        .orderStatus(resultSet.getString("order_status"))
        .txHash(resultSet.getString("tx_hash"))
        .ticketId(resultSet.getLong("ticket_id"))
        .orderId(resultSet.getLong("order_id"))
        .order(Order.builder()
            .ordererName(resultSet.getString("orderer_name"))
            .ordererPhoneNumber(resultSet.getString("orderer_phone_number"))
            .userId(resultSet.getLong("user_id"))
            .build())
        .build();

    public List<OrderDetail> findAllOrderDetails() {
        String sql = "select * from order_detail";
        return jdbcTemplate.query(sql, orderDetailRowMapper);
    }

    public List<OrderDetail> findAllOrderDetailsJoinOrder() {
        String sql = "select * from order_detail " +
            "join orders " +
            "on order_detail.order_id = orders.id";
        return jdbcTemplate.query(sql, orderDetailJoinOrderRowMapper);
    }
}
