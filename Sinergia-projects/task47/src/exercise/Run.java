package exercise;

import java.util.PriorityQueue;

public class Run {
    public static void main(String[] args) {
        PriorityQueue<Customer> queue = new PriorityQueue<>((o1, o2) -> Customer.compareByLoyaltyPoints(o1, o2));

        queue.add(new Customer("user1", 4));
        queue.add(new Customer("user2", 2));
        queue.add(new Customer("user3", 10));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}

class Customer {
    String fullName;
    int loyaltyPoints;

    public Customer(String fullName, int loyaltyPoints) {
        this.fullName = fullName;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName = " + fullName + '\'' +
                ", loyaltyPoints = " + loyaltyPoints +
                '}';
    }

    public static int compareByLoyaltyPoints(Customer c1, Customer c2) {
        return Integer.compare(c2.loyaltyPoints, c1.loyaltyPoints);
    }
}
