package src;
import java.util.Arrays;
import java.util.Scanner;

public class StatisticsCalculator {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        double[] statistics = calculateStatistics(numbers);

        System.out.println("Statistics: " + Arrays.toString(statistics));
    }

    public static double[] calculateStatistics(int[] array) {
        double[] statistics = new double[4];

        Arrays.sort(array);

        
        statistics[0] = calculateMedian(array);

      
        statistics[1] = calculateVariance(array);


        statistics[2] = Math.sqrt(statistics[1]);

       
        statistics[3] = calculateSumOfSquares(array);

        return statistics;
    }

    private static double calculateMedian(int[] array) {
        int n = array.length;
        if (n % 2 == 0) {
         
            return (array[n / 2 - 1] + array[n / 2]) / 2.0;
        } else {
           
            return array[n / 2];
        }
    }

    private static double calculateVariance(int[] array) {
        double mean = Arrays.stream(array).average().orElse(0);
        return Arrays.stream(array).mapToDouble(x -> Math.pow(x - mean, 2)).average().orElse(0);
    }

    private static double calculateSumOfSquares(int[] array) {
        return Arrays.stream(array).mapToDouble(x -> Math.pow(x, 2)).sum();
    }
}
