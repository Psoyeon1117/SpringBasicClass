package hello.core.singleton;

public class SingletonService {
    //스프링X 자바만 사용할 때 싱글톤패턴
    //1. static영역에 객체를 딱 1개만 생성한다.
    private static final SingletonService instance = new SingletonService();

    //2. 생성자를 private으로 선언해서 외부에서 new키워드를 사용한 객체 생성을 못하게 한다.
    private SingletonService(){

    }

    //3. 외부에서 객체 생성이 필요하다면 public static 메소드만을 통해서만 조회하도록 한다.
    public static SingletonService getInstance(){
        return instance;
    }
}
