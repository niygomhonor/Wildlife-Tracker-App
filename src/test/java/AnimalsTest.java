import org.junit.Test;

import static org.junit.Assert.*;


public class AnimalsTest {
    @Test
    public void Animals_instantiatesCorrectly_true() {
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
            @Test
  public void find_returnsAnimalWithSameId_secondAnimal() {
    Animals firstAnimal = new Animals("Deer");
    firstAnimal.save();
    Animals secondAnimal = new Animals("Black Bear");
    secondAnimal.save();
    assertEquals(Animals.find(secondAnimal.getAnimalId()), secondAnimal);
  }
}