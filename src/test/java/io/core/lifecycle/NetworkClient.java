package io.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    /**
     * 초기화, 소멸 인터페이스 단점
     * 스프,링 전용 인터페이이며, 해당 코드가 스프링 전용 인터페이스에 의존
     * 초기화, 소멸 메서드의 이름을 변경 X
     * 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.
     */

    // 의존관계가 끝나면 주입하겠다.
    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
