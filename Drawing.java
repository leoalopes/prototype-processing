import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Drawing implements Cloneable {
  private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
  private ArrayList<Integer> disconnections = new ArrayList<Integer>();
  
  public Drawing() {
    try {
      this.coordinates = FileHandler.readCoordinates();
      this.disconnections = FileHandler.readDisconnections();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public Drawing(ArrayList<Coordinate> coordinates, ArrayList<Integer> disconnections) {
    this.coordinates = coordinates;
    this.disconnections = disconnections;
  }
  
  public ArrayList<Coordinate> getCoordinates() {
    return this.coordinates;
  }
  
  public ArrayList<Integer> getDisconnections() {
    return this.disconnections;
  }
  
  public void save() {
    if(this.coordinates.size() > 0) {
      FileHandler.saveCoordinates(this.coordinates);
      FileHandler.saveDisconnections(this.disconnections);
    }
  }
  
  public void clean() {
    this.coordinates.clear();
    this.disconnections.clear();
    FileHandler.clear();
  }
  
  @Override
  public Object clone() {
    return new Drawing((ArrayList) this.coordinates.clone(), (ArrayList) this.disconnections.clone());
  }
}
