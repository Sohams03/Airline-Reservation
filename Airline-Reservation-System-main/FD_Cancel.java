package AirlineReservationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FD_Cancel extends JFrame implements ActionListener
{

    JButton b1,b2,back;



    FD_Cancel(){
        setSize(700, 550);

        b1 = new JButton("FLIGHT DETAILS");
        setFont(new Font("Serif", Font.PLAIN, 24));
        b1.setBounds(125, 240, 200, 35);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("CANCEL BOOKING");
        setFont(new Font("Serif", Font.PLAIN, 24));
        b2.setBounds(380, 240, 200, 35);
        b2.addActionListener(this);
        add(b2);

           /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/WhatsApp Image 2022-10-05 at 9.54.40 PM.jpeg"));
            Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(610,200,35,35);
            add(label);*/


        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/7.jpeg"));
        Image j2 = j1.getImage().getScaledInstance(700,550,Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel l = new JLabel(j3);
        l.setBounds(1,1,700,550);
        add(l);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);


        back = new JButton(i3);
        back.setBounds(10, 5, 60, 35);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            new DemoFD().setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == b2) {

            new cancelFD().setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == back) {

            new welcome().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[]args){
        new AirlineReservationSystem.FD_Cancel();
    }
}