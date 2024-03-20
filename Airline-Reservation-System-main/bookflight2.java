package AirlineReservationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class bookflight2 extends JFrame implements ActionListener {
    JLabel cls, category, food;
    JRadioButton cl1, cl2, cl3, cat1, cat2, cat3,cat4, f1, f2;

    JButton b,back;
    int fprice;
    int avaseats,avseats;

    bookflight2() {
        setSize(800, 600);

        cls = new JLabel("Choose Your Desired Class");
        cls.setFont(new Font("calibri", Font.BOLD, 30));
        cls.setBounds(5, 5, 500, 250);
        add(cls);

        category = new JLabel("Do you belong to any of these categories ?");
        category.setFont(new Font("calibri", Font.BOLD, 30));
        category.setBounds(5, 100, 650, 250);
        add(category);

        food = new JLabel("Do you want to include food ?");
        food.setFont(new Font("calibri", Font.BOLD, 30));
        food.setBounds(5, 200, 500, 250);
        add(food);

        ButtonGroup b1 = new ButtonGroup();
        ButtonGroup b2 = new ButtonGroup();
        ButtonGroup b3 = new ButtonGroup();

        cl1 = new JRadioButton("Economic Class");
        cl1.setBounds(5, 150, 120, 40);
        b1.add(cl1);
        add(cl1);


        cl2 = new JRadioButton("Buisness Class");
        cl2.setBounds(175, 150, 120, 40);
        b1.add(cl2);
        add(cl2);

        cl3 = new JRadioButton("First Class");
        cl3.setBounds(345, 150, 100, 40);
        b1.add(cl3);
        add(cl3);

        cat1 = new JRadioButton("Senior Citizen");
        cat1.setBounds(5, 250, 120, 40);
        b2.add(cat1);
        add(cat1);

        cat2 = new JRadioButton("Army");
        cat2.setBounds(175, 250, 70, 40);
        b2.add(cat2);
        add(cat2);

        cat3 = new JRadioButton("Handicapped");
        cat3.setBounds(345, 250, 120, 40);
        b2.add(cat3);
        add(cat3);

        cat4=new JRadioButton("None");
        cat4.setBounds(515, 250, 120, 40);
        b2.add(cat4);
        add(cat4);


        f1 = new JRadioButton("Yes");
        f1.setBounds(5, 350, 70, 40);
        b3.add(f1);
  //      f1.setBackground(Color.black);
    //    f1.setForeground(Color.white);
        add(f1);

        f2 = new JRadioButton("No");
        f2.setBounds(175, 350, 70, 40);
        b3.add(f2);
        add(f2);

        b = new JButton("proceed");
        b.setBounds(600, 450, 100, 50);
        b.addActionListener(this);
        add(b);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/5.jpeg"));
        Image j2 = j1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel plane = new JLabel(j3);
        plane.setBounds(1, 1, 1000, 600);
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
        System.out.println(bookflight1.id);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {

            String cls = null;
            int clsp=0;
            if (this.cl1.isSelected()) {
                cls = "Economic class";
               clsp=500;
            } else if (this.cl2.isSelected()) {
                cls = "Business Class";
                clsp=2000;
            } else if (this.cl3.isSelected()) {
                cls = "First Class";
                clsp=1000;
            }


            String cat = null;
            int catp=0;
            if (this.cat1.isSelected()) {
                cat = "senior citezen";
                catp=1000;
            } else if (this.cat2.isSelected()) {
                cat = "Army";
                catp=1000;
            } else if (this.cat3.isSelected())
            {
                cat = "Handicapped";
                catp=1000;
            }else if(this.cat4.isSelected()){
                cat="none";
                catp=0;
            }


            String food = null;
            int fp=0;
            if (this.f1.isSelected()) {
                food = "inclusive";
                fp=1000;
            }
            else if (this.f2.isSelected())
            {
                food = "noninclusive";
            }

            conn c1 = new conn();
            String str = "select fprice from flightdetails where flightid='"+bookflight1.fd+"';";
            try {
                ResultSet rs= c1.s.executeQuery(str);
                while (rs.next()){
                     fprice=rs.getInt("fprice");
                    System.out.println(fprice);
                }


            } catch (Exception e) {
                System.out.println(e);
            }
            int  pricet = fprice+clsp-catp+fp;
            System.out.println(pricet);
            System.out.println(food);
            System.out.println(cls);
            System.out.println(cat);

            conn c = new conn();
           String str1 = "update newbooking set category = '"+cat+"', class = '"+cls+"', food = '"+food+"', price = '"+pricet+"' where userid = '"+login.username+"' ;";
           try {
               c.s.executeUpdate(str1);
               JOptionPane.showMessageDialog(null , "Seat is booked. Proceed to payment.");
               /*new welcome().setVisible(true);
               this.setVisible(false);*/
           } catch (Exception e) {
               System.out.println(e);
           }

            try{
                String str12 = "select avaseats from flightdetails where flightid='"+bookflight1.fd+"';";

                ResultSet rs= c.s.executeQuery(str12);
                while (rs.next()){
                    avaseats=rs.getInt("avaseats");
                    System.out.println(fprice);
                   avseats=avaseats-1;
                }


            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                String str11 = "update flightdetails set avaseats = '"+avseats+"' where flightid = '"+bookflight1.fd+"' ;";

                c.s.executeUpdate(str11);


            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else if(ae.getSource()==back){

            new bookflight1().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new bookflight2();
    }
}

