package fans.connectable.admin.ticket.dao;

import fans.connectable.admin.ticket.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TicketDao {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Ticket> ticketRowMapper = (resultSet, rowNum) -> Ticket.builder()
        .id(resultSet.getLong("id"))
        .price(resultSet.getInt("price"))
        .ticketMetadata(resultSet.getString("ticket_metadata"))
        .ticketSalesStatus(resultSet.getString("ticket_sales_status"))
        .tokenId(resultSet.getLong("token_id"))
        .tokenUri(resultSet.getString("token_uri"))
        .eventId(resultSet.getLong("event_id"))
        .build();

    public Optional<Ticket> findById(Long ticketId) {
        String sql = "select * from ticket where id = ?";
        List<Ticket> result = jdbcTemplate.query(sql, ticketRowMapper, ticketId);
        return result.stream().findAny();
    }
}
