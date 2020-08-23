package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

@Entity
class Ingredient {

    @Column
    private Double quantity;

    @Column
    private String unit;

    public Ingredient(Double quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public Ingredient() {
    }
}
