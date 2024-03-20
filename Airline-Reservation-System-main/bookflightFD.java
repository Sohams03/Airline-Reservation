package AirlineReservationSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class bookflightFD extends JFrame implements ActionListener {
    JButton back,proceed;
    JLabel userid,l1,l2,l3,l4,l5,l6;
    JTextField usrid;
    JTable t1;

    bookflightFD() {
        setSize(1000, 600);


        getContentPane().setBackground(Color.pink);
        l1 = new JLabel("User ID");
        l1.setFont(new Font("SEIGO", Font.PLAIN, 21));
        l1.setBounds(0, 180, 500, 50);
        l1.setForeground(Color.WHITE);
        add(l1);

        l2 = new JLabel("Flight ID");
        l2.setFont(new Font("SEIGO", Font.PLAIN, 21));
        l2.setBounds(167, 180, 500, 50);
        l2.setForeground(Color.WHITE);
        add(l2);

        l3 = new JLabel("Category");
        l3.setFont(new Font("SEIGO", Font.PLAIN, 21));
        l3.setBounds(334, 180, 500, 50);
        l3.setForeground(Color.WHITE);
        add(l3);

        l4 = new JLabel("Class");
        l4.setFont(new Font("SEIGO", Font.PLAIN, 21));
        l4.setBounds(501, 180, 500, 50);
        l4.setForeground(Color.WHITE);
        add(l4);


        l5 = new JLabel("Food");
        l5.setFont(new Font("SEIGO", Font.PLAIN, 21));
        l5.setBounds(668, 180, 500, 50);
        l5.setForeground(Color.WHITE);
        add(l5);

        l6 = new JLabel("Price");
        l6.setFont(new Font("SEIGO", Font.PLAIN, 21));
        l6.setBounds(835, 180, 500, 50);
        l6.setForeground(Color.BLACK);
        add(l6);
       /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/FD.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(1, 1, 1000, 600);
        add(label);*/

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);


        back = new JButton(i3);
        back.setBounds(10, 5, 60, 35);
        back.addActionListener(this);
        add(back);

      /*  enter = new JButton("Enter");
        enter.setBounds(500,100,200,50);
        enter.setFont(new Font("SEGIO", Font.BOLD, 12));
        enter.setBackground(Color.black);
        enter.setForeground(Color.white);
        enter.addActionListener(this);
        add(enter);


        userid=new JLabel("Enter userid  :");
        userid.setBounds(200,100,200,50);
        userid.setFont(new Font("SEIGO",Font.BOLD,20));
        add(userid);*/

        proceed = new JButton("show");
        proceed.setBounds(550,450,200,50);
        proceed.setFont(new Font("SEGIO", Font.BOLD, 12));
        proceed.setBackground(Color.black);
        proceed.setForeground(Color.white);
        proceed.addActionListener(this);
        add(proceed);

        t1=new JTable();
        t1.setBounds(0, 220, 1000, 50);
        t1.setFont(new Font("calibri",Font.PLAIN,18));
        t1.setBackground(Color.white);
        add(t1);

        /* usrid=new JTextField();
        usrid.setBounds(350,100,100,50);
        usrid.setFont(new Font("SEIGO",Font.BOLD,20));
        add(usrid);*/

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.jpeg"));
        Image j2 = j1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel plane = new JLabel(j3);
        plane.setBounds(1, 1, 1000, 600);
        add(plane);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new bookflight2().setVisible(true);
        }
        else if(ae.getSource()==proceed){


            try {

                String str = "select userid,flightid,category,class,food,price from newbooking where userid='"+login.username+"'";
                conn c = new conn();
                ResultSet rs1 = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs1));
                add(t1);
                t1.setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new bookflightFD();
    }
}



