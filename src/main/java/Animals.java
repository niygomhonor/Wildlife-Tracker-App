import org.sql2o.Connection;

import java.util.ArrayList;

class Animals {
public int id;
public String name;

public Animals(String name){
    this.name=name;

}

     public static ArrayList<Animals> all() {
         try(Connection con = Database.sql2o.open()) {
             String sql = "SELECT * FROM animals;";
             return (ArrayList<Animals>) con.createQuery(sql)
                     .throwOnMappingFailure(false)
                     .executeAndFetch(Animals.class);
         }
     }

    public static Animals find(int id) {
        try(Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id;";
            Animals animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animals.class);
            return animal;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    @Override
     public boolean equals(Object otherAnimal) {
         if(!(otherAnimal instanceof Animals)) {
             return false;
         } else {
             Animals newAnimal = (Animals) otherAnimal;
             return this.getName().equals(newAnimal.getName());
         }
     }
     public String getName() {
    return name;
     }

     public int getAnimalId() {
    return id;
     }

    public void save() {
        try(Connection con = Database.sql2o.open()){
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true).addParameter("name", this.name).throwOnMappingFailure(false).executeUpdate().getKey();
        }
    }


//     public static List<Animal> all() {
//    return Animals;
//     }


 }
