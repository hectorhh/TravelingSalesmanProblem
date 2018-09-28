/**
 * Name : Hector Herrera
 * PennKey : Hectorh
 * Recitation : 216
 * 
 * Execution: java Tour
 * 
 * This program will do junit testing for tour.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TourTest {
    //test distance with two points
    @Test
    public void testSimpleTourDistance() {
        Tour empty = new Tour();
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        empty.insertInOrder(a);
        empty.insertInOrder(b);
        double expected = 2 * Math.sqrt(2);
        double actual = empty.distance();
        assertEquals(expected, actual, 0);
    }
    //test distance with a null point
    @Test
    public void testNullPointDistance() {
        Tour empty = new Tour();
        Point a = null;
        empty.insertInOrder(a);
        double expected = 0;
        double actual = empty.distance();
        assertEquals(expected, actual, 0);
    }
    //test distance with the same point
    @Test
    public void testSamePointDistance() {
        Tour empty = new Tour();
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(1, 1);
        Point d = new Point(1, 1);
        double expected = 2 * Math.sqrt(2);
        empty.insertInOrder(a);
        empty.insertInOrder(b);
        empty.insertInOrder(c);
        empty.insertInOrder(d);
        double actual = empty.distance();
        assertEquals(expected, actual, 0);
    }
   //test distance when the the points are put out of order
    @Test
    public void testOutofOrderPointsDistance() {
        Tour empty = new Tour();
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(1, 1);
        Point d = new Point(1, 1);
        double expected = 2 * Math.sqrt(2);
        empty.insertNearest(b);
        empty.insertNearest(c);
        empty.insertNearest(a);
        empty.insertNearest(d);
        double actual = empty.distance();
        assertEquals(expected, actual, 0);
    }
    
    //compare insertSmallest and insertInOrder
    @Test
    public void testMethods() {
        Tour empty = new Tour();
        Tour tour = new Tour();
        Point a = new Point(0, 51);
        Point b = new Point(0, .52);
        Point c = new Point(0, 1);
        Point d = new Point(0,.5);
        
        empty.insertSmallest(a);
        empty.insertSmallest(b);
        empty.insertSmallest(c);
        empty.insertSmallest(d);
        
        tour.insertInOrder(a);
        tour.insertInOrder(b);
        tour.insertInOrder(c);
        tour.insertInOrder(d);
        
        double insertSmallest = empty.distance();
        double insertInOrder = tour.distance();
        
        assertTrue("FAILURE", insertSmallest != insertInOrder);
    }
    
    //test size when it is null
    @Test
    public void testNullPointSize() {
        Tour empty = new Tour();
        Point a = null;
        empty.insertInOrder(a);
        int expected = 0;
        int actual = empty.size();
        assertEquals(expected, actual, 0);
    }
    //test size when there are same points
    @Test
    public void testAddSamePointSize() {
        Tour empty = new Tour();
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(1, 1);
        Point d = new Point(1, 1);
        empty.insertInOrder(a);
        empty.insertInOrder(b);
        empty.insertInOrder(c);
        empty.insertInOrder(d);
        int expected = 4;
        int actual = empty.size();
        assertEquals(expected, actual, 0);
    }
    //test toString when a null point is inserted
    @Test
    public void testNullPointToString() {
        Tour empty = new Tour();
        Point a = null;
        empty.insertInOrder(a);
        String actual = empty.toString();
        String expected = "";
        assertTrue("FAILURE", actual == expected);
    }
    //test toString when there is one point
    @Test
    public void testOnePointToString() {
        Tour empty = new Tour();
        Point a = new Point(0, 0);
        empty.insertInOrder(a);
        String actual = empty.toString();
        String expected = "(0.0, 0.0)" + '\n' + "(0.0, 0.0)" + '\n';
        assertEquals("FAILURE", actual, expected);
    }
    //test toString when the same point is inserted
    @Test
    public void testSamePointToString() {
        Tour empty = new Tour();
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        empty.insertInOrder(a);
        empty.insertInOrder(b);
        String actual = empty.toString();
        String expected = "(0.0, 0.0)" + '\n' + "(0.0, 0.0)" + '\n';
        assertFalse("FAILURE", actual == expected);
    }
}