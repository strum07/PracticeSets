package Accenture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class CollinearPoints {

    static boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y3 - y2) * (x2 - x1) == (y2 - y1) * (x3 - x2);
    }

    static void getLineEquation(int x1, int y1, int x2, int y2) {
        int a = y2 - y1;
        int b = x2 - x1;
        int c = a * (x1) - b * (y1);
        System.out.println("Line Equation: " + a + "x - " + b + "y = " + c);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter Number of Points");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPoints = Integer.parseInt(br.readLine());
        System.out.println(numberOfPoints);

        System.out.println("Enter Points - separated by space");
        String points = br.readLine();
        String[] s = points.split(" ");
        int[] pointsArray = new int[s.length];
        for (int i = 0; i < s.length; i++)
            pointsArray[i] = Integer.parseInt(s[i]);

        int falseCount = 0;

        if (numberOfPoints > 2 && pointsArray.length > 5) {
            for (int i = 0; i <= numberOfPoints - 3; i = i + 2) {
                if (!isCollinear(pointsArray[i], pointsArray[i + 1], pointsArray[i + 2], pointsArray[i + 3], pointsArray[i + 4], pointsArray[i + 5])) {
                    falseCount++;
                }
            }
        }

        if (falseCount == 0) {
            getLineEquation(pointsArray[0], pointsArray[1], pointsArray[2], pointsArray[3]);
        }

        if (falseCount > 0) {
            System.out.println("0");
        }
    }
}
