package java_final_spring;

public class OrderDoesNotExistException extends Exception {

    /**
     * Const.
     * @param orderid The order id that does not exist.
     */
    public OrderDoesNotExistException(String orderid) {
        super("Order Does Not Exist for Order id: " +  orderid);
    }
}
