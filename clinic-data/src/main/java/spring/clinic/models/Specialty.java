package spring.clinic.models;

public class Specialty extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "description='" + description + '\'' +
                '}';
    }
}
