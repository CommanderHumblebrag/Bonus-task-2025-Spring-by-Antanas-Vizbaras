import java.util.Scanner;

public class Main {

    // Metodas suspausti eilutę, suskaičiuojant gretimų simbolių pasikartojimus
    public static String compressString(String s) {
        // Jei eilutė tuščia, grąžiname tuščią eilutę
        if (s.isEmpty()) {
            return "";
        }

        // StringBuilder naudojamas efektyvesniam eilutės konstravimui
        StringBuilder compressed = new StringBuilder();
        char currentChar = s.charAt(0); // Išsaugome pirmąjį simbolį
        int count = 1; // Skaičiuojame kiek kartų pasikartoja šis simbolis

        // Pereiname per visą eilutę nuo antrojo simbolio
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                // Jei simbolis toks pat kaip ankstesnis, didiname skaitiklį
                count++;
            } else {
                // Jei simbolis keičiasi, pridedame esamą simbolį su skaičiumi prie rezultato
                compressed.append(currentChar).append(count);
                // Atnaujiname dabartinį simbolį ir nustatome skaitiklį į 1
                currentChar = s.charAt(i);
                count = 1;
            }
        }

        // Pridedame paskutinį simbolį su jo pasikartojimo skaičiumi
        compressed.append(currentChar).append(count);

        // Konvertuojame į eilutę ir grąžiname rezultatą
        return compressed.toString();
    }

    // Metodas atkurti originalią eilutę iš suspaustos versijos
    public static String decompressString(String s) {
        // Jei eilutė tuščia, grąžiname tuščią eilutę
        if (s.isEmpty()) {
            return "";
        }

        // StringBuilder naudojamas efektyviam eilutės atkūrimui
        StringBuilder decompressed = new StringBuilder();
        int length = s.length();

        // Pereiname per kiekvieną simbolį suspaustoje eilutėje
        for (int i = 0; i < length; i++) {
            char character = s.charAt(i); // Išsaugome dabartinį simbolį
            int count = 0; // Skaičius, kuris nurodys, kiek kartų reikia pakartoti simbolį

            // Išskiriame skaičių, kuris seka po simbolio (gali būti kelių skaitmenų)
            while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                count = count * 10 + (s.charAt(i + 1) - '0'); // Konvertuojame skaičių iš simbolių į int
                i++; // Einame toliau per eilutę
            }

            // Kartojame simbolį tiek kartų, kiek buvo nurodyta
            for (int j = 0; j < count; j++) {
                decompressed.append(character);
            }
        }
        return decompressed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Vartotojui pateikiamas meniu pasirinkimui
            System.out.println("\nPasirinkite veiksmą:");
            System.out.println("1. Suspausti eilutę");
            System.out.println("2. Atkurti (dekompresuoti) eilutę");
            System.out.println("3. Išeiti");
            System.out.print("Įveskite savo pasirinkimą: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Suvartojame naujos eilutės simbolį po skaičiaus įvedimo

            switch (choice) {
                case 1:
                    System.out.print("Įveskite eilutę suspaudimui: ");
                    String inputCompress = scanner.nextLine();
                    System.out.println("Suspausta eilutė: " + compressString(inputCompress));
                    break;
                case 2:
                    System.out.print("Įveskite suspaustą eilutę atkūrimui: ");
                    String inputDecompress = scanner.nextLine();
                    System.out.println("Atkurta eilutė: " + decompressString(inputDecompress));
                    break;
                case 3:
                    System.out.println("Programa baigiama...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neteisingas pasirinkimas! Pasirinkite 1, 2 arba 3.");
            }
        }
    }
}
