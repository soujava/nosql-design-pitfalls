package jakarta.nosql.demo.document;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Address address = Address.builder()
                    .withCity("Salvador")
                    .withCountry("Brazil")
                    .withPostalCode("40235220")
                    .build();

            Order order = new Order(address);


        }
    }
}
