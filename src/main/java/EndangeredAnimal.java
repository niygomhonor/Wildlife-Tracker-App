import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animals  {
    public String name;
    public int id;
    public String health;
public String age;
    public static final String health_one="Healthy";
 public static final String health_two="okay";
   public static final String health_three="ill";
 public static final String age_y="Young";
   public static final String age_n="Newborn";
  public static final String age_a="Adult";



    public  EndangeredAnimal(String name,String health,String age){
        super(name);
        this.health=health;
        this.age=age;
    }


    public static EndangeredAnimal find(int id){
        try(Connection con = Database.sql2o.open()){
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }


    @Override
    public boolean equals(Object otherEndangeredAnimal) {
        if(!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
            return this.getName().equals(newEndangeredAnimal.getName());
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }
}
