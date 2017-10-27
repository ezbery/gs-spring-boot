// tag::sample[]
package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    protected Userer() {
    }

    public Userer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Userer[id=%d, name='%s']",
                id, name);
    }

// end::sample[]

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

