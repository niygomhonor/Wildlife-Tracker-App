import java.sql.Timestamp;
import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        staticFileLocation("/public");


        get("/", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("sightings", Sightings.all());


            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();


            return new ModelAndView(model, "animals-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String age = req.queryParams("age");
            String animalName = req.queryParams("animalName");
            String health = req.queryParams("health");
            String rangerName = req.queryParams("rangerName");
            String location = req.queryParams("location");
            EndangeredAnimal endangered = new EndangeredAnimal(animalName, health, age);
            endangered.save();
            Animals animal = new Animals(animalName);
            animal.save();
            Sightings sighting = new Sightings(location, rangerName);
            sighting.save();
            model.put("age", age);
            model.put("health", health);
            model.put("animalName", animalName);
            model.put("rangerName", rangerName);
            model.put("location", location);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("allAnimals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("allSightings", Sightings.all());
            return new ModelAndView(model, "animal-details.hbs");

        }, new HandlebarsTemplateEngine());



        get("/welcome", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "welcome_post.hbs");
        }, new HandlebarsTemplateEngine());


    }
}