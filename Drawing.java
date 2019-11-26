import java.util.ArrayList;

public class Drawing {
  private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
  private ArrayList<Integer> disconnections = new ArrayList<Integer>();
  
  public Drawing() { }
  
  public ArrayList<Coordinate> getCoordinates() {
    return this.coordinates;
  }
  
  public ArrayList<Integer> getDisconnections() {
    return this.disconnections;
  }
}
