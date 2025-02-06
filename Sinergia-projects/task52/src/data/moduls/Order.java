package data.moduls;

import java.util.Collections;
import java.util.List;

public class Order {
    private final String name;
    private final String phone;
    private final String address;
    private final String paymentType;
    private final String deliveryTime;
    private final List<CartItem> cart;

    public Order(String name, String phone, String address, String paymentType, String deliveryTime, List<CartItem> cart) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.cart = Collections.unmodifiableList(cart);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public List<CartItem> getCart() {
        return cart;
    }
}
