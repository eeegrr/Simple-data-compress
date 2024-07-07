import java.util.Scanner;

public class Main {
  private static void compress(String[] parts) {
    String dna = parts[1];
    // mistakes
    if (!dna.matches("[ACGTacgt]+")) {
      System.out.println("wrong command format");
    }

    StringBuilder binary = new StringBuilder();

    // convert
    for (int i = 0; i < dna.length(); i++) {
      char c = dna.charAt(i);
      switch (c) {
        case 'A':
          binary.append("00");
          break;
        case 'C':
          binary.append("01");
          break;
        case 'G':
          binary.append("10");
          break;
        case 'T':
          binary.append("11");
          break;
      }
    }
    System.out.print(dna.length() + " ");

    // from binary to hex
    while (binary.length() % 16 != 0) {
      binary.append("0");
    }

        String hex = Long.toHexString(Long.parseLong(binary.toString(), 2));
    String hexSubstring;

    StringBuilder spacedHex = new StringBuilder();
    for (int i = 0; i < hex.length(); i += 2) {
      if (i + 1 < hex.length()) {
        hexSubstring = hex.substring(i, i + 2);
        if (hexSubstring.charAt(0) == '0') {
          hexSubstring = hexSubstring.substring(1, 2);
        }
        spacedHex.append(hexSubstring).append(" ");
      }
    }
    System.out.println(spacedHex.toString().toUpperCase().trim());
  }


  private static void decompress(String[] parts) {
    // checks if after word decomp all are numbers
    boolean allIntegers = true;
    int m = 0;
    for (int i = 1; i < parts.length; i++) {
      if (!parts[i].matches("\\d+")) {
        allIntegers = false;
        break;
      }

      if (!allIntegers) {
        System.out.println("wrong command format");
        break;
      }

      if (Integer.parseInt(parts[i]) > Byte.MAX_VALUE) {
        System.out.println("wrong command format");
        break;
      }

      if (Integer.parseInt(parts[1]) != parts.length-2) {
        System.out.println("wrong command format");
        break;
      }

    }


    StringBuilder binary = new StringBuilder();

    // convert input values to binary and print their hex representation
    String hexString;
    // int numValues = Integer.parseInt(parts[1]);
    int numLetters = Integer.parseInt(parts[2]);
    int value;
    String[] binaryArray = new String[Integer.parseInt(parts[1]) - 1];

    for (int i = 2; i < parts.length; i++) {
      value = Integer.parseInt(parts[i]);
      hexString = Integer.toHexString(value & 0xFF).toUpperCase();
      System.out.print(hexString + " ");

      if (i >= 3) {
        binary.append(convertToBinary(value));
      }

    }

    System.out.println();


    String binaryString = binary.toString().substring(0, 2 * numLetters + 2);

    // convert binary string to DNA sequence
    String dna = "", nucleotide;
    for (int i = 2; i < binaryString.length(); i += 2) {
      nucleotide = binaryString.substring(i - 2, i);
      switch (nucleotide) {
        case "00":
          dna += "A";
          break;
        case "01":
          dna += "C";
          break;
        case "10":
          dna += "G";
          break;
        case "11":
          dna += "T";
          break;
      }
    }
    System.out.println(dna);
  }

  private static String convertToBinary(int number) {

    String binaryString = Integer.toBinaryString(number);

    while (binaryString.length() < 8) {
      binaryString = "0" + binaryString;
    }

    while (binaryString.length() > 8) {
      binaryString = binaryString.substring(binaryString.length() - 8, binaryString.length());
    }
    return binaryString;
  }

  public static void main(String[] args) {
    String[] parts;


    Scanner sc = new Scanner(System.in);
      String input;
      while (sc.hasNextLine()) {
        input = sc.nextLine();
        parts = input.split(" ");
        if (parts[0].equals("comp")) {
          compress(parts);
        } else if (parts[0].equals("decomp")) {
          decompress(parts);
        } else if (parts[0].equals("about")) {
          System.out.println("Evelina Graumane");

        } else if (parts[0].equals("exit")) {
          break;

        } else {
          System.out.println("unknown command");
        }
      }
      sc.close();
    }
  }



