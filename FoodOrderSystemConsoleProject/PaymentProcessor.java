package FoodOrderSystemConsoleProject;

public interface PaymentProcessor
{
    void processPayment();
}

class UpiPayment implements PaymentProcessor
{
    public void processPayment()
    {
        System.out.println("Processing Upi payment");
        System.out.println("Payment Successful, "+ FoodOrder.totalPrice+" received");
    }
}


class CardPayment implements PaymentProcessor
{
    public void processPayment()
    {
        System.out.println("Processing Card payment");
        System.out.println("Payment Successful, "+FoodOrder.totalPrice+" received");
        System.out.println("-------------------------");
    }
}


class CashPayment implements PaymentProcessor
{
    public void processPayment()
    {
        System.out.println("Payment Successful, "+FoodOrder.totalPrice+" received");
        System.out.println("-------------------------");
    }
}
