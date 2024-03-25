import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciChecker {
    public static void main(String[] args) {
        try {
            List<BigInteger> fibonacciList = readFibonacciFromFile("./fibonacci.txt");
            if (isFibonacciSequence(fibonacciList)) {
                System.out.println("The Fibonacci sequence is correct.");
            } else {
                System.out.println("The Fibonacci sequence is incorrect.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static List<BigInteger> readFibonacciFromFile(String filename) throws IOException {
        List<BigInteger> fibonacciList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fibonacciList.add(new BigInteger(line.trim()));
            }
        }catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return fibonacciList;
    }

    public static boolean isFibonacciSequence(List<BigInteger> sequence) {
        if (sequence.size() < 2) {
            return false; // Not a valid Fibonacci sequence
        }

        for (int i = 2; i < sequence.size(); i++) {
            BigInteger sum = sequence.get(i - 1).add(sequence.get(i - 2));
            if (!sequence.get(i).equals(sum)) {
                return false; // Not a valid Fibonacci sequence
            }
        }
        return true; // Valid Fibonacci sequence
    }
}
