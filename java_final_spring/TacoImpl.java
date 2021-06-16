package java_final_spring;

import java.util.UUID;

public class TacoImpl {

    public enum Protien {
        CHICKEN,
        BEEF,
        PORK,
        BEAN,
        FISH,
        LOBSTER,
        SHRIMP
       
    }

    private Protien protien;

    @Override
	public String toString() {
    	//With or without cheese output
    	if(hasCheeze)
    		return "Your order is " + protien + " with Cheese";
    	else return "Your order is " + protien + " without Cheese";
	}

	private boolean hasCheeze;

    public final UUID orderNumber = UUID.randomUUID();

    public TacoImpl(Protien protien, boolean hasCheeze) {
        this.protien = protien;
        this.hasCheeze = hasCheeze;
    }

    public boolean equals(TacoImpl tacoOrder) {
        return this.orderNumber.equals(tacoOrder.orderNumber);
    }
}
