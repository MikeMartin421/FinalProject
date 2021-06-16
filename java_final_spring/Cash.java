package java_final_spring;

import java_final_spring.interfaces.IPayment;
import java_final_spring.interfaces.IPayment.PaymentMethod;

public class Cash implements IPayment{

	@Override
	public PaymentMethod getPaymentMethod() {
		// TODO Auto-generated method stub
		return PaymentMethod.CASH;
	}

	@Override
	public void pay(double charge) {
		// TODO Auto-generated method stub
		System.out.println("Cash accepted $" + charge);
		
	}

	@Override
	public String getPaymentName() {
		// TODO Auto-generated method stub
		return PaymentMethod.CASH.toString();
	}

}
