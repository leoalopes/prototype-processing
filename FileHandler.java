import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileHandler {
    private static String filePath = "coordinates.txt";
    
    public static void saveToFile(ArrayList<Coordinate> coordinates) {
      try {
        System.out.println("Saving to file...");
        
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
    
    public static ArrayList<Coordinate> readFile() {
      ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
      try {
        String content[] = new String(Files.readAllBytes(Paths.get(filePath))).split("\\r?\\n");
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
}
