import java.io.*;
import java.util.*;

public class FileOperations {
    // Function to read the first n lines (head)
    public static void head(String filename, int n) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null && count < n) {
                System.out.println(line);
                count++;
            }
        } catch (FileNotFoundException e1) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Function to read the last n lines (tail)
    public static void tail(String filename, int n) {
        try {
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                    if (lines.size() > n) {
                        lines.remove(0);
                    }
                }
            }
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e1) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Function to read the middle n lines
    public static void middle(String filename, int n) {
        try {
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
            int totalLines = lines.size();
            if (totalLines < n) {
                n = totalLines;
            }
            int startIndex = (totalLines - n) / 2;
            for (int i = startIndex; i < startIndex + n; i++) {
                System.out.println(lines.get(i));
            }
        } catch (FileNotFoundException e1) {
            System.out.println("File not found!");    
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Operations: head, tail, middle");
            throw new Exception("Missing arguments!\nUsage: <filename> <operation> <number of lines>");
        } else if (args.length>3) {
            System.out.println("Operations: head, tail, middle");
            throw new Exception("Too many arguments!\nUsage: <filename> <operation> <number of lines>"); }

        String filename = args[0];
        String operation = args[1];
        int n = Integer.parseInt(args[2]);

        switch (operation) {
            case "head":
                head(filename, n);
                break;
            case "tail":
                tail(filename, n);
                break;
            case "middle":
                middle(filename, n);
                break;
            default:
                System.out.println("Invalid operation. Use head, tail, or middle.");
        }
    }
}
