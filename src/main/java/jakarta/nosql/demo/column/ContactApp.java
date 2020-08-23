package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.column.ColumnTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.time.LocalDate;

import static java.time.Month.MARCH;

public class ContactApp {

    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ColumnTemplate template = container.select(ColumnTemplate.class).get();

            Address address = Address.builder()
                    .withCity("Sao Paulo")
                    .withCountry("Brazil")
                    .withPostalCode("01312001")
                    .build();

            Contact contact = Contact.builder()
                    .withAddress(address)
                    .withBirthday(LocalDate.of(1992, MARCH, 27))
                    .withName("Poliana").build();

            contact.put("twitter", "twitter");
            contact.put("phone", "123456789");
            contact.put("facebook", "poliana_facebook");

            template.insert(contact);

            System.out.println(contact);
        }
    }
}
