package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private  String url;
//네트워크 기반으로 생명주기콜백을 이해하기 위한 예시
    public NetworkClient(){
        System.out.println("생성자 호출 url = "+url);
//        connect();
//        call("초기화연결메시지");
//        //객체 생성과 초기화가 분리되어 있지 않음

    }

    public  void  setUrl(String url){
        //의존관계주입 역할
        this.url = url;
    }

    //서비스 시작시 호출
    public void call(String message){
        System.out.println("call: "+url + "  message: " + message);

    }
    public void connect(){
        System.out.println("connect: "+url);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: "+url);

    }
    @PostConstruct
    public void init() {
        //의존관계주입까지 끝난 후에 초기화 메서드를 실행해준다.
        //의존관계주입 -> 초기화를 가능하게 해준다
        System.out.println("NetworkClient.init");
        connect();
        call("초기화연결메시지");
    }
    @PreDestroy
    public void close() {
        //소멸 콜백을 가능하게 해준다.
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
