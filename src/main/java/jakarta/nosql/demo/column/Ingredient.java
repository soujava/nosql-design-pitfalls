package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
class Ingredient {

    @Column
    private String name;

    @Column
    private BigDecimal quantity;

    @Column
    private String unit;

    public Ingredient(String name, Double quantity, String unit) {
        this.quantity = BigDecimal.valueOf(quantity);
        this.unit = unit;
        this.name = name;
    }

    public Ingredient() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredient that = (Ingredient) o;
        return Objects.equals(quantity, that.quantity) &&
                Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, unit);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
