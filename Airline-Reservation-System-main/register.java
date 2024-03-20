package AirlineReservationSystem;




import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class register extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField fn,mn,ln,mobno,address,email,aadharno,password;

    ButtonGroup b1;
   public static JTextField userid;
    JRadioButton male,female,others;
    JDateChooser date;
    JButton b2,back;
    int labX= 60;
    int labW= 110;
    int labH= 50;
    int txtX= 200;
    int txtW= 150;
    int txtH= 40;

    register(){
        setSize(700,700);
        //date=new JDateChooser();
        //date.setBounds()

        l1 = new JLabel("First Name");
        l1.setBounds(labX,50,labW,labH);
        l1.setForeground(Color.white);
        add(l1);

        l2 = new JLabel("Middle Name");
        l2.setBounds(labX,100,labW,labH);
        l2.setForeground(Color.white);
        add(l2);

        l3 = new JLabel("Last Name");
        l3.setBounds(labX,150,labW,labH);
        l3.setForeground(Color.white);
        add(l3);

        l4 = new JLabel("Mobile Number");
        l4.setBounds(labX,200,labW,labH);
        l4.setForeground(Color.white);
        add(l4);

        l5 = new JLabel("Address");
        l5.setBounds(labX,250,labW,labH);
        l5.setForeground(Color.white);
        add(l5);

        l6 = new JLabel("Gender");
        l6.setBounds(labX,300,labW,labH);
        l6.setForeground(Color.white);
        add(l6);

        l7 = new JLabel("Date of Birth");
        l7.setBounds(labX,350,labW,labH);
        l7.setForeground(Color.white);
        add(l7);
        //datechooser
        date=new JDateChooser();
        date.setBounds(txtX,350,txtW,txtH);
        add(date);

        l8 = new JLabel("Email ID");
        l8.setBounds(labX,400,labW,labH);
        l8.setForeground(Color.white);
        add(l8);

        l9 = new JLabel("Aadhar number");
        l9.setBounds(labX,450,labW,labH);
        l9.setForeground(Color.white);
        add(l9);

        l10 = new JLabel("Enter Password");
        l10.setBounds(labX,500,labW,labH);
        l10.setForeground(Color.white);
        add(l10);

        l11 = new JLabel("numeric userid");
        l11.setBounds(labX,550,labW,labH);
        l11.setForeground(Color.white);
        add(l11);

        //TEXTFIELDS

        fn = new JTextField();
        fn.setBounds(txtX,50,txtW,txtH);
        add(fn);

        mn = new JTextField();
        mn.setBounds(txtX,100,txtW,txtH);
        add(mn);

        ln = new JTextField();
        ln.setBounds(txtX,150,txtW,txtH);
        add(ln);

        mobno = new JTextField();
        mobno.setBounds(txtX,200,txtW,txtH);
        add(mobno);

        address = new JTextField();
        address.setBounds(txtX,250,txtW,txtH);
        add(address);

        email = new JTextField();
        email.setBounds(txtX,400,txtW,txtH);
        add(email);

        aadharno = new JTextField();
        aadharno.setBounds(txtX,450,txtW,txtH);
        add(aadharno);

        password = new JTextField();
        password.setBounds(txtX,500,txtW,txtH);
        add(password);

        userid = new JTextField();
        userid.setBounds(txtX,550,txtW,txtH);
        add(userid);

        b1 = new ButtonGroup(); // creationg a button group for radio buttons to make only one selection at a time

        male = new JRadioButton("Male");
        male.setBounds(200,300,70,40);
        b1.add(male);
        male.setForeground(Color.black);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(275,300,70,40);
        b1.add(female);
        female.setForeground(Color.black);
        add(female);

        others = new JRadioButton("Others");
        others.setBounds(350,300,70,40);
        b1.add(others);
        others.setForeground(Color.black);
        add(others);

        b2 =new JButton("Submit");
        b2.setBounds(400,570,100,50);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        back = new JButton(i3);
        back.setBounds(10, 5, 60, 35);
        back.addActionListener(this);
        add(back);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.jpeg"));
        Image j2 = j1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon j3 = new ImageIcon(j2);
        JLabel plane = new JLabel(j3);
        plane.setBounds(1, 1, 700, 700);
        add(plane);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            String fn= this.fn.getText();
            String mn= this.mn.getText();
            String ln= this.ln.getText();
            String mobno= this.mobno.getText();
            String address= this.address.getText();
            String email= this.email.getText();
            String aadharno= this.aadharno.getText();
            String password= this.password.getText();
            String userid = this.userid.getText();
            //for storing date
            SimpleDateFormat dateFormat= new SimpleDateFormat("dd-mm-yyyy");
            String dob=dateFormat.format(this.date.getDate());
            String gender=null;
            if(this.male.isSelected()){
                gender="male";
            }
            else if(this.female.isSelected()){
                gender="female";
            }
            else{
                gender="others";
            }

            conn c= new conn();
            String str1="insert into register (userid,firstname,middlename,lastname,mobno,address,gender,dob,email,aadharno,password) values ('"+userid+"','"+fn+"','"+mn+"','"+ln+"','"+mobno+"','"+address+"','"+gender+"','"+dob+"','"+email+"','"+aadharno+"','"+password+"');";
            try{
                c.s.executeUpdate(str1);

                JOptionPane.showMessageDialog(null,"Registered Successfully!!");
                new welcome().setVisible(true);
                this.setVisible(false);
            }catch (Exception e) {
                System.out.println(e);
            }


        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Page1().setVisible(true);
        }
    }



    public static void main(String[] args) {
        new register();
    }
}
