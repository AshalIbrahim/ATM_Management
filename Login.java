package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {

    private JButton login, signUp, clear;
    private JTextField cardnumT, PinNum;

    public Login() {
        setLayout(null);


        ImageIcon ic = new ImageIcon("C:\\Users\\T L S\\IdeaProjects\\Full_Bank_Management_System\\src\\bankLogo.png");
        Image ic1 = ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(ic1);
        JLabel logo = new JLabel(ic2);
        logo.setBounds(150, 35, 100, 100);
        add(logo);

        JLabel heading = new JLabel("Welcome to ATM");
        heading.setFont(new Font("Helvetica", Font.BOLD, 30));
        heading.setBounds(300, 40, 300, 40);
        add(heading);

        JLabel cardnum = new JLabel("Card Number: ");
        cardnum.setFont(new Font("Helvetica", Font.BOLD, 26));
        cardnum.setBounds(300, 130, 200, 40);
        add(cardnum);

        cardnumT = new JTextField();
        cardnumT.setBounds(510, 140, 168, 25);
        add(cardnumT);

//cardnumT,PinNum

        JLabel pinNum = new JLabel("PIN Number: ");
        pinNum.setFont(new Font("Poppins", Font.BOLD, 26));
        add(pinNum);
        pinNum.setBounds(300, 220, 400, 40);

        PinNum = new JPasswordField();
        PinNum.setBounds(510, 230, 168, 25);
        add(PinNum);

        login = new JButton("Log In");
        login.setBounds(350, 300, 100, 24);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);

        add(login);


        clear = new JButton("Clear All");
        clear.setBounds(510, 300, 100, 24);
        clear.setBackground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(login.getX() + (login.getWidth() / 2), 350, 175, 24);
        signUp.addActionListener(this);
        add(signUp);

        setSize(1000, 700);
        setVisible(true);
        setTitle("ATM");
        getContentPane().setBackground(Color.white);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            System.out.println("Clear button is clicked");
            cardnumT.setText(null);
            PinNum.setText(null);
        } else if (e.getSource() == login) {
            String cardnum = cardnumT.getText();
            String pinnum = PinNum.getText();
            System.out.println("card number: " + cardnum);
            System.out.println("pin number: " + pinnum);
            System.out.println("Login button is clicked");
            //we can directly call a static method through the className.Method()
            boolean[] found = DataRetrieval.checkID_Pin(cardnum, pinnum);
            if (found[0] && found[1]) {
                System.out.println("Login Successful");
                JOptionPane.showMessageDialog(null, "Login Successful\n" + "Welcome, " + DataRetrieval.retrieveUserInfo(cardnum));

            } else if (found[0]) {
                System.out.println("Login Failed");
                JOptionPane.showMessageDialog(null, "Login Failed\n" + "Incorrect Pin");
            }

        } else if (e.getSource() == signUp) {
            System.out.println("Sign Up button is clicked");
            setVisible(false);
            new SignUp().setVisible(true);
        } else System.out.println("No button is clicked");
    }

    public static void main(String[] args) {
        Login l = new Login();


    }


}
