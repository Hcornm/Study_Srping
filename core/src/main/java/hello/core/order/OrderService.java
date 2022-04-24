package hello.core.order;


// 주문 추상화
public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
