package AirlineReservationSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField mobno,email;
    JTextField username1;

    public static String username , password;
    JPasswordField password1;
    JLabel l1, l2,l3,l4,Val;
    JButton si, cn,back;

    login(){
        setSize(500,400);
        username1 = new JTextField();
        username1.setBounds(200, 60, 140, 40);
        add(username1);

      /*  mobno = new JTextField();
        mobno.setBounds(180, 120, 120, 40);
        add(mobno);

        email = new JTextField();
        email.setBounds(180, 180, 120, 40);
        add(email); */

        Val = new JLabel();  //username label
        Val.setFont(new Font("SEGIO", Font.BOLD, 14));
        Val.setBounds(80, 180, 500, 50);
        Val.setForeground(Color.red);
        add(Val);

        password1 = new JPasswordField();
        password1.setBounds(200, 140, 140, 40);
        add(password1);

        l1 = new JLabel("USERNAME");  //username label
        l1.setFont(new Font("SEGIO", Font.BOLD, 14));
        l1.setBounds(80, 60, 100, 50);
        //l1.setFont(new Font("SEGIO", Font.BOLD, 14));
        add(l1);

       /* l2 = new JLabel("Mobile Number");  //password label
        l2.setBounds(40, 120,150 , 50);
        l2.setFont(new Font("SEGIO", Font.BOLD, 14));
        add(l2);

        l3 = new JLabel("Email");  //password label
        l3.setBounds(40, 180, 100, 50);
        l3.setFont(new Font("SEGIO", Font.BOLD, 14));
        add(l3); */

        l4 = new JLabel("PASSWORD");  //password label
        l4.setBounds(80, 140, 100, 50);
        l4.setFont(new Font("SEGIO", Font.BOLD, 14));
        add(l4);


        si = new JButton("Sign In");
        si.setBounds(80, 260, 120, 40);
       si.setForeground(Color.gray);
       si.setBackground(Color.white);
        si.addActionListener(this);
        add(si);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);


        back = new JButton(i3);
        back.setBounds(10, 5, 60, 35);
        back.addActionListener(this);
        add(back);

        cn = new JButton("Cancel");
        cn.setBounds(260, 260, 120, 40);
        cn.setForeground(Color.gray);
        cn.setBackground(Color.white);
        add(cn);

        ImageIcon j1 = new ImageIcon(ClassLoader.getSystemResource("icons/10.jpeg"));
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
        if(ae.getSource()==si){
            if(username1.getText().trim().isEmpty() && password1.getText().trim().isEmpty())
            {
            Val.setText("Field(s) are Empty");
            } else if (username1.getText().trim().isEmpty()) {
                Val.setText("Username is Empty");
            } else if (password1.getText().trim().isEmpty()) {
                Val.setText("Password is Empty");
            }
            username = this.username1.getText();
             password = String.valueOf(this.password1.getPassword());
            conn c = new conn();
            try{
                String str1= "select * from login where username= '"+username+"'and password='"+password+"';";
               ResultSet rs = c.s.executeQuery(str1);
               if(rs.next()) {
                   JOptionPane.showMessageDialog(null, "Login Successful!");
                   new welcome().setVisible(true);
                   this.setVisible(false);
               }

               else {

                   JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
               }

            }catch(Exception e){
                System.out.println(e);
            }


        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Page1().setVisible(true);
        }

    }



    public static void main(String[] args) {
        new login();

    }
}
