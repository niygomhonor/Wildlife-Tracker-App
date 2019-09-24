

import org.junit.Test;
import static org.junit.Assert.*;

public class SightingsTest {

    @Test
    public void Sighting_instantiatesCorrectly_true() {
        Sightings testSighting = new  Sightings("Zone A","Jack");
        assertEquals(true, testSighting instanceof Sightings);
    }

    @Test
    public void getLocation_sightingInstantiatesWithLocation_ZoneA() {
        Sightings testSighting =  new  Sightings("Zone A","Jack");
        assertEquals("Zone A", testSighting.getLocation());
    }

    @Test
    public void getRangerName_sightingInstantiatesWithRangerName_String() {
        Sightings testSighting =  new  Sightings("Zone A","Jack");
        assertEquals("Henry", testSighting.getRangerName());
    }

    @Test
    public void equals_returnsTrueIfLocationAndRangerNameAreSame_true() {
        Sightings firstSighting = new  Sightings("Zone A","Jack");
        Sightings anotherSighting =  new  Sightings("Zone A","Jack");
        assertTrue(firstSighting.equals(anotherSighting));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Sighting() {
        Sightings testSighting =  new  Sightings("Zone A","Jack");
        testSighting.save();
        assertTrue(Sightings.all().get(0).equals(testSighting));
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sightings firstSighting =  new  Sightings("Zone A","Jack");
        firstSighting.save();
        Sightings secondSighting =  new  Sightings("Zone A","Jack");
        secondSighting.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSighting));
        assertEquals(true, Sightings.all().get(1).equals(secondSighting));
    }





    @Test
    public void getAnimals_retrievesAllAnimalsFromDatabase_animalsList() {
        Sightings testSighting = new Sightings("Zone A","Henry");
        testSighting.save();
        Animals firstAnimal = new Animals("Bubbles");
        firstAnimal.save();
        Animals secondAnimal2 = new Animals("Spud");
        secondAnimal2.save();

    }


}