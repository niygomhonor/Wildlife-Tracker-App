import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

class Animals extends All implements Data {
    private int sightingId;
    private String name;
    private int id;


    public Animals(String name) {
        this.name = name;
//    this.sightingId =sightingId;
        this.endangered = false;
    }

    public static ArrayList<Animals> all() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM animals;";
            return (ArrayList<Animals>) con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class);
        }
    }

    public static Animals find(int id) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id;";
            Animals animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animals.class);
            return animal;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public static String getAnimalName(int id) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT name FROM animals WHERE id = :id;";
            String name = con.createQuery(sql).addParameter("id", id).executeScalar(String.class);
            return name;
        }
    }

    public static String getAnimalHealth(int id) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT health FROM animals WHERE id = :id;";
            String name = con.createQuery(sql).addParameter("id", id).executeScalar(String.class);
            return name;
        }
    }

    public static String getAnimalAge(int id) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT age FROM animals WHERE id = :id;";
            String name = con.createQuery(sql).addParameter("id", id).executeScalar(String.class);
            return name;
        }
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Animals)) {
            return false;
        } else {
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getSightingId() == newAnimal.getSightingId();
        }
    }

    public String getName() {
        return name;
    }
//     public static List<Animal> all() {
//    return Animals;
//     }

    public int getSightingId() {
        return sightingId;
    }

    @Override
    public void save() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true).addParameter("name", this.name).throwOnMappingFailure(false).executeUpdate().getKey();
        }

    }

    public List<Sightings> getSightings() {

        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM sightings where animal_Id =:id";
            return con.createQuery(sql).addParameter("id", this.id).executeAndFetch(Sightings.class);
        }
    }


}
