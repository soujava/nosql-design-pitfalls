package jakarta.nosql.demo.column;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.eclipse.jnosql.artemis.cassandra.column.UDT;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    private String name;

    @Column
    private String city;

    @Column
    @UDT("ingredient")
    private Set<Ingredient> ingredients;

    public Recipe() {
        this.ingredients = new HashSet<>();
    }

    public Recipe(String name, String city) {
        this.name = name;
        this.city = city;
        this.ingredients = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Set<Ingredient> getIngredients() {
        return Collections.unmodifiableSet(ingredients);
    }

    public void add(Ingredient ingredient) {
        this.ingredients.add(Objects.requireNonNull(ingredient, "ingredient is required"));
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
