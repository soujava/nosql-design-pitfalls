package jakarta.nosql.demo.temp;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import org.eclipse.jnosql.artemis.cassandra.column.UDT;

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

}
