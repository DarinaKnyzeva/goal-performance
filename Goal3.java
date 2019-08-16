import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class Goal3 {
    public static void main(String[] args) {
        List<String> lines1 = readFile("cashbox1.txt");
        List<String> lines2 = readFile("cashbox2.txt");
        List<String> lines3 = readFile("cashbox3.txt");
        List<String> lines4 = readFile("cashbox4.txt");
        List<String> lines5 = readFile("cashbox5.txt");

        System.out.println(lines1);
        System.out.println(lines2);
        System.out.println(lines3);
        System.out.println(lines4);
        System.out.println(lines5);

        List<Float> cashbox1 = new ArrayList<Float>(); 
        List<Float> cashbox2 = new ArrayList<Float>(); 
        List<Float> cashbox3 = new ArrayList<Float>(); 
        List<Float> cashbox4 = new ArrayList<Float>(); 
        List<Float> cashbox5 = new ArrayList<Float>(); 

        for (String line: lines1) { cashbox1.add(Float.parseFloat(line)); }
        for (String line: lines2) { cashbox2.add(Float.parseFloat(line)); }
        for (String line: lines3) { cashbox3.add(Float.parseFloat(line)); }
        for (String line: lines4) { cashbox4.add(Float.parseFloat(line)); }
        for (String line: lines5) { cashbox5.add(Float.parseFloat(line)); }



        System.out.println(cashbox1);
        System.out.println(cashbox2);
        System.out.println(cashbox3);
        System.out.println(cashbox4);
        System.out.println(cashbox5);
    }



    public static List<String> readFile(String pathName) {
        List<String> lines = new ArrayList<String>();

        try {
            lines = Files.readAllLines(Paths.get(pathName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            //TODO: handle exception
        }
        
        return lines;
    }

}