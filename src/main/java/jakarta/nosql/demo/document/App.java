package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.document.DocumentTemplate;
import org.javamoney.moneta.Money;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.Locale;

public class App {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            DocumentTemplate template = container.select(DocumentTemplate.class).get();

            Address address = Address.builder()
                    .withCity("Salvador")
                    .withCountry("Brazil")
                    .withPostalCode("40235220")
                    .build();

            CurrencyUnit dollar = Monetary.getCurrency(Locale.US);
            Order order = new Order(address);
            order.add(new Product("Pen", Money.of(1, dollar)));
            order.add(new Product("Notebook", Money.of(1_000, dollar)));
            order.add(new Product("Smartphone", Money.of(1_500, dollar)));

            template.insert(order);

            System.out.println(order);


        }
    }
}
