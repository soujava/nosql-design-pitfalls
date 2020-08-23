package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
class Order {

    @Id
    private ObjectId id;

    @Column
    private LocalDateTime orderedAt;

    @Column
    private List<Product> items;

    @Column
    private Address shipTo;

    Order(Address shipTo) {
        this.shipTo = shipTo;
        this.items = new ArrayList<>();
        this.orderedAt = LocalDateTime.now();
    }

    Order() {
        this.items = new ArrayList<>();
        this.orderedAt = LocalDateTime.now();
    }

    public void add(Product item) {
        this.items.add(Objects.requireNonNull(item, "item is required"));
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public ObjectId getId() {
        return id;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public Address getShipTo() {
        return shipTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderedAt=" + orderedAt +
                ", items=" + items +
                ", shipTo=" + shipTo +
                '}';
    }
}
