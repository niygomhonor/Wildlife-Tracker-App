import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest {
    @Test

    public void EndangeredAnimal_Instantiating_correctly() {

        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Elephant");
        assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

}
