package patterns.behavioral.chainofresponsibility;

/**
 *   Chain of Responsibility (Цепочка обязанностей)
 *   Позволяет избежать жесткой зависимости отправителя запроса от его получателя, при этом запрос может быть обработан несколькими объектами.
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Payment visaPayment = new VisaPayment();
        Payment payPalPayment = new PayPalPayment();
        visaPayment.setNext(payPalPayment);
        visaPayment.pay();
    }
}

interface Payment {
    void setNext(Payment payment);

    void pay();
}

class VisaPayment implements Payment {
    private Payment payment;

    public void setNext(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        System.out.println("Visa Payment");
    }
}

class PayPalPayment implements Payment {
    private Payment payment;

    public void setNext(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        System.out.println("PayPal Payment");
    }
}

