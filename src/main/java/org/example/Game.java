package org.example;

import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cubehead");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        /// config


    }
}
