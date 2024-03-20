package AirlineReservationSystem;

import javax.swing.*;
import java.awt.*;

public class bookseat1 extends JFrame {
    JLabel l1;
    JButton b1;
    bookseat1(){
        setSize(800, 600);
        l1 = new JLabel("FLIGHT DETAILS");
        l1.setFont(new Font("arial", Font.BOLD, 18 ));
        l1.setBounds(300, 10, 500, 50);
        add(l1);

        b1 = new JButton("BOOK SEAT");
        setFont(new Font("Serif", Font.PLAIN, 18));
        b1.setBounds(600, 480, 110, 50);
        add(b1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new bookseat1();
    }
}