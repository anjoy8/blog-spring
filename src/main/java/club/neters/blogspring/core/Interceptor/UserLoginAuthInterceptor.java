package club.neters.blogspring.core.Interceptor;

import club.neters.blogspring.core.annotation.Auth;
import club.neters.blogspring.core.constant.CommonConstant;
import club.neters.blogspring.core.util.JsonUtil;
import club.neters.blogspring.model.vo.ApiResultVo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class UserLoginAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 请求不是控制器的方法
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth authAnnotation = handlerMethod.getMethodAnnotation(Auth.class);

        // 不包含 @Auth 注解
        if (authAnnotation == null) {
            return true;
        }

        // 验证token
        String role = null;
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(token)) {
            try {
                ApiResultVo<Object> resultVo = ApiResultVo.error("user no login");
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().write(JsonUtil.toJson(resultVo));
            } catch (IOException e) {
                log.error("异常信息", e);
            }
            return false;
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(CommonConstant.JWT_HMAC256_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(CommonConstant.JWT_ISSUER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            role = claims.get("role").asString();
            log.info(role);
            if (System.currentTimeMillis() / 1000L > claims.get("exp").asInt()) {
                return false;
            }
        } catch (JWTVerificationException exception) {
            // Invalid signature/claims
            log.error("异常信息", exception);
            try {
                ApiResultVo<Object> resultVo = ApiResultVo.error("Identity authentication failed");
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().write(JsonUtil.toJson(resultVo));
            } catch (IOException e) {
                log.error("异常信息", e);
            }
            return false;
        }

        return true;
    }
}