package myTest.behavioralPatterns;

public class MeStrategy {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setPayMentStrategy(new CreditCardPayment("1234-5678-9101-1121"));
        shoppingCart.checkout(500);

        shoppingCart.setPayMentStrategy(new PayPalPayment("example@example.com"));
        shoppingCart.checkout(30);
    }
}

// 알고리즘을 나타내는 인터페이스
interface PayMentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PayMentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via credit card with number " + cardNumber);
    }
}

class PayPalPayment  implements PayMentStrategy {
    private String email;

    public PayPalPayment (String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via credit card with number " + email);
    }
}

// Context : 전략을 사용하는 역할로, 클라이언트와 상호 작용
class ShoppingCart {
   private PayMentStrategy payMentStrategy;

   public void setPayMentStrategy(PayMentStrategy payMentStrategy) {
       this.payMentStrategy = payMentStrategy;
   }

   public void checkout(int amount) {
       payMentStrategy.pay(amount);
   }
}
