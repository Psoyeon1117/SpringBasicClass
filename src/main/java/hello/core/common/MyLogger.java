package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//가짜 proxy 객체를 컨테이너에 등록함으로써 DI을 활용할 수 있다.
//덕분에 Provider코드를 줄일 수 있다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" +"["+ requestURL+"]" + message);
    }

    @PostConstruct
    public void  init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope been created" + this);
    }
    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope been closed" + this);
    }
}
