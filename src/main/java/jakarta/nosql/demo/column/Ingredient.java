package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.Objects;

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
