import org.junit.Test;

import static org.junit.Assert.*;


public class AnimalsTest {
    @Test


    public void Animals_instantiatesCorrectly_true() throws Exception {

        Animals animalTest = new Animals("Dog");
        assertEquals(true, animalTest instanceof Animals);

    }

    public void Animals_instantiating_WithName_String() {
        Animals animalTest = new Animals("Dog");
        assertEquals("Dog", animalTest.getName());
    }



    @Test
    public void equals_returnsTrueIfNameIsTheSame(){

        Animals animalTest=new Animals("Dog");
        Animals secondAnimal=new Animals("Deer");
        assertTrue(String.valueOf(animalTest),equals(secondAnimal));
    }

}
