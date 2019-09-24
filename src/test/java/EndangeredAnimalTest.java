import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Test

    public void EndangeredAnimal_Instantiating_correctly() {

        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Elephant","healthy","adult");



        assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {

        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Elephant","healthy","adult");
//        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("dog","healthy","adult");

//        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }
    @Test
    public void Animals_instantiatesWithName_String(){
        EndangeredAnimal endangeredAnimal  = new EndangeredAnimal("Dog", "healthy", "young");


        assertEquals(endangeredAnimal.getName(), "Dog");
    }
    @Test
    public void Animals_instantiatesWithHealth_String(){

        EndangeredAnimal endangeredAnimal  = new EndangeredAnimal("Lion", "healthy", "young");


        assertEquals(endangeredAnimal .getHealth(), "healthy");
    }
    @Test
    public void equals_returnsTrueIfNamesAreTheSame(){

        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Lion", "healthy", "young");
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Lion", "healthy", "young");

        assertTrue(endangeredAnimal .equals(secondEndangeredAnimal));
    }
    @Test
    public void save_returnsTrueIfDescriptionIsSame(){


        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", "healthy", "young");


        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

}
