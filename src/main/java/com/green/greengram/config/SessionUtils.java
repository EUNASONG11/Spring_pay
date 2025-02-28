package com.green.greengram.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionUtils {
    public static void addAttribute(String name, Object value) {
        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()).setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
    }

    public static String getStringAttribute(String name) {
        return String.valueOf(getAttribute(name));
    }

    public static Object getAttribute(String name) {
        return Objects.requireNonNull(RequestContextHolder.getRequestAttributes()).getAttribute(name, RequestAttributes.SCOPE_SESSION);
    }
}
/*
    Scope : 생명 주기 (밑으로 갈 수록 넓어짐)
    - page : SSR, 서버 측에서 화면을 렌더링 할 때 쓰는 Scope
    - request : 요청이 생길 때마다 새 Scope가 만들어짐 (HttpServletRequest)
    - session : request와 다르게 같은 브라우저를 구별한다. 같은 브라우저로 요청이 오면 session은 하나만 만들어지고 그것을 계속 사용
        (1) chrome 을 키고
        (1) 끔

        (2) chrome 을 킴
        다른 session
    - application : 전역
 */
