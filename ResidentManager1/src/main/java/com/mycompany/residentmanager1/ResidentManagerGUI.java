/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.residentmanager1;

/**
 *
 * @author ABBY
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResidentManagerGUI extends JFrame {
    private LectureRoom room;
    private JTextArea textArea;
    private JTextField inputField;

    public ResidentManagerGUI() {
        room = new LectureRoom();
        textArea = new JTextArea(15, 30);
        inputField = new JTextField(30);

        setTitle("Victoria University Resident Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Command options panel
        JPanel commandPanel = new JPanel();
        commandPanel.setLayout(new BorderLayout());

        // Commands Text Area
        JTextArea commandOptions = new JTextArea(5, 30);
        commandOptions.setEditable(false);
        commandOptions.setText("Commands:\n" +
                "W <number> - Add students to the room\n" +
                "X <number> - Remove students from the room\n" +
                "Y <number> - Turn on a light (1-3)\n" +
                "Z <number> - Turn off a light (1-3)\n" +
                "Q - Quit\n");
        commandOptions.setBackground(getBackground());
        commandPanel.add(new JScrollPane(commandOptions), BorderLayout.NORTH);

        // Input Field and Submit Button
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Command:"));
        inputPanel.add(inputField);
        JButton submitButton = new JButton("Submit");
        inputPanel.add(submitButton);
        commandPanel.add(inputPanel, BorderLayout.CENTER);

        // Add Command Panel and Text Area to Frame
        add(commandPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Submit Button Action Listener
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processCommand(inputField.getText().trim());
                inputField.setText("");
            }
        });

        pack();
        setVisible(true);
    }

    private void processCommand(String command) {
        String[] parts = command.split(" ");
        if (parts.length < 1) {
            textArea.append("Invalid command. Please enter a command.\n");
            return;
        }

        String action = parts[0];
        if (action.equals("Q") && parts.length == 1) {
            textArea.append("Goodbye!\n");
            dispose();
            return;
        }

        if (parts.length != 2) {
            textArea.append("Invalid command format. Use: <command> <number>\n");
            return;
        }

        try {
            int num = Integer.parseInt(parts[1]);

            switch (action) {
                case "W":
                    room.addStudents(num);
                    break;
                case "X":
                    room.removeStudents(num);
                    break;
                case "Y":
                    room.turnOnLight(num);
                    break;
                case "Z":
                    room.turnOffLight(num);
                    break;
                default:
                    textArea.append("Invalid choice. Please try again.\n");
                    return;
            }
        } catch (NumberFormatException e) {
            textArea.append("Invalid number format. Please enter a valid number.\n");
        }

        room.displayStatus();
        textArea.append("\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ResidentManagerGUI();
            }
        });
    }
}
