// PaymentStrategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy for Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String cvv;

    public CreditCardPayment(String cardNumber, String name, String cvv) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card [Card No: " + cardNumber + "]");
    }
}

// Concrete Strategy for PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal [Email: " + email + "]");
    }
}

// Concrete Strategy for Bitcoin Payment
class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bitcoin [Wallet Address: " + walletAddress + "]");
    }
}

// ShoppingCart Class (Context)
class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private double totalAmount;

    public ShoppingCart() {
        this.totalAmount = 0.0;
    }

    public void addItem(double price) {
        totalAmount += price;
        System.out.println("Item added. Price: " + price);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment strategy before checkout.");
        } else {
            paymentStrategy.pay(totalAmount);
            totalAmount = 0.0; // Reset cart
        }
    }
}

// Main Class (Client Code)
public class Card {
    public static void main(String[] args) {
        // Create a Shopping Cart
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItem(150.0);
        cart.addItem(350.0);

        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "John Doe", "123"));
        cart.checkout();

        // Add more items
        cart.addItem(200.0);
        cart.addItem(400.0);

        // Pay using PayPal
        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        cart.checkout();

        // Add another item
        cart.addItem(500.0);

        // Pay using Bitcoin
        cart.setPaymentStrategy(new BitcoinPayment("1A2b3C4D5e6F"));
        cart.checkout();
    }
}
