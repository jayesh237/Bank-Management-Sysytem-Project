package bank.management.system5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class deposite extends JFrame implements ActionListener  {
    
    JTextField amount;
    JButton deposite, back;
    String pinnumber;
       
    deposite(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);
       
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the Amount you Want to Deposite");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 26);
        image.add(text);   
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 20);
        image.add(amount);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(355, 485, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposite) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Amount for Deposite");
            } else {
                try {
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','Deposite','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Succesfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e ) {
                System.out.println(e);
            }
        }
            
        }else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new deposite("");
        
    }
}
