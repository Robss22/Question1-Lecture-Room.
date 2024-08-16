/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.residentmanager1;

/**
 *
 * @author ABBY
 */


public class LectureRoom {
    private int students;
    private boolean[] lights;
    private int totalAdded;
    private int totalRemoved;
    private int addCount;
    private int removeCount;
    private static final int MAX_CAPACITY = 100; // Example maximum capacity

    public LectureRoom() {
        students = 0;
        lights = new boolean[3];
        totalAdded = 0;
        totalRemoved = 0;
        addCount = 0;
        removeCount = 0;
    }

    public void addStudents(int num) {
        if (num > 0) {
            if (students + num > MAX_CAPACITY) {
                students = MAX_CAPACITY;
                System.out.println("Room is now at full capacity!");
            } else {
                students += num;
            }
            totalAdded += num;
            addCount++;
        } else {
            System.out.println("Hey, you can't add a negative number of students!");
        }
    }

    public void removeStudents(int num) {
        if (num > 0) {
            int removed = Math.min(num, students);
            students -= removed;
            if (students == 0) {
                System.out.println("Room is now empty!");
            }
            totalRemoved += removed;
            removeCount++;
        } else {
            System.out.println("You can't remove a negative number of students!");
        }
    }

    public void turnOnLight(int num) {
        if (num >= 1 && num <= 3) {
            lights[num - 1] = true;
        } else {
            System.out.println("Invalid light number! Choose between 1, 2, or 3.");
        }
    }

    public void turnOffLight(int num) {
        if (num >= 1 && num <= 3) {
            lights[num - 1] = false;
        } else {
            System.out.println("Invalid light number! Choose between 1, 2, or 3.");
        }
    }

    public void displayStatus() {
        System.out.println("Students in the room: " + students);
        System.out.println("Lights status: ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Light " + (i + 1) + ": " + (lights[i] ? "On" : "Off"));
        }
        if (addCount > 0) {
            double avgAdded = (double) totalAdded / addCount;
            System.out.println("Average students added: " + avgAdded);
        }
        if (removeCount > 0) {
            double avgRemoved = (double) totalRemoved / removeCount;
            System.out.println("Average students removed: " + avgRemoved);
        }
    }
}

