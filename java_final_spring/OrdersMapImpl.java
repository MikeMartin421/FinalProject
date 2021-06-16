package java_final_spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {
	Map<String, List<TacoImpl>> tacoMap = new HashMap<>();

    @Override
    public void createOrder(final String orderid) {
    	List<TacoImpl> taco = new ArrayList<>(); 
    	tacoMap.put(orderid, taco);
    	
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	if(tacoMap.containsKey(orderid)) {
    		List<TacoImpl> tacoList = tacoMap.get(orderid);
    		tacoList.add(taco);
    	}
    	else throw new OrderDoesNotExistException(orderid);
    }

    @Override
    public boolean hasNext() {
    	if(tacoMap.isEmpty())
    		return false;
    	return true;
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	if(tacoMap.containsKey(orderid)) {
    		List<TacoImpl> tacoList = tacoMap.get(orderid);
    		tacoMap.remove(orderid);
    		return tacoList;
    	}
    	else throw new OrderDoesNotExistException(orderid);
    }

    @Override
    public int howManyOrders() {
        return tacoMap.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
    	if(tacoMap.containsKey(orderid)) {
    		List<TacoImpl> tacoList = tacoMap.get(orderid);
    		return tacoList;
    	}
    	else throw new OrderDoesNotExistException(orderid);
    }
}
