package hello.core.order;

public interface OrderService {
    //할인결과를 포함한 주문를 반환한다.
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
