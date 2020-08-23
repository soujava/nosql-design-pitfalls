package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.eclipse.jnosql.artemis.cassandra.column.UDT;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Contact {

    @Id
    private String name;

    @Column
    private LocalDate birthday;

    @Column
    private Map<String, String> details;

    @UDT("address")
    private Address address;

    Contact() {
        this.details = new HashMap<>();
    }

    private Contact(String name, LocalDate birthday, Address address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.details = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public Address getAddress() {
        return address;
    }

    public static ContactBuilder builder() {
        return new ContactBuilder();
    }

    public static class ContactBuilder {
        private String name;
        private LocalDate birthday;
        private Address address;

        private ContactBuilder() {
        }

        public ContactBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ContactBuilder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }


        public ContactBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Contact build() {
            return new Contact(name, birthday, address);
        }
    }
}
