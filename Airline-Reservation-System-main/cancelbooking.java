package AirlineReservationSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class cancelbooking extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    int flightid,fprice;
    JButton b1, back,Show;
    int avseats,avaseats;

    JTextField amt;
    JTable t1,t2;
    public static String fd;
    cancelbooking() {
        setSize(700, 550);
        l1 = new JLabel("ACTUAL COST - CANCELLATION CHARGES");
        l1.setFont(new Font("arial", Font.BOLD, 18));
        l1.setBounds(50, 50, 500, 100);
        add(l1);

        l2 = new JLabel("REFUNDABLE AMOUNT:");
        l2.setFont(new Font("arial", Font.BOLD, 18));
        l2.setBounds(50, 150, 250, 100);
        add(l2);

        b1 = new JButton("PROCEED");
        setFont(new Font("Serif", Font.PLAIN, 34));
        b1.setBounds(350, 350, 100, 50);
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);


        back = new JButton(i3);
        back.setBounds(10, 5, 60, 35);
        back.addActionListener(this);
        add(back);




        t1=new JTable();
        t1.setBounds(0, 120, 1000, 50);
        t1.setFont(new Font("calibri",Font.PLAIN,18));
        t1.setBackground(Color.white);
        add(t1);

        t2=new JTable();
        t2.setBounds(0, 220, 1000, 50);
        t2.setFont(new Font("calibri",Font.PLAIN,18));
        t2.setBackground(Color.white);
        add(t2);
       /* amt = new JTextField();
        amt.setBounds(300, 170, 100, 50);
        add(amt);*/

        Show = new JButton("Show");
        setFont(new Font("Serif", Font.PLAIN, 34));
        Show.setBounds(200, 350, 100, 50);
        Show.setBackground(Color.white);
        Show.setForeground(Color.black);
        Show.addActionListener( this);
        add(Show);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/19.jfif"));
        Image j2 = j1.getImage().getScaledInstance(700, 550, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel plane = new JLabel(j3);
        plane.setBounds(1, 1, 700, 550);
        add(plane);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae){
       conn c= new conn();
        if(ae.getSource()==Show){


            try{
            String str = "select price,flightid from newbooking where userid='"+login.username+"';";

                ResultSet rs= c.s.executeQuery(str);
                while (rs.next()){
                    fprice=rs.getInt("price");
                    flightid=rs.getInt("flightid");
                    System.out.println(fprice);
                    System.out.println(flightid);
                }


            } catch (Exception e) {
                System.out.println(e);
            }
           // String st = "select flightid from newbooking where userid='"+register.userid+"';";
            try{
int refprice = fprice-500;
                String str1 = "insert into cancbook (userid,flightid,prize,cprice,refprice) values ('"+login.username+"','"+flightid+"','"+fprice+"','"+500+"','"+refprice+"');";

                c.s.executeUpdate(str1);
             //   JOptionPane.showMessageDialog(null , "Data Added");
               // new bookflight2().setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
            String sr = "select prize,cprice from cancbook where userid='"+login.username+"'";
            String s1 = "select refprice from cancbook where userid='"+login.username+"'";
           try{ ResultSet rs1 = c.s.executeQuery(sr);



            t1.setModel(DbUtils.resultSetToTableModel(rs1));
            add(t1);
            t1.setVisible(true);

            ResultSet rs2 = c.s.executeQuery(s1);
               t2.setModel(DbUtils.resultSetToTableModel(rs2));
               add(t2);
               t2.setVisible(true);

        } catch (Exception e) {
           System.out.println(e);
       }
           /* String s = "select refprice from cancbook where userid='"+login.username+"'";
            try{  c.s.executeUpdate(s);

            } catch (Exception e) {
                System.out.println(e);
            }*/
        }
        else if(ae.getSource()==b1){
            try {
                conn c1 = new conn();
                String str1 = "select Flightid from newbooking where userid='" + login.username + "';";
                ResultSet rs = c1.s.executeQuery(str1);
                while (rs.next()) {
                    fd = rs.getString("Flightid");
                    System.out.println(fd);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
            try{
                String str12 = "select avaseats from flightdetails where flightid='"+fd+"';";

                conn c2=new conn();

                ResultSet rs= c2.s.executeQuery(str12);
                while (rs.next()){
                    avaseats=rs.getInt("avaseats");

                    avseats=avaseats+1;
                    System.out.println(avseats);
                }


            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                conn c3=new conn();
                String str11 = "update flightdetails set avaseats = '"+avseats+"' where flightid = '"+fd+"' ;";

                c3.s.executeUpdate(str11);
                JOptionPane.showMessageDialog(null , "Your Booking is cancelled!");

            } catch (Exception e) {
                System.out.println(e);
            }

            try{
                String s="detete from newbooking where userid='"+login.username+"';";
                c.s.executeUpdate(s);

            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == back) {
            setVisible(false);
            new welcome().setVisible(true);
            this.setVisible(false);
        }
        }



    public static void main(String[]args){
        new cancelbooking();
    }
}