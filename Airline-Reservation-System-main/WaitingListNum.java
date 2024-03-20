package AirlineReservationSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class WaitingListNum extends JFrame implements ActionListener {
    JTable seats, list;
    JTextField fid;
    JLabel l1, l2, l3,l4,l5;
    public static String fd;

    JButton enter, book, back;

    WaitingListNum() {
        setSize(800, 600);
       /* l1 = new JLabel("Enter Flight ID ");
        l1.setFont(new Font("SEIGO",Font.BOLD,21));
        l1.setBounds(50,50,200,50);
        add(l1);

        fid=new JTextField();
        fid.setBounds(200,50,100,50);
        fid.setFont(new Font("SEIGO",Font.BOLD,20));
        add(fid);*/

        seats = new JTable();
        seats.setBounds(0, 300, 800, 200);
        seats.setFont(new Font("calibri", Font.PLAIN, 18));
        seats.setBackground(Color.white);
        add(seats);

        list = new JTable();
        list.setBounds(0, 125, 800, 50);
        list.setFont(new Font("calibri", Font.PLAIN, 18));
        list.setBackground(Color.white);
        add(list);


        enter = new JButton("Enter");
        enter.setBounds(150, 500, 100, 50);
        enter.setFont(new Font("SEGIO", Font.BOLD, 12));
        enter.setBackground(Color.black);
        enter.setForeground(Color.white);
        enter.addActionListener(this);
        add(enter);

        book = new JButton("Book now");
        book.setBounds(550, 500, 100, 50);
        book.setFont(new Font("SEGIO", Font.BOLD, 12));
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        book.addActionListener(this);
        add(book);


        l2 = new JLabel("Number of available seats: ");
        l2.setFont(new Font("SEIGO", Font.PLAIN, 28));
        l2.setBounds(0, 75, 500, 50);
        l2.setForeground(Color.WHITE);
        add(l2);

        l3 = new JLabel("Waiting List ");
        l3.setFont(new Font("SEIGO", Font.PLAIN, 28));
        l3.setBounds(0, 220, 500, 50);
        l3.setForeground(Color.WHITE);
        add(l3);

        l4 = new JLabel("User ID ");
        l4.setFont(new Font("SEIGO", Font.PLAIN, 18));
        l4.setBounds(0, 260, 500, 50);
        l4.setForeground(Color.WHITE);
        add(l4);

        l5 = new JLabel("Flight ID ");
        l5.setFont(new Font("SEIGO", Font.PLAIN, 18));
        l5.setForeground(Color.WHITE);
        l5.setBounds(400, 260, 500, 50);
        add(l5);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/6.jpeg"));
        Image j2 = j1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel plane = new JLabel(j3);
        plane.setBounds(1, 1, 800, 600);
        add(plane);

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
        if (ae.getSource() == enter) {
            try {
                conn c = new conn();
                String str1 = "select Flightid from waitinglist where userid='" + login.username + "';";
                ResultSet rs = c.s.executeQuery(str1);
                while (rs.next()) {
                    fd = rs.getString("Flightid");
                    System.out.println(fd);
                }
                String str = "select userid,Flightid from waitinglist where Flightid= '" + fd + "'";
                ResultSet rs1 = c.s.executeQuery(str);


                seats.setModel(DbUtils.resultSetToTableModel(rs1));


            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                conn c = new conn();
                String str2 = "select avaseats from flightdetails where flightid='" + fd + "';";
                ResultSet rs2 = c.s.executeQuery(str2);
                list.setModel(DbUtils.resultSetToTableModel(rs2));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == book) {
            JOptionPane.showMessageDialog(null,"Your seat is booked .Choose your custom options.");
            try {
                String str1 = "insert into newbooking (userid,flightid) values ('" + login.username + "','" + fd + "');";

                conn c = new conn();
                c.s.executeUpdate(str1);
               // JOptionPane.showMessageDialog(null, "Data Added");
                new bookflight2().setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new welcome().setVisible(true);
        }
    }





    public static void main(String[] args) {
        new WaitingListNum();
    }
}
