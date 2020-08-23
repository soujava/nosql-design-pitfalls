package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Id;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    @Id
    private ObjectId id;

    @Column
    private LocalDateTime orderedAt;

    @Column
    private List<Product> products;

    @Column
    private Address shipTo;
}