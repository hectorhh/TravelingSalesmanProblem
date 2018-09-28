/**
 * Name : Hector Herrera
 * PennKey : Hectorh
 * Recitation : 216
 * 
 * Execution: java Tour
 * 
 * This program will implement TourInterface and represent a linked list that
 * will mock the cyclical nature of the salesman's route; he starts and ends 
 * at his home to create heuristics for the Traveling Salesman Problem.
 */
public class Tour implements TourInterface {
    private Node head;       //represents the first node in Tour
    private Node lastNode;   //references the same point as head
   
    /**
     * Description: constructor to create an empty tour
     * 
     * Input: none
     * 
     * Output: an empty Tour is created
     */
    public Tour() {
        head = null;
        lastNode = null;
    }
    
    /**
     * Description: returns a String representation of the Tour.
     * 
     * Input: none
     * 
     * Output: a String version 
     */
    public String toString() {
        String totalPoints = "";
        //print out an empty string if there is no Point
        if (head == null && lastNode == null) {
            return totalPoints;
        } else {
            //get a String representation of the Points in tour
            for (Node curr = head; curr != null; curr = curr.next) {
                totalPoints += curr.point.toString() + '\n';
            }
            return totalPoints;
        }
    }
    
    /**
     * Description: draws the tour
     * 
     * Input: Point P so we can know where to draw the lines
     * 
     * Output: void
     */
    public void draw(Point p) {
        //handles the cases when there is no point
        if (head == null) return;
        //handles the case when there is only one point
        if (head.next == null) return;
        else {
            Node newNode = new Node(p);
            Node curr;
            
            lastNode = head;
            for (curr = head; curr.next != null; curr = curr.next) {
                //draws adjacent lines as different colors
                if (curr.point == newNode.point || 
                    curr.next.point == newNode.point) {
                    PennDraw.setPenColor(150, 50, 50);
                    curr.point.drawTo(curr.next.point);
                    PennDraw.setPenColor(PennDraw.BLACK);
                }
                //draws the final shape in black
                else curr.point.drawTo(curr.next.point);
            }    
        }
    }
    
    /**
     * Description: returns the number of points in the tour
     * 
     * Input: none
     * 
     * Output: an int reresenting the number of points in the tour
     */
    public int size() {
        int size = 0;
        //handles the case when head is null
        if (head == null) return size;
        else {
            //iterates through the nodes to find the number of points
            for (Node curr = head; curr.next != null; curr = curr.next) {
                size++;
            }
            return size;
        }
    }
    
    /**
     * Description: Returns the total length of the tour
     * 
     * Input: none
     * 
     * Output: double representing the total length of the tour
     */
    public double distance() {
        double distance = 0;
        //handles the case when the tour is empty;
        if (head == null) return distance;
        //handles the case when there is one point
        if (head.next == null) return distance;
        else {
            //iterates through the nodes to find the distances
            for (Node curr = head; curr.next != null; curr = curr.next) {
                distance += curr.point.distanceTo(curr.next.point);
            }
            return distance;
        }
    }

    /**
     * Description: Insert p at the end of the tour
     * 
     * Input: p the point to add to the tour
     * 
     * Output: void
     */
    public void insertInOrder(Point p) {
        //handles the case if p is null
        if (p == null) return;
        else {
            Node firstNode = new Node(p);
            Node secondNode = new Node(p);
            
            //handles the case when there are no points in the tour
            if (head == null) {
                head = firstNode;
                lastNode = secondNode;
                head.next = lastNode;
                lastNode.next = null;
            } else {
                Node temp = head; 
                //gives the correct place of where to place the new Point p
                for (Node curr = head; curr != lastNode; curr = curr.next) {
                    temp = curr;
                }
                //adds the point in the correct place
                temp.next = firstNode;
                firstNode.next = lastNode;
            }
        }
    }

    /**
     * Description: Insert p after the point to which it is closest
     * 
     * Input: p the point to add to the tour
     * 
     * Output: void
     */
    public void insertNearest(Point p) {
        //handles the case if p is null
        if (p == null) return;
        else {
            Node firstNode = new Node(p);
            Node secondNode = new Node(p);
            
            //handles the case when there are no points in the tour
            if (head == null) {
                head = firstNode;
                lastNode = secondNode;
                head.next = lastNode;
                lastNode.next = null;
            } else {
                Node temp = head; 
                double min = Double.MAX_VALUE;
                //gives the correct place of where to place the new Point p
                for (Node curr = head; curr.next != null; curr = curr.next) {
                    double hold = curr.point.distanceTo(firstNode.point);
                    //finds the nearest point using the smallest distance
                    if (hold < min) {
                        min = hold;
                        temp = curr;
                    }
                }
                //adds the point in the correct place
                firstNode.next = temp.next;
                temp.next = firstNode;
            }
        }
    }
    
    /**
     * Description: Insert p where it will cause the shortest detour
     * 
     * Input: p the point to add to the tour
     * 
     * Output: void
     */
    public void insertSmallest(Point p) {
        //handles the case if p is null
        if (p == null) return;
        else {
            Node firstNode = new Node(p);
            Node secondNode = new Node(p);
            
            //handles the case when there are no points in the tour
            if (head == null) {
                head = firstNode;
                lastNode = secondNode;
                head.next = lastNode;
                lastNode.next = null;
            } else {
                Node temp = head;
                double min = Double.MAX_VALUE;
                for (Node curr = head; curr.next != null; curr = curr.next) {
                    double total = curr.point.distanceTo(curr.next.point);
                    double value = curr.point.distanceTo(firstNode.point);
                    double value2 = firstNode.point.distanceTo(curr.next.point);
                    
                    //finds the point that will cause the shortest detour
                    if (value + value2 - total < min) {
                        min = value + value2 - total;
                        temp = curr;
                    }
                }
                //adds the point in the correct place
                firstNode.next = temp.next;
                temp.next = firstNode;
            }
        }
    }   
    
    public static void main(String[] args) {
//        Tour tour = new Tour();
//       
//       Point a = new Point(0, 0);
//      Point b = new Point(1, 0);
//        Point c = new Point(1, 1);
//        Point d = new Point(0, 1);
//       tour.insertInOrder(a);
//        tour.insertInOrder(b);
//        tour.insertInOrder(c);
//       tour.insertInOrder(d);
//        System.out.print(tour.toString());
//        System.out.println(tour);
//        System.out.println(tour.size());
//        System.out.println(tour.distance());
//        tour.draw(a);
    }
}