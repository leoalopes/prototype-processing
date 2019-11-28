import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileHandler {

    public static void saveCoordinates(ArrayList<Coordinate> coordinates) {
      try {
        System.out.println("Saving coordinates...");
        
        String arr[] = new String[coordinates.size()];
        for(int i = 0; i < coordinates.size(); i++) {
          Coordinate current = coordinates.get(i);
          arr[i] = Integer.toString(current.x) + "," + Integer.toString(current.y) + "," + Integer.toString(current.colour);
        }
        List<String> list = Arrays.asList(arr);
        Files.write(Paths.get("coordinates.txt"), list, StandardCharsets.UTF_8);
        
        System.out.println("Saved.");
      } catch(Exception e) {
        System.out.println(e.getMessage());
      }
    }
    
    public static void saveDisconnections(ArrayList<Integer> disconnections) {
      try {
        System.out.println("Saving disconnections...");
        
        String arr[] = new String[disconnections.size()];
        for(int i = 0; i < disconnections.size(); i++) {
          arr[i] = Integer.toString(disconnections.get(i));
        }
        List<String> list = Arrays.asList(arr);
        Files.write(Paths.get("disconnections.txt"), list, StandardCharsets.UTF_8);
        
        System.out.println("Saved.");
      } catch(Exception e) {
        System.out.println(e.getMessage());
      }
    }
    
    public static ArrayList<Coordinate> readCoordinates() {
      ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
      try {
        String content[] = new String(Files.readAllBytes(Paths.get("coordinates.txt"))).split("\\r?\\n");
        for(int i = 0; i < content.length; i++) {
          String current[] = content[i].split(",");
          coords.add(
            new Coordinate(
              Integer.parseInt(current[0]),
              Integer.parseInt(current[1]),
              Integer.parseInt(current[2])
            )
          );
        }
      } catch(Exception e) {
        System.out.println(e.getMessage());
      }
      return coords;
    }
    
    public static ArrayList<Integer> readDisconnections() {
      ArrayList<Integer> disc = new ArrayList<Integer>();
      try {
        String content[] = new String(Files.readAllBytes(Paths.get("disconnections.txt"))).split("\\r?\\n");
        for(int i = 0; i < content.length; i++) {
          disc.add(Integer.parseInt(content[i]));
        }
      } catch(Exception e) {
        System.out.println(e.getMessage());
      }
      return disc;
    }
    
    public static void clear() {
      try {
        System.out.println("Clearing files...");
        Files.delete(Paths.get("coordinates.txt"));
        Files.delete(Paths.get("disconnections.txt"));
        System.out.println("Cleared.");
      } catch(Exception e) {
        System.out.println(e.getMessage());
      }
    }

}
