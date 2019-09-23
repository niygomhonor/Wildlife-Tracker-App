import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {


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

//            boolean endangered = req.queryParams("endangered") != null;
//            if (endangered) {
//                String name = req.queryParams("name");
//                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name);
//                endangeredAnimal.save();
//
//            } else {
//                String name = req.queryParams("name");
//                Animals animal = new Animals(name);
//                animal.save();
//            }
            return new ModelAndView(model, "animals-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            boolean endangered = req.queryParams("endangered") != null;
            if (endangered) {
                String age = req.queryParams("age");
                String animalName = req.queryParams("animalName");
                String health = req.queryParams("health");
                String rangerName = req.queryParams("rangerName");
                String location = req.queryParams("location");
                int sightingId = Integer.parseInt(req.queryParams("sightingId"));
                model.put("age", age);
                model.put("health", health);
                model.put("rangerName", rangerName);
                model.put("location", location);
                model.put("animalName", animalName);
                model.put("sightingId", sightingId);
            }
            else {

                String age = req.queryParams("age");
                String animalName = req.queryParams("animalName");
                String health = req.queryParams("health");
                String rangerName = req.queryParams("rangerName");
                String location = req.queryParams("location");
                int sightingId = Integer.parseInt(req.queryParams("sightingId"));
                model.put("age", age);
                model.put("health", health);
                model.put("rangerName", rangerName);
                model.put("location", location);
                model.put("animalName", animalName);
                model.put("sightingId", sightingId);
            }
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("allAnimals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("allSightings", Sightings.all());
            return new ModelAndView(model, "animal-details.hbs");

        }, new HandlebarsTemplateEngine());

        get("/animals/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int animalId=Integer.parseInt(req.queryParams("id"));
           Animals.find(animalId);
            return new ModelAndView(model, "animal-details.hbs");
        } ,new HandlebarsTemplateEngine());

        get("/endangeredAnimal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangeredAnimals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String nameOfAnimal = request.queryParams("nameOfAnimal");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String rangerName = request.queryParams("rangerName");
            String location = request.queryParams("location");
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(nameOfAnimal, health, age);
            endangeredAnimal.save();
            Sightings sighting = new Sightings(location,rangerName);
            sighting.save();
//            model.put("endangeredAnimal",endangeredAnimal);
            model.put("age",age);
            model.put("health",health);
            model.put("nameOfAnimal",nameOfAnimal);
            model.put("rangerName",rangerName);
            model.put("location",location);
            return new ModelAndView(model, "endangered-details.hbs");
        }, new HandlebarsTemplateEngine());

    }
}