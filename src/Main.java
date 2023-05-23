import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to encryption and decryption");
        System.out.println("Enter a 4 digit number: ");
        int num = input.nextInt();
        System.out.println("For encryption enter 1\nFor decryption enter 2");
        int choice = input.nextInt();

        if (choice == 1) {
            int encryptedNumber = encrypt(num);
            System.out.println("Encrypted number: " + encryptedNumber);
        } else if (choice == 2) {
            int decryptedNumber = decrypt(num);
            System.out.println("Decrypted number: " + decryptedNumber);
        }
    }

    public static int encrypt(int number) {
        // Extracting each digit from the input number
        int digit1 = number / 1000;
        number = number % 1000;

        int digit2 = number / 100;
        number = number % 100;

        int digit3 = number / 10;
        number = number % 10;

        int digit4 = number;

        // Adding 7 and performing module 10 for each digit
        digit1 = (digit1 + 7) % 10;
        digit2 = (digit2 + 7) % 10;
        digit3 = (digit3 + 7) % 10;
        digit4 = (digit4 + 7) % 10;

        // Swapping the first and third digits
        int temp = digit1;
        digit1 = digit3;
        digit3 = temp;

        // Swapping the second and fourth
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;

        int encryptedNumber = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;

        return encryptedNumber;
    }

    public static int decrypt(int number) {

        // Separating digits
        int digit1 = number / 1000;
        number = number % 1000;

        int digit2 = number / 100;
        number = number % 100;

        int digit3 = number / 10;
        number = number % 10;

        int digit4 = number;

        // Swapping first with third
        int temp = digit1;
        digit1 = digit3;
        digit3 = temp;

        // Swapping second with fourth
        temp = digit2;
        digit2 = digit4;
        digit4 = temp;

        digit1 = (digit1 + 10 - 7) % 10;
        digit2 = (digit2 + 10 - 7) % 10;
        digit3 = (digit3 + 10 - 7) % 10;
        digit4 = (digit4 + 10 - 7) % 10;


        int decryptedNumber = digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;

        return decryptedNumber;
    }
}