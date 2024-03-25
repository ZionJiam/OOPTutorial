import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class FibonacciGenerator {

    public static void main(String[] args) {

        int limit = 1000;

        writeFibonacci(limit);
    }

    public static void writeFibonacci(int limit){
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;

        String header = "Number of Fibonacci: " + limit;
        String fibonacciPath = "./fibonacci.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fibonacciPath))) {
            writer.write(first + "\n");
            writer.write(second + "\n");

            for(int i=2;i<limit;i++){
                BigInteger next = first.add(second);
                System.out.print(next + "\n");
                writer.write(next + "\n");
                first = second;
                second = next;
            }

            System.out.println("Fibonacci sequence has been written to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
