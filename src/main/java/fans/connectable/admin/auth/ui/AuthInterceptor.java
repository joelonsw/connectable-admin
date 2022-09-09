package fans.connectable.admin.auth.ui;

import fans.connectable.admin.auth.AuthRequired;
import fans.connectable.admin.auth.infrastructure.AuthorizationExtractor;
import fans.connectable.admin.auth.infrastructure.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AuthRequired authRequired = handlerMethod.getMethodAnnotation(AuthRequired.class);
        if (Objects.isNull(authRequired)) {
            return true;
        }

        String token = AuthorizationExtractor.extract(request);
        if (Objects.isNull(token)) {
            throw new IllegalArgumentException("인가가 필요한 요청입니다.");
        }
        jwtProvider.verify(token);
        return true;
    }
}
