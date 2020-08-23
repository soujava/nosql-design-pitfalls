package jakarta.nosql.demo.document;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

@Entity
public class Address {

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String postalCode;

    @Column
    private String region;


}
