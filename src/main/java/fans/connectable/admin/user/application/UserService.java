package fans.connectable.admin.user.application;

import fans.connectable.admin.user.dao.UserDao;
import fans.connectable.admin.user.domain.User;
import fans.connectable.admin.user.ui.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public UserResponse findById(Long userId) {
        Optional<User> user = userDao.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 유저 id");
        }
        return UserResponse.of(user.get());
    }
}
