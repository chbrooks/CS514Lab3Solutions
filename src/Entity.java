import java.time.LocalDate;

public class Entity {
    String name;
    LocalDate dateCreated;

    public Entity() {
        name="";
        dateCreated = LocalDate.now();
    }

    public Entity(String n) {
        name = n;
        dateCreated = LocalDate.now();
    }

    /* Add setters and getters */

    public String getName() {
        return name;
    }

    public void setName(String inname) {
        this.name = inname;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate inDateCreated) {
        this.dateCreated = inDateCreated;
    }

    /* you complete this */
    public String toString() {
        return name;
    }
}
