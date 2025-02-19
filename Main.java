import java.util.Scanner;

public class Main {

    // Method to compress the input string
    public static String compressString(String s) {
        if (s.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        char currentChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar).append(count);
                currentChar = s.charAt(i);
                count = 1;
            }
        }
        compressed.append(currentChar).append(count);
        return compressed.toString();
    }

    // Method to decompress the input string
    public static String decompressString(String s) {
        if (s.isEmpty()) {
            return "";
        }

        StringBuilder decompressed = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            int count = 0;

            // Extract the number after the character
            while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                count = count * 10 + (s.charAt(i + 1) - '0'); // Convert char to int
                i++;
            }

            // Append the character 'count' times
            for (int j = 0; j < count; j++) {
                decompressed.append(character);
            }
        }
        return decompressed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Compress a string");
            System.out.println("2. Decompress a string");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to compress: ");
                    String inputCompress = scanner.nextLine();
                    System.out.println("Compressed String: " + compressString(inputCompress));
                    break;
                case 2:
                    System.out.print("Enter a compressed string to decompress: ");
                    String inputDecompress = scanner.nextLine();
                    System.out.println("Decompressed String: " + decompressString(inputDecompress));
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
        }
    }
}
