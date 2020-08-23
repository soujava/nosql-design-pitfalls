package jakarta.nosql.demo.column;

import jakarta.nosql.column.ColumnQuery;
import jakarta.nosql.mapping.column.ColumnTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import static jakarta.nosql.column.ColumnQuery.select;

public class CarApp {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ColumnTemplate template = container.select(ColumnTemplate.class).get();
            Owner owner = new Owner("Otavio Santana", "BA12365478");
            Car car = Car.builder()
                    .withCity("Salvador")
                    .withColor("blue")
                    .withPlate("2345678BS")
                    .withOwner(owner)
                    .build();

            template.insert(car);

            ColumnQuery query = select().from("Car").where("_id").eq("2345678BS").build();
            template.select(query).forEach(System.out::println);

        }
    }
}
