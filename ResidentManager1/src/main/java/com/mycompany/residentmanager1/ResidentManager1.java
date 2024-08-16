/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.residentmanager1;

/**
 *
 * @author ABBY
 */

import java.util.Scanner;

public class ResidentManager1 {
    public static void main(String[] args) {
        LectureRoom room = new LectureRoom();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("W: Add students to the room");
            System.out.println("X: Remove students from the room");
            System.out.println("Y: Turn on a light");
            System.out.println("Z: Turn off a light");
            System.out.println("Q: Quit");
            System.out.print("Enter your choice: ");

            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'W':
                case 'w':
                    System.out.print("Enter the number of students to add: ");
                    int num = scanner.nextInt();
                    room.addStudents(num);
                    room.displayStatus();
                    break;
                case 'X':
                case 'x':
                    System.out.print("Enter the number of students to remove: ");
                    num = scanner.nextInt();
                    room.removeStudents(num);
                    room.displayStatus();
                    break;
                case 'Y':
                case 'y':
                    System.out.print("Enter the light number to turn on (1-3): ");
                    num = scanner.nextInt();
                    room.turnOnLight(num);
                    room.displayStatus();
                    break;
                case 'Z':
                case 'z':
                    System.out.print("Enter the light number to turn off (1-3): ");
                    num = scanner.nextInt();
                    room.turnOffLight(num);
                    room.displayStatus();
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
