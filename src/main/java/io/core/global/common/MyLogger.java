package io.core.global.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
/** ScopedProxyMode.TARGET_CLASS
 * 적용 대상이 인터페이스가 아닌 클래스 : TARGET_CLASS
 * 적용 대상이 인터페이스면 : INTERFACE를 선택
 */
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    /**
     * 빈이 생성된 후 초기화 작업을 수행하는 메서드입니다.
     * 이 메서드는 스프링이 빈을 생성하고 의존성을 주입한 후에 자동으로 호출됩니다.
     */
    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    /**
     * 서버에서 요청 처리가 완료되어 빈이 소멸되기 직전에 호출되는 메서드입니다.
     * 스프링이 빈을 관리하다가 빈이 더 이상 필요하지 않으면 이 메서드를 호출하여 정리 작업을 수행합니다.
     */
    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }
}