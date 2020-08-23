package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.Objects;

@Entity
class Owner {

    @Column
    private String name;

    @Column
    private String license;

    Owner() {
    }

    Owner(String name, String license) {
        this.name = name;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Owner owner = (Owner) o;
        return Objects.equals(name, owner.name) &&
                Objects.equals(license, owner.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, license);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}
