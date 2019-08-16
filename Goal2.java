import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Scanner;

public class Goal2 {
    public static void main(String[] args) {
        List<String> lines = readFile("data2.txt");
        System.out.println(lines);

        String[] data = new String[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            data[i] = lines.get(i);
            System.out.println(data[i]);
        }

        int[][] coords = new int[lines.size()][2];

        for(int i = 0; i < lines.size(); i++) {
            String[] parts = data[i].split(" ");
            coords[i][0] = Integer.parseInt(parts[0]);
            coords[i][1] = Integer.parseInt(parts[1]);
        
            System.out.println("X" + i + ": " + coords[i][0]);
            System.out.println("Y" + i + ": " + coords[i][1]);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the point coordinates (format 'X Y'): ");
        String userCoords = in.nextLine();

        System.out.println(FindCoordinates(coords, userCoords));
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

    public static String FindCoordinates(int[][] сoords, String userCoords) {
        String answer = " ";

        String[] parts = userCoords.split(" ");
        int userX = Integer.parseInt(parts[0]);
        int userY = Integer.parseInt(parts[1]);

        System.out.println("userCoords X:" + userX +" Y:" + userY);

        int[] minmaxX = getInterval(сoords, 0);
        int[] minmaxY = getInterval(сoords, 1);

        if(minmaxX[0]<=userX && userX <= minmaxX[1]) {
            if(minmaxY[0]<=userY && userY <= minmaxY[1]) answer = "This point is inside the quadrangle";
            else answer = "This point is outside the quadrangle";
        } else answer = "This point is outside the quadrangle";


        for(int i = 0; i < сoords.length-1; i++) {
            if ((сoords[i][1]-сoords[i+1][1])*userX + (сoords[i+1][0]-сoords[i][0])*userY + 
            (сoords[i][0]*сoords[i+1][1] - сoords[i+1][0]*сoords[i][1]) == 0) {

                int v1X = сoords[i][0] - userX; 
                int v1Y = сoords[i][1] - userY;
                int v2X = сoords[i+1][0] - userX; 
                int v2Y = сoords[i+1][1] - userY; 

                if ((v1X*v2X + v1Y*v2Y) <=0) {
                    answer = "This point lies on the side of the quadrilateral";
                }
            } 
        }

        if ((сoords[3][1]-сoords[0][1])*userX + (сoords[0][0]-сoords[3][0])*userY + 
            (сoords[3][0]*сoords[0][1] - сoords[0][0]*сoords[3][1]) == 0) {
  
                int v1X = сoords[3][0] - userX; 
                int v1Y = сoords[3][1] - userY;
                int v2X = сoords[0][0] - userX; 
                int v2Y = сoords[0][1] - userY; 

                if ((v1X*v2X + v1Y*v2Y) <=0) {
                    answer = "This point lies on the side of the quadrilateral";
                }
            } 

        for(int i = 0; i < сoords.length; i++) {
            if (userX == сoords[i][0] && userY == сoords[i][1]) {
                    answer = "The given point is the vertex of the quadrangle";
            }
        }

        return answer;
    }
    

    public static int[] getInterval(int[][] сoords, int t){
        int[] interval = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<сoords.length; i++){
            if(сoords[i][t]<min) min = сoords[i][t];
            if(сoords[i][t]>max) max = сoords[i][t];
        }
        interval[0] = min;
        interval[1] = max;
        return interval;
    }
}
