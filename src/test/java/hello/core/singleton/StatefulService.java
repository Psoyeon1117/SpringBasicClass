package hello.core.singleton;

public class StatefulService {
    private int price;  //상태를 유지하는 필드
    public void order(String name, int price){
        System.out.println("name = "+name + "price = " + price);
        this.price = price; //공유필드를 수정하는 이곳이 문제다!
    }
    public int getPrice(){
        return price;
    }
}
