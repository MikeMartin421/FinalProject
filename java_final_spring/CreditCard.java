package java_final_spring;

import java_final_spring.interfaces.IPayment;

public class CreditCard implements IPayment {

	@Override
	public PaymentMethod getPaymentMethod() {
		// TODO Auto-generated method stub
		return PaymentMethod.CREDITCARD;
	}
	
	@Override
	public void pay(double charge) {
		// TODO Auto-generated method stub
		System.out.println("Credit Card has been charged $" + charge );
		
	}

	@Override
	public String getPaymentName() {
		// TODO Auto-generated method stub
		return PaymentMethod.CREDITCARD.toString();
	}

}
