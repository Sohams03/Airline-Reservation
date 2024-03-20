package AirlineReservationSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1, b2, b3, b4, ok;
    JDialog d1;
    JFrame F;

    welcome() {
        setSize(800, 600);
        l1 = new JLabel("WELCOME !!");
        l1.setFont(new Font("Olivia", Font.ITALIC, 34));
        l1.setBounds(300, 10, 600, 100);
        add(l1);

        b1 = new JButton("ALREADY BOOKED");
       // b1.setText(username);
        setFont(new Font("Serif", Font.PLAIN, 18));
        b1.setBounds(225, 200, 350, 50);
        b1.setBackground(Color.gray);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);


        b2 = new JButton("NEW BOOKING");
        setFont(new Font("Serif", Font.PLAIN, 18));
        b2.setBounds(225, 300, 350, 50);
        b2.setBackground(Color.gray);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("WAITING LIST");
        setFont(new Font("Serif", Font.PLAIN, 18));
        b3.setBounds(225, 400, 350, 50);
        b3.setBackground(Color.gray);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Logout");
        setFont(new Font("Serif", Font.PLAIN, 18));
        b4.setBounds(650, 10, 90, 35);
        b4.setBackground(Color.gray);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        add(b4);

        getContentPane().setBackground(Color.CYAN);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/5.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(1,1,800,600);
        add(label);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new FD_Cancel().setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new bookflight1().setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
           new WaitingListNum().setVisible(true);
        } else if (ae.getSource() == b4) {
            JOptionPane.showMessageDialog(null, "You are logged out Succesfully");
            setVisible(false);
            new Page1().setVisible(true);

        }

    }
    public static void main (String[]args){
        new welcome();
    }
}