import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalsTest {
    @Test
    public void Animals_instantiatesCorrectly_true() {
        Animals animalTest = new Animals("Dog", 1);
        assertEquals(true, animalTest instanceof Animals);

    }

    public void Animals_instantiating_WithName_String() {
        Animals animalTest = new Animals("Dog", 1);
        assertEquals("Dog", animalTest.getName());
    }

    @Test
    public void Animals_instantiatesWithAnimalId_int() {
        Animals animalTest = new Animals("Dog", 1);
        assertEquals(1, animalTest.getAnimalId());
    }
}