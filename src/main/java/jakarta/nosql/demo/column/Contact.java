package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.eclipse.jnosql.artemis.cassandra.column.UDT;

import java.time.LocalDate;
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
    }

    private Contact(String name, LocalDate birthday, Map<String, String> details, Address address) {
        this.name = name;
        this.birthday = birthday;
        this.details = details;
        this.address = address;
    }

    public class ContactBuilder {
        private String name;
        private LocalDate birthday;
        private Map<String, String> details;
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

        public ContactBuilder withDetails(Map<String, String> details) {
            this.details = details;
            return this;
        }

        public ContactBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Contact build() {
            return new Contact(name, birthday, details, address);
        }
    }
}
