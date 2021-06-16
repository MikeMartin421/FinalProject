package java_final_spring;

import java_final_spring.interfaces.IPayment;
import java_final_spring.interfaces.IPayment.PaymentMethod;

public class DebitCard implements IPayment {

	@Override
	public PaymentMethod getPaymentMethod() {
		// TODO Auto-generated method stub
		return PaymentMethod.DEBITCARD;
	}

	@Override
	public void pay(double charge) {
		// TODO Auto-generated method stub
		System.out.println("Debit Card has been charged $" + charge);
	}

	@Override
	public String getPaymentName() {
		// TODO Auto-generated method stub
		return PaymentMethod.DEBITCARD.toString();
	}

}
