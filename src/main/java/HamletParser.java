import java.io.File;
import java.io.IOException;
import java.time.Period;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private final Pattern hamletPattern = Pattern.compile("Hamlet");
    private final Pattern bigHam = Pattern.compile("HAMLET");
    private final Pattern horatioPattern = Pattern.compile("Horatio");
    private final Pattern bigHor = Pattern.compile("HORATIO");
    private final String hamLeon = "Leon";
    private final String bigLeon = "LEON";
    private final String horaTariq = "Tariq";
    private final String bigTariq = "TARIQ";
    private Matcher matcher;


    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public String hamletToLeon(String data) {
        matcher = hamletPattern.matcher(data);
        hamletData = matcher.replaceAll(hamLeon);
        return hamletData;
    }

    public String horatioToTariq(String data) {
        matcher = horatioPattern.matcher(data);
        hamletData = matcher.replaceAll(horaTariq);
        return hamletData;
    }

    public boolean findHoratio(String data) {
        if (horatioPattern.matcher(data).find()) {
            return true;
        }
        return false;
    }

    public boolean findHamlet(String data) {
        if (hamletPattern.matcher(data).find()) {
            return true;
        }
        return false;

    }

    public String bigHamChanger(String data) {
        matcher = bigHam.matcher(data);
        hamletData = matcher.replaceAll(bigLeon);
        return hamletData;

    }

    public String bigHorChanger(String data){
        matcher = bigHor.matcher(data);
        hamletData = matcher.replaceAll(bigTariq);
        return hamletData;
    }


}
