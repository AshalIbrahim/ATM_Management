package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operations extends JFrame implements ATM_Operations, ActionListener {
    JLabel Heading,SubHeading;
    JButton Balance,Deposit,Withdraw,LogOut;
    int addWidth=10;

    public Operations(String cardnum){
        setLayout(null);

        Heading=new JLabel("ATM Services");
        Heading.setFont(new Font("Helvetica",Font.BOLD,28));
        Heading.setBounds(260,20,200,35);
        add(Heading);

        SubHeading=new JLabel("Choose A Service You Want To Avail");
        SubHeading.setFont(new Font("Helvetica",Font.BOLD,24));
        SubHeading.setBounds(Heading.getX()-addWidth*11,Heading.getY()*4,Heading.getWidth()+addWidth*30,Heading.getHeight());
        add(SubHeading);

        Balance=new JButton("View Balance");
        Balance.setBounds(Heading.getX()-10, SubHeading.getY()+addWidth*8,200,30 );
        Balance.addActionListener(this);
        add(Balance);

        int spaceBetween=Balance.getY()-SubHeading.getY();

        Deposit=new JButton("Deposit");
        Deposit.setBounds(Balance.getX(),Balance.getY()+spaceBetween,Balance.getWidth(),Balance.getHeight());
        Deposit.addActionListener(this);
        add(Deposit);

        Withdraw=new JButton("Withdraw");
        Withdraw.setBounds(Balance.getX(),Balance.getY()+2*spaceBetween,Balance.getWidth(),Balance.getHeight());
        Withdraw.addActionListener(this);
        add(Withdraw);

        LogOut=new JButton("Log Out");
        LogOut.setBounds(Balance.getX(),Balance.getY()+3*spaceBetween,Balance.getWidth(),Balance.getHeight());
        LogOut.addActionListener(this);
        add(LogOut);

        setSize(700,600);
        setLocation(100,100);
        setTitle("Options");
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        Operations o=new Operations("1111-1111-1111-1122");
    }
    @Override
    public void check_balance() {

    }

    @Override
    public void deposit(int amount) {

    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
