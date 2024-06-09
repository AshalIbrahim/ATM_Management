package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpThree extends JFrame implements ActionListener {
    private int FormNum;
    private JLabel title, Account_type, Card_num, card, Pin_number, pin, services;
    private String card_num, pin_num;
    private JRadioButton Ac1, Ac2, Ac3;
    private int checkBox_width = 70;
    private int checkBox_height = 50;
    private JCheckBox atm, internetBanking, mobileBanking, email, Cheque_book, e_statement, agreement;
    private ButtonGroup group;
    private JButton submit, clear;
private boolean serviceSelected;
    public SignUpThree(int FormNum) {
        setLayout(null);
this.FormNum=FormNum;
        //title heading code
        title = new JLabel("Sign Up Form: Section 3 ");
        title.setFont(new Font("Calibri", Font.BOLD, 34));
        title.setBounds(350, 30, 400, 35);
        add(title);

        Account_type = new JLabel("Account type:");
        Account_type.setFont(new Font("Calibri", Font.BOLD, 30));
        Account_type.setBounds(120, 120, 300, 35);
        add(Account_type);

        Ac1 = new JRadioButton("Current Account");//current button label
        Ac1.setBounds(320, 120, 150, 30);
        Ac1.setBackground(Color.white);
        add(Ac1);

        Ac2 = new JRadioButton("Savings Account");//savings button label
        Ac2.setBounds(Account_type.getX() * 4, 120, 150, 30);
        Ac2.setBackground(Color.white);
        add(Ac2);

        Ac3 = new JRadioButton("Deposit Account"); //deposit button label
        Ac3.setBounds(Ac1.getX(), Ac2.getY() + Ac2.getY() / 4, 150, 30);
        Ac3.setBackground(Color.white);
        add(Ac3);

        group = new ButtonGroup(); //added to button group so that only one button gets selected
        group.add(Ac1);
        group.add(Ac2);
        group.add(Ac3);

        Card_num = new JLabel("Card Number:"); //card number label
        Card_num.setFont(new Font("Calibri", Font.BOLD, 30));
        Card_num.setBounds(Account_type.getX(), Account_type.getY() * 2, 300, 35);
        add(Card_num);

        card = new JLabel("XXXX-XXXX-XXXX-1122"); //card number
        card.setFont(new Font("Calibri", Font.BOLD, 30));
        card.setBounds(Account_type.getX() * 3, Account_type.getY() * 2, 300, 35);
        add(card);

        Pin_number = new JLabel("PIN Number:"); //pin number label
        Pin_number.setFont(new Font("Calibri", Font.BOLD, 30));
        Pin_number.setBounds(Account_type.getX(), Account_type.getY() * 2 + Account_type.getY() / 2, 300, 35);
        add(Pin_number);

        pin = new JLabel("XXXX"); //PIN number
        pin.setFont(new Font("Calibri", Font.BOLD, 30));
        pin.setBounds(Account_type.getX() * 3, Account_type.getY() * 2 + Account_type.getY() / 2, 300, 35);
        add(pin);

        services = new JLabel("Services Required:"); //card number
        services.setFont(new Font("Calibri", Font.BOLD, 30));
        services.setBounds(Account_type.getX(), Account_type.getY() * 3 + 30, 300, 35);
        add(services);

        atm = new JCheckBox("ATM Card");
        atm.setBounds(Account_type.getX(), services.getY() + 40, 90, 40);
        atm.setBackground(Color.white);
        add(atm);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(Account_type.getX() * 2 + checkBox_width, services.getY() + 40, 90 + checkBox_width, 40);
        internetBanking.setBackground(Color.white);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(Account_type.getX(), atm.getY() + checkBox_height, 150, 40);
        mobileBanking.setBackground(Color.white);
        add(mobileBanking);

        email = new JCheckBox("Email & SMS ALerts");
        email.setBounds(internetBanking.getX(), mobileBanking.getY(), 90 + checkBox_width, 40);
        email.setBackground(Color.white);
        add(email);

        Cheque_book = new JCheckBox("Cheque Book");
        Cheque_book.setBounds(mobileBanking.getX(), mobileBanking.getY() + checkBox_height, 90 + checkBox_width, 40);
        Cheque_book.setBackground(Color.white);
        add(Cheque_book);

        e_statement = new JCheckBox("E-statement");
        e_statement.setBounds(internetBanking.getX(), email.getY() + checkBox_height, 90 + checkBox_width, 40);
        e_statement.setBackground(Color.white);
        add(e_statement);

        agreement = new JCheckBox("I declare that information filled above is accurate to my knowledge.");
        agreement.setBounds(mobileBanking.getX(), Cheque_book.getY() + checkBox_height * 2, 90 + checkBox_width * 7, 40);
        agreement.setBackground(Color.white);
        add(agreement);

        submit = new JButton("Submit");
        submit.setBounds(Ac1.getX(), agreement.getY() + checkBox_height, 110, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        clear = new JButton("Clear");
        clear.setBounds(Ac2.getX(), agreement.getY() + checkBox_height, 110, 30);
        clear.setBackground(Color.lightGray);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        add(clear);

        setSize(1000, 1000);
        setLocation(100, 10);
        setTitle("Sign Up Form 3");
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        SignUpThree a1 = new SignUpThree(1);
    }

    public String getRandom() {
        int num = (int) (Math.random() * 9999);
        String val = Integer.toString(num);

        if (val.length() < 4) {
            for (int i = val.length(); i < 4; i++) {
                val = "0" + val;
            }
        }

        return val;
    }

    public String getCard() {
        return getRandom() + "-" + getRandom() + "-" + getRandom() + "-" + "1122";
    }

    public String getPin() {
        return getRandom();
    }

    public void clearServices() {
        atm.setSelected(false);
        internetBanking.setSelected(false);
        mobileBanking.setSelected(false);
        email.setSelected(false);
        Cheque_book.setSelected(false);
        e_statement.setSelected(false);
        agreement.setSelected(false);
    }

    public boolean areSelected() {
        if (atm.isSelected() || internetBanking.isSelected() || mobileBanking.isSelected() || email.isSelected() || Cheque_book.isSelected() || e_statement.isSelected()) {
            return true;
        } else return false;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            group.clearSelection();
            clearServices();
        } else {

            String acc_type = "";
            if (Ac1.isSelected()) {
                acc_type = "Current Account";
            } else if (Ac2.isSelected()) {
                acc_type = "Savings Account";
            } else if (Ac3.isSelected()) {
                acc_type = "Deposit Account";
            }
            card_num = getCard();
            pin_num = getPin();
            String ATM="No";
            String internetB="No";
            String mobileB="No";
            String Email="No";
            String cheque="No";
            String Estatement="No";
    // private JCheckBox atm, internetBanking,
    // mobileBanking, email, Cheque_book, e_statement, agreement;
if(atm.isSelected()){
    ATM="Yes";
}
if(internetBanking.isSelected()){
    internetB="Yes";
}
if(mobileBanking.isSelected()){
    mobileB="Yes";
}
if(email.isSelected()){
    Email="Yes";
}
if(Cheque_book.isSelected()){
    cheque="Yes";
}
if(e_statement.isSelected()){
    Estatement="Yes";
}

            try {
                if (acc_type.equals("") || !areSelected() || !agreement.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all details!");
                } else {
                    JOptionPane.showMessageDialog(null, "Card Number   \n"+card_num+"\n"+"\nPin Number   \n"+pin_num);
//                    for database and jdbc connectivity
                    CustomConnection c=new CustomConnection();
                    String query="insert into SignUpThree values('" + FormNum + "', '" + acc_type + "', '" + card_num + "', '" + pin_num + "', '" + ATM + "', '" + internetB + "', '" + mobileB + "', '" + Email + "', '" + cheque + "', '" + Estatement + "')";
//                    CustomConnection c = new CustomConnection();
//                    String query = "insert into SignUpThree values('" + FormNum+"', '" + rel + "', '" + categ + "', '" + inc + "', '" + education + "', '" + occ +"', '" + elder + "')";
                    c.s.executeUpdate(query);
                    setVisible(false);
//                    new SignUpThree().setVisible(true);
                }
            } catch (Exception f) {
                System.out.println("Error has occured: " + f);
            }

        }
    }
}
