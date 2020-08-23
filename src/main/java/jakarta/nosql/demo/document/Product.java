package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;

import javax.money.MonetaryAmount;

@Entity
public class Product {

    @Column
    private String name;

    @Column
    @Convert(MoneyConverter.class)
    private MonetaryAmount value;

    Product(String name, MonetaryAmount value) {
        this.name = name;
        this.value = value;
    }

    Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
