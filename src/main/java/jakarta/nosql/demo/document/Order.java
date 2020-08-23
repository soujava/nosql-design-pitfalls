package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {

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
    }

    Order() {
        this.items = new ArrayList<>();
    }

    public void add(Product item) {
        this.items.add(Objects.requireNonNull(item, "item is required"));
    }

    public List<Product> getItems() {
        return items;
    }
}
