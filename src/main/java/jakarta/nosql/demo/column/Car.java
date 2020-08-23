package jakarta.nosql.demo.column;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.eclipse.jnosql.artemis.cassandra.column.UDT;

import java.util.Objects;

@Entity
class Car {

    @Id
    private String plate;

    @Column
    private String city;

    @Column
    private String color;

    @Column
    @UDT("owner")
    private Owner owner;

    private Car(String plate, String city, String color, Owner owner) {
        this.plate = plate;
        this.city = city;
        this.color = color;
        this.owner = owner;
    }

    Car() {
    }

    public String getPlate() {
        return plate;
    }

    public String getCity() {
        return city;
    }

    public String getColor() {
        return color;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(plate, car.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plate);
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", city='" + city + '\'' +
                ", color='" + color + '\'' +
                ", owner=" + owner +
                '}';
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public static class CarBuilder {
        private String plate;
        private String city;
        private String color;
        private Owner owner;

        private CarBuilder() {
        }

        public CarBuilder withPlate(String plate) {
            this.plate = plate;
            return this;
        }

        public CarBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public CarBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder withOwner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public Car build() {
            return new Car(plate, city, color, owner);
        }
    }
}
