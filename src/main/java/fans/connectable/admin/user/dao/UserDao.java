package fans.connectable.admin.user.dao;

import fans.connectable.admin.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = (resultSet, rowNum) -> User.builder()
        .id(resultSet.getLong("id"))
        .isActive(resultSet.getBoolean("is_active"))
        .klaytnAddress(resultSet.getString("klaytn_address"))
        .nickname(resultSet.getString("nickname"))
        .phoneNumber(resultSet.getString("phone_number"))
        .privacyAgreement(resultSet.getBoolean("privacy_agreement"))
        .build();

    public Optional<User> findById(Long userId) {
        String sql = "select * from user where id = ?";
        List<User> result = jdbcTemplate.query(sql, userRowMapper, userId);
        return result.stream().findAny();
    }
}
