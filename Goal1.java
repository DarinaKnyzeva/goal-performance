import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class Goal1 {
    public static void main(String[] args) {        
        List<String> lines = readFile("data1.txt");
        List<Integer> data = new ArrayList<Integer>(); 
        for (String line: lines) {
            data.add(Integer.parseInt(line));
        }

        int[] array = new int[data.size()];
        for(int i = 0; i < data.size(); i++) {
            array[i] = data.get(i);
        } 
        Arrays.sort(array);

        try {
            System.out.println("90 percentile " + Percentile(array, 90));
            System.out.println("median " + Median(array));
            System.out.println("average " + Average(array));
            System.out.println("min " + getMin(array));
            System.out.println("max " + getMax(array));
        } catch (Exception e) {
            System.out.println(e);
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

    public static float Percentile(int[] numbers, int percent) throws Exception {
        if (percent <0 || percent >100) {
            throw new Exception("var percent must not be less than 0 or greater than 100");
        }        
        float valuePercentile = 0;
        float rang = ((float) percent/100 * (numbers.length - 1) + 1);
        int number = numbers[Math.round(rang)-1];
        float fraction = rang - (float) Math.floor(rang);

        fraction = (float) Math.round(fraction * 100) / 100;
        valuePercentile = number + fraction * (numbers[Math.round(rang)] - number);
        return valuePercentile;
    }

    public static float Median(int[] numbers) {
        float median = 0;

        Arrays.sort(numbers);
        if (numbers.length % 2 == 0)
            median = ((float) numbers[numbers.length/2] + (float)numbers[numbers.length/2 - 1])/2;
        else
            median = (float) numbers[numbers.length/2];

        return median;
    }

    public static float Average(int[] numbers) {
        float average = 0;
        int sum = 0;

        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        } 

        average = (float) Math.round((float) sum/numbers.length * 100) / 100;

        return average;
    }

    public static int getMax(int[] numbers){
        int max = Integer.MAX_VALUE;
        if (numbers.length != 0 ) {
            Arrays.sort(numbers);
            max = numbers[numbers.length-1];
        }

        return max;
    }

    public static int getMin(int[] numbers){
        int min = Integer.MIN_VALUE;
        
        if (numbers.length != 0 ) {
            Arrays.sort(numbers);
            min = numbers[0];
        }

        return min;
    }
}