package hello.core.lifecycle;

public class NetworkClient {
    private  String url;
//네트워크 기반으로 생명주기콜백을 이해하기 위한 예시
    public NetworkClient(){
        System.out.println("생성자 호출 url = "+url);
        connect();
        call("초기화연결메시지");
        //객체 생성과 초기화가 분리되어 있지 않음

    }

    public  void  setUrl(String url){
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
}
