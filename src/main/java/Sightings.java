import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public class Sightings implements Data {
    public String rangerName;
    private int animal_Id;
    private String location;
    private int id;
    private Timestamp lastDate;

    public Sightings(String location, String rangerName) {
        this.animal_Id = animal_Id;
        this.location = location;
        this.rangerName = rangerName;
        this.lastDate = lastDate;


    }

    public static Sightings find(int id) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id = :id";
            Sightings sighting = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(Sightings.class);
            return sighting;
        }
    }

    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings";
        try (Connection con = Database.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(Sightings.class);
        }
    }

    @Override
    public boolean equals(Object otherSighting) {
        if (!(otherSighting instanceof Sightings)) {
            return false;
        } else {
            Sightings newSighting = (Sightings) otherSighting;
            return this.getAnimalId() == (newSighting.getAnimalId()) && this.getLocation()
                    .equals(newSighting.getLocation()) && this.getRangerName().equals(newSighting.getRangerName());
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

    public Timestamp getLastDate() {
        return lastDate;
    }

    @Override
    public void save() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO sightings (rangerName, location, lastDate) VALUES (:rangerName, :location, now())";
            this.id = (int) con.createQuery(sql, true).addParameter("rangerName", this.rangerName).addParameter("location", this.location).throwOnMappingFailure(false).executeUpdate().getKey();
        }
    }
}
