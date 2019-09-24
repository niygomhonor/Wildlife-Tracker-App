import org.junit.Test;

import java.util.Date;
import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingsTest {
    @Test
    public void instantiating_done_correctly() {
        Sightings sighting = new Sightings("Zone C", "Jack");
        assertEquals(true, sighting instanceof Sightings);
    }

    @Test
    public void getName_personInstantiatesWithName_John() {
        Sightings testSighting = new Sightings("Jack", "North Forest");
        assertEquals("John", testSighting.getRangerName());
    }

    @Test
    public void getAnimalId_instantiatesWithAnimalId_int() {
        Sightings testSighting = new Sightings("Zone A", "Jack");
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    public void getLocation_sightingInstatiatesWithLocation_StrJacking() {
        Sightings testSighting = new Sightings("Zone A", "Jose");
        assertEquals("North Forest", testSighting.getLocation());
    }

    @Test
    public void equals_returnsTrueIfNameAndLocationAreSame_true() {
        Sightings testSighting = new Sightings("Zone A", "Jack");
        Sightings secondSighting = new Sightings("Zone B", "John");
        assertTrue(testSighting.equals(secondSighting));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Sighting() {
        Sightings testSighting = new Sightings("Zone A", "Jack");
        testSighting.save();
        assertTrue(Sightings.all().get(0).equals(testSighting));
    }

    @Test
    public void all_returnsAllInstancesOfASighting() {
        Sightings firstSighting = new Sightings("Zone A", "Jacky");
        firstSighting.save();
        Sightings secondSighting = new Sightings("Zone C", "Honoria");
        secondSighting.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSighting));
        assertEquals(true, Sightings.all().get(1).equals(secondSighting));
    }

    @Test
    public void save_assignedIdToSavedObjects() {
        Sightings testSighting = new Sightings("Zone A", "Jacky");
        testSighting.save();
        Sightings anotherSighting = Sightings.all().get(0);
        assertEquals(testSighting.getId(), anotherSighting.getId());
    }

    @Test
    public void find_findObjectWithId() {
        Sightings testSighting = new Sightings("Zone A", "Honoria");
        testSighting.save();
        Sightings secondSighting = new Sightings("Zone C", "Gloria");
        secondSighting.save();
        assertEquals(Sightings.find(secondSighting.getAnimalId()), secondSighting);
    }

    @Test
    public void sighting_registersTheTimeOfSighting() {
        Sightings testSighting = new Sightings("Zone A", "Jose");
        testSighting.save();
        Timestamp savedTestSighting = Sightings.find(testSighting.getId()).getLastDate();
        Timestamp rightNow = new Timestamp(new Date().getTime());
        assertEquals(savedTestSighting.getDay(), rightNow.getDay());

    }
}