import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {

    public static void main(String[] args) {

        ArrayList<LiteracyCountry> literacy = new ArrayList<>();
        
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 6)
                    .map(parts -> new LiteracyCountry(parts[3], Integer.valueOf(parts[4]), parts[2].substring(0, parts[2].length() - 4), parts[5]))
                    .forEach(part -> literacy.add(part));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        

        literacy.stream().sorted((p1, p2) -> {
            return p1.getRate().compareTo(p2.getRate());
        }).forEach(p -> System.out.println(p));

    }

}
