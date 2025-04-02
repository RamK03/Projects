package E_Commerce_Site_Console_Project;

import java.util.Scanner;

public class User_Details
{
    Scanner sc = new Scanner(System.in);
    int user_Id = 2001;
    final String upi_Id = "12345@ybl";
    private static int upi_pin = 54321;
    final long card_No = 1234567890123456L;
    private static int card_Pin = 123456;

    public int get_upi_pin() {
        return upi_pin;
    }

    void set_upi_pin() {
        int old_pin;
        System.out.println("Enter old pin");
        old_pin = sc.nextInt();
        if (old_pin == upi_pin) {
            System.out.println("Enter new pin");
            int new_pin = sc.nextInt();
            System.out.println("Your pin is changed");
            upi_pin = new_pin;
        } else {
            System.out.println("Old pin is wrong");
            System.out.println();
            set_upi_pin();
        }
    }

    int get_card_pin() {
        return card_Pin;
    }

    void set_Card_pin() {
        int old_pin;
        System.out.println("Enter old pin");
        old_pin = sc.nextInt();
        if (old_pin == card_Pin) {
            System.out.println("Enter new pin");
            int new_pin = sc.nextInt();
            System.out.println("Your pin is changed");
            card_Pin = new_pin;
        } else {
            System.out.println("Old pin is wrong");
            System.out.println();
            set_Card_pin();
        }
    }
}


