import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Arrays;

public class Goal3 {
    public static void main(String[] args) {
        for (int i = 1; i<=5; i++) {
            String key = "cashbox" + i;
            List<String> lines = readFile(key + ".txt");
            System.out.println(lines);

            String[] data = new String[lines.size()];
            for (int j = 0; j < lines.size(); j++) {
                data[j] = lines.get(j);
            
            }

            float[][] cashboxes = new float[5][lines.size()];          

            for(int j = 0; j < lines.size(); j++) {
                cashboxes[i-1][j] = Float.parseFloat(data[j]);
            }        
        }

        int time = 0;
        float sum = -1;
        for (int t = 0; t < 16; t++) {
            
        }
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

    public static int getMax(int[] numbers){
        int max = Integer.MAX_VALUE;
        if (numbers.length != 0 ) {
            Arrays.sort(numbers);
            max = numbers[numbers.length-1];
        }

        return max;
    }

}