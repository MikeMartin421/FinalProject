package java_final_spring;

import java.util.List;

public class OrdersTest {

    public static void main(String[] args) throws OrderDoesNotExistException {
        OrdersTest ordersTest = new OrdersTest();
        ordersTest.testHasNextFalse();
        ordersTest.testCloseNextOrder();
    }

    public void testHasNextFalse() throws OrderDoesNotExistException {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);

        OrdersMapImpl orders = new OrdersMapImpl();
        orders.addTacoToOrder("1", firstTaco);
        if (!orders.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should have one order in them.");
        }
        List<TacoImpl> closedTaco = orders.closeOrder("1");
        if (closedTaco == null) {
            throw new RuntimeException(":( testHasNextFalse fail: closed taco should not be null.");
        }
        if (!closedTaco.equals(firstTaco)) {
            throw new RuntimeException(":( testHasNextFalse fail: This should truely never happen.");
        }
        if (orders.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) testHasNextFalse passed");
    }

    public void testCloseNextOrder() throws OrderDoesNotExistException {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);
        TacoImpl secondTaco = new TacoImpl(TacoImpl.Protien.BEEF, true);

        OrdersMapImpl orders = new OrdersMapImpl();
        orders.addTacoToOrder("1", firstTaco);
        orders.addTacoToOrder("2", secondTaco);
        List<TacoImpl> shouldBeFirstTaco = orders.closeOrder("2");
        if (orders.howManyOrders() != 1) {
            throw new RuntimeException(":( testCloseNextOrder Failed: orders should only have one order left");
        }
        if (firstTaco.equals(shouldBeFirstTaco)){
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first taco was first out.");
        }
    }
}
