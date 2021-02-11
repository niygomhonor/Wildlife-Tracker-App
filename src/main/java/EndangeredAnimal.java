import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends All implements Data {
    public String name;
    public int id;

    private String health;
    private String age;

    public EndangeredAnimal(String name, String health, String age) {
        this.name = name;
        this.id = id;
        this.health = health;
        this.age = age;
        this.endangered = true;
    }

    public static List<EndangeredAnimal> all() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals;";
            return con.createQuery(sql)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals WHERE id=:id;";
            EndangeredAnimal endangeredanimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return endangeredanimal;
        }
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherEndangeredAnimal) {
        if (!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
            return this.getName().equals(newEndangeredAnimal.getName()) && this.getHealth().equals(newEndangeredAnimal.getHealth()) && this.getAge().equals(newEndangeredAnimal.getAge());
        }
    }

    @Override
    public void save() {

        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO endangered_animals (name, health, age) VALUES (:name, :health, :age);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void updateHealth(String health) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "UPDATE endangered_animals SET health=:health WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("health", health)
                    .executeUpdate();
        }
    }

    public void updateAge(String age) {
        try (Connection con = Database.sql2o.open()) {
            String sql = "UPDATE endangered_animals SET age=:age WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("age", age)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public List<Sightings> getSightings() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animal_id=:id;";
            List<Sightings> sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Sightings.class);
            return sightings;
        }
    }


}


