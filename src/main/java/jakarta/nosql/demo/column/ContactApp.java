package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.column.ColumnTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class ContactApp {

    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ColumnTemplate template = container.select(ColumnTemplate.class).get();

        }
    }
}
