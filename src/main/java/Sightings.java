import java.sql.Timestamp;

public class Sightings {
    private int animal_Id;
    public String rangerName;
    private String location;
    private int id;
    private Timestamp date;

    public Sightings(int animal_Id, String location, String rangerName) {
        this.animal_Id = animal_Id;
        this.location = location;
        this.rangerName = rangerName;
        this.id = id;
        this.date = date;
    }
    @Override
    public boolean equals(Object otherSighting) {
        if(!(otherSighting instanceof Sightings)) {
            return false;
        } else {
            Sightings newSighting = (Sightings) otherSighting;
            return this.getAnimalId() == (newSighting.getAnimalId()) && this.getLocation().equals(newSighting.getLocation()) && this.getRangerName().equals(newSighting.getRangerName());
        }
    }
    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animal_Id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Timestamp getDate() {
        return date;
    }
}
