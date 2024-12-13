package Main;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ca sa inchidem fereastra
        window.setResizable(false);//ca sa nu schimbam size-ul
        window.setTitle("2D Game");//titlul jocului


        GamePanel gamePanel=new GamePanel();
        window.add(gamePanel);
        window.pack();//ca sa afiseze ecranul
        window.setLocationRelativeTo(null);//ca sa fie in centru ecranului
        window.setVisible(true);//pentru a vedea fereastra
        gamePanel.setupGame();
        gamePanel.startGameThread();


    }
}
