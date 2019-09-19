import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.github.jknack.handlebars.Handlebars;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {

//        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        get("/", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animals.all());
//            model.put("endangeredAnimals", EndangeredAnimal.all());
//            model.put("sightings", Sighting.all());


            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }

}