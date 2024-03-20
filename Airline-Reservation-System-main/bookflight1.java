package AirlineReservationSystem;

import com.sun.tools.javac.Main;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class bookflight1 extends JFrame implements ActionListener {
    JLabel to, from, date,username,l1,l2,l3,l4;
    JButton proceed, Search,back;
    JTextField to1, from1;
    JDateChooser j1;
    JTable def;
    JTextField FD, ID;
   static String id;
   public static String fd;
   int avaseats;
    bookflight1() {
        setSize(800, 600);

        //label
        from = new JLabel("From:");
        from.setFont(new Font("serif", Font.BOLD, 20));
        from.setBounds(400, 150, 150, 40);
        from.setForeground(Color.white);
        add(from);

        to = new JLabel("To:");
        to.setFont(new Font("serif", Font.BOLD, 20));
        to.setBounds(100, 150, 150, 40);
        to.setForeground(Color.white);
        add(to);

        date = new JLabel("Date:");
        date.setFont(new Font("serif", Font.BOLD, 20));
        date.setBounds(100, 200, 150, 40);
        date.setForeground(Color.white);
        add(date);

        JLabel Enter = new JLabel("Enter Flight ID:");
        Enter.setFont(new Font("serif", Font.BOLD, 20));
        Enter.setBounds(100, 500, 150, 40);
        Enter.setForeground(Color.white);
        add(Enter);

         l1 = new JLabel("Flight ID:");
        l1.setFont(new Font("serif", Font.BOLD, 18));
        l1.setBounds(150, 240, 150, 40);
        l1.setForeground(Color.white);
        add(l1);

         l2 = new JLabel("Time:");
        l2.setFont(new Font("serif", Font.BOLD, 18));
        l2.setBounds(265, 240, 150, 40);
        l2.setForeground(Color.white);
        add(l2);

         l3 = new JLabel("Flight Name:");
        l3.setFont(new Font("serif", Font.BOLD, 18));
        l3.setBounds(380, 240, 150, 40);
        l3.setForeground(Color.white);
        add(l3);

        l4 = new JLabel("Flight Price:");
        l4.setFont(new Font("serif", Font.BOLD, 18));
        l4.setBounds(490, 240, 150, 40);
        l4.setForeground(Color.white);
        add(l4);
        //text field
        from1 = new JTextField();
        from1.setFont(new Font("calibri", Font.PLAIN, 18));
        from1.setBounds(475, 150, 150, 40);
        add(from1);

        to1 = new JTextField();
        to1.setFont(new Font("calibri", Font.PLAIN, 18));
        to1.setBounds(175, 150, 150, 40);
        add(to1);

        //datechooser
        j1 = new JDateChooser();
        j1.setBounds(175, 200, 150, 40);
        add(j1);

        def = new JTable();
        def.setBounds(150, 275, 450, 200);
        add(def);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        //button
        Search = new JButton("Search");
        Search.setFont(new Font("serif", Font.BOLD, 20));
        Search.setBounds(475, 200, 150, 40);
        Search.addActionListener(this);
        add(Search);

        proceed = new JButton("Proceed");
        proceed.setFont(new Font("serif", Font.BOLD, 20));
        proceed.setBounds(625, 500, 150, 40);
        proceed.addActionListener(this);
        add(proceed);

        FD = new JTextField();
        FD.setFont(new Font("calibri", Font.PLAIN, 18));
        FD.setBounds(275, 500, 150, 40);
        add(FD);

       /* ID = new JTextField();
        ID.setFont(new Font("calibri", Font.PLAIN, 18));
        ID.setBounds(400, 75, 150, 40);
        add(ID);

        username = new JLabel("USERNAME:");
        username.setFont(new Font("serif", Font.BOLD, 20));
        username.setBounds(240, 75, 150, 40);
        add(username);*/

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);


        back = new JButton(i3);
        back.setBounds(10, 5, 60, 35);
        back.addActionListener(this);
        add(back);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/8.jpeg"));
        Image j2 = j1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel plane = new JLabel(j3);
        plane.setBounds(1, 1, 1000, 600);
        add(plane);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Search) {
            try {
                String str = "select flightid,time,fname,fprice from flightdetails";
                conn c = new conn();
                ResultSet rs1 = c.s.executeQuery(str);

                def.setModel(DbUtils.resultSetToTableModel(rs1));
                add(def);
                def.setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == proceed) {
            // id = this.ID.getText();
            fd = this.FD.getText();
            conn c = new conn();
            try {
                String S = "select avaseats from flightdetails where flightid = '" + fd + "';";
                ResultSet rs = c.s.executeQuery(S);
                while (rs.next()) {
                    avaseats = rs.getInt("avaseats");


                }
            } catch (Exception e) {
                System.out.println(e);
            }
            if (avaseats == 0) {
                try {
                    {
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(this,"Seats are not available in selected flights.Do you want to add yourself to the waiting list?","Title on Box",dialogButton);
                        if(dialogResult==0){
                            System.out.println("Yes option");
                            String S ="insert into waitinglist (userid,flightid) values ('" +login.username+ "','" +fd+ "');";
                            c.s.executeUpdate(S);
                            JOptionPane.showMessageDialog(null, "Successfully Added to waiting list ");
                            new WaitingListNum().setVisible(true);
                            this.setVisible(false);

                        }else{
                            System.out.println("No option");
                        }
                    }


            }catch(Exception e){
                System.out.println(e);
            }
        }else {


            try{
                String str1 = "insert into newbooking (userid,flightid) values ('" +login.username+ "','" +fd+ "');";

                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Data Added");
                new bookflight2().setVisible(true);
                this.setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"You have already booked ticket with this userid");
            }}
        } else if (ae.getSource() == back) {

            new welcome().setVisible(true);
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new bookflight1();
    }
}
