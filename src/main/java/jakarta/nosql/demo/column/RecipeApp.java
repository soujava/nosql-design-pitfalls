package jakarta.nosql.demo.column;

import jakarta.nosql.column.ColumnQuery;
import org.eclipse.jnosql.artemis.cassandra.column.CassandraTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class RecipeApp {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            CassandraTemplate template = container.select(CassandraTemplate.class).get();
            Recipe recipe = new Recipe("Bauru", "Bauru");
            recipe.add(new Ingredient("French bun with crumb", 1D, "unit"));
            recipe.add(new Ingredient("Cheese", 300D, "grams"));
            recipe.add(new Ingredient("Roast beef", 500D, "grams"));
            recipe.add(new Ingredient("Pickled cucumber", 150D, "grams"));
            recipe.add(new Ingredient("Tomato", 100D, "grams"));

            template.insert(recipe);

            ColumnQuery query = ColumnQuery.select().from("Recipe").where("_id").eq("Bauru").build();
            template.select(query).forEach(System.out::println);

        }
    }
}
