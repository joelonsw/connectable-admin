package fans.connectable.admin.event.dao;

import fans.connectable.admin.event.domain.Event;
import fans.connectable.admin.event.ui.dto.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventDao {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Event> eventRowMapper = (resultSet, rowNum) -> Event.builder()
        .id(resultSet.getLong("id"))
        .eventName(resultSet.getString("event_name"))
        .description(resultSet.getString("description"))
        .contractAddress(resultSet.getString("contract_address"))
        .contractName(resultSet.getString("contract_name"))
        .build();

    public List<Event> findAllEvents() {
        String sql = "select * from event";
        return jdbcTemplate.query(sql, eventRowMapper);
    }
}
