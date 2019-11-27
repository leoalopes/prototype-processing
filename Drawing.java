import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Drawing {
  private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
  private ArrayList<Integer> disconnections = new ArrayList<Integer>();
  
  public Drawing() {
    try {
      this.coordinates = FileHandler.readFile();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public ArrayList<Coordinate> getCoordinates() {
    return this.coordinates;
  }
  
  public ArrayList<Integer> getDisconnections() {
    return this.disconnections;
  }
  
  private void clearData() {
    
  }
  
  public void save() {
    this.clearData();
    if(this.coordinates.size() > 0) {
      FileHandler.saveToFile(this.coordinates);
    }
  }
  
  public void clean() {
    this.clearData();
    this.coordinates.clear();
    this.disconnections.clear();
  }
}
