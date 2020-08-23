package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.Objects;

@Entity
public class Address {

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String postalCode;

    @Column
    private String region;

    Address() {
    }

    Address(String city, String country, String postalCode, String region) {
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(country, address.country) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(region, address.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, postalCode, region);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private String city;
        private String country;
        private String postalCode;
        private String region;

        private AddressBuilder() {
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Address build() {
            return new Address(city, country, postalCode, region);
        }
    }
}
