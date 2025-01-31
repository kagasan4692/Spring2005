package data.data_sources.order;

import data.moduls.Order;

public class MockOrderDataSourceImpl extends OrderDataSource{
    private Order order;

    @Override
    public void createOrder(Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder(Order order) {
        return order;
    }
}
