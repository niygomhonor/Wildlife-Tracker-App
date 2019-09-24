import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SightingsTest {
    @Test
    public void instatianing_done_correctly(){
        Sightings sighting=new Sightings(1,"near river","Jack");
assertEquals(true,sighting instanceof Sightings );
    }


}
