package AirlineReservationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1 extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1,b2;
    Page1(){
        //icon
        /*ImageIcon image = new ImageIcon("icons/fox.jpg");
        JFrame.(image.getImage());*/
        setSize(500,400);
        l1=new JLabel("AIRLINE RESERVATION SYSTEM");
        l1.setFont(new Font("serif", Font.BOLD,25));
        l1.setBounds(50,20,420,100);
        add(l1);

        b1=new JButton("Login");
        b1.setFont(new Font("serif",Font.PLAIN,18));
        b1.setBounds(100,250,100,50);
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Register");
        b2.setFont(new Font("serif",Font.PLAIN,18));
        b2.setBounds(300,250,100,50);
        b2.setBackground(Color.white);
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        add (b2);

          ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/9.jpeg"));
       Image j2 = j1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
       ImageIcon j3 = new ImageIcon(j2);
       JLabel plane = new JLabel(j3);
       plane.setBounds(1, 1, 500, 400);
       add(plane);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
         }
         public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            new login();
            this.setVisible(false);
        }
        if (ae.getSource()==b2){
            new register();
            this.setVisible((false));
        }
         }

    public static void main(String[] args) {
        new Page1() ;
    }

}

