// These import statements are required.
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomTest {
    
    // This is a dummy test that will pass
    // Note the annotation @Test
    @Test
    public void testSuccess() {
        String x = "Rohan";
        
        /*
         * assertEquals takes in 2 or 3 arguments 
         * The first argument is the error message to
         * be printed if the test fails.
         * The second is the expected output.
         * The third is the actual output.
         */
        assertEquals("Rohan", x);
    }
    
    // This is a dummy test that will fail
    @Test
    public void testFailure() {
        String x = "Rahul";
        assertEquals("Rahul's test failed.", "Success", x);
    }
}