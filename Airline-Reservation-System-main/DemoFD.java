package AirlineReservationSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DemoFD extends JFrame implements ActionListener {
    JButton back,enter;
    JLabel userid;
    JTextField usrid;
    JTable t1;

    DemoFD() {
        setSize(1000, 600);


        getContentPane().setBackground(Color.pink);

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

        enter = new JButton("Enter");
        enter.setBounds(500,450,200,50);
        enter.setFont(new Font("SEGIO", Font.BOLD, 12));
        enter.setBackground(Color.black);
        enter.setForeground(Color.white);
        enter.addActionListener(this);
        add(enter);


       /* userid=new JLabel("Enter userid  :");
        userid.setBounds(200,100,200,50);
        userid.setFont(new Font("SEIGO",Font.BOLD,20));
        add(userid);*/

        t1=new JTable();
        t1.setBounds(0, 220, 1000, 50);
        t1.setFont(new Font("calibri",Font.PLAIN,18));
        t1.setBackground(Color.white);
        add(t1);

        /*usrid=new JTextField();
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

            new FD_Cancel().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==enter){


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
        new DemoFD();
    }
}


