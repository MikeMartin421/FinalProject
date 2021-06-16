package java_final_spring.interfaces;

public interface IPayment {
	public enum PaymentMethod {
        CREDITCARD,
        DEBITCARD,
        CASH
    }
	PaymentMethod getPaymentMethod();
	String getPaymentName();
	void pay(double charge);
}
