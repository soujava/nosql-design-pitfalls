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
}
