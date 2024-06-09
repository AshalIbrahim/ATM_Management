package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionListener

import com.toedter.calendar.JDateChooser;
public class SignUp extends JFrame implements ActionListener {

       private int FormNum;
       private JTextField nameInput,fnameInput,dateInput,emailInput;
       private JButton next,clearAll;
       private JRadioButton m,f;
       private JDateChooser datesec;
       private ButtonGroup group;

    public int getFormNum() {
        return FormNum;
    }

    public SignUp() {
        setLayout(null);
FormNum=(int)(Math.random()*9999);
        //title heading code
JLabel register=new JLabel("Registration Form Number. "+FormNum);
register.setFont(new Font("Calibri",Font.BOLD,38));
register.setBounds(250,40,600,45);
add(register);

        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Calibri",Font.BOLD,28));
        name.setBounds(150,160,200,45);
        add(name);

        nameInput=new JTextField();
        nameInput.setFont(new Font("Calibri",Font.TRUETYPE_FONT,22));
        nameInput.setBounds(name.getX()+name.getWidth()/2,165,400,30);
        add(nameInput);

        JLabel fname=new JLabel("Father's Name: ");
        fname.setFont(new Font("Calibri",Font.BOLD,28));
        fname.setBounds(name.getX()-100,name.getY()+(name.getHeight())+15,400,45);
        add(fname);

        fnameInput=new JTextField();
        fnameInput.setFont(new Font("Calibri",Font.TRUETYPE_FONT,22));
        fnameInput.setBounds(name.getX()+name.getWidth()/2,name.getY()+(name.getHeight())+15+5,400,30);
        add(fnameInput);

        JLabel dob=new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Calibri",Font.BOLD,28));
        dob.setBounds(name.getX()-85,name.getY()+(15+name.getHeight())*2,400,45);
        add(dob);

        datesec=new JDateChooser();
        datesec.setBounds(name.getX()+name.getWidth()/2,name.getY()+5+(15+name.getHeight())*2,270,30);
        add(datesec);
        dateInput=(JTextField) (datesec.getDateEditor().getUiComponent());


        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new Font("Calibri",Font.BOLD,28));
        gender.setBounds(name.getX()-20,name.getY()+(15+name.getHeight())*3,400,45);
        add(gender);

        m=new JRadioButton("Male");
        m.setBounds(name.getX()+name.getWidth()/2,name.getY()+(15+name.getHeight())*3,60,30 );
        m.setBackground(Color.white);
        add(m);

        f=new JRadioButton("Female");
        f.setBounds(name.getX()+name.getWidth()/2+m.getWidth(),name.getY()+(15+name.getHeight())*3,80,30 );
        f.setBackground(Color.white);
        add(f);

        group=new ButtonGroup();
        group.add(m);
        group.add(f);

        JLabel em=new JLabel("Email: ");
        em.setFont(new Font("Calibri",Font.BOLD,28));
        em.setBounds(name.getX()-5,name.getY()+(15+name.getHeight())*4,400,45);
        add(em);

        emailInput=new JTextField();
        emailInput.setFont(new Font("Calibri",Font.TRUETYPE_FONT,22));
        emailInput.setBounds(name.getX()+name.getWidth()/2,name.getY()+5+(15+name.getHeight())*4,400,30);
        add(emailInput);

        next=new JButton("Next");
        next.setBounds(name.getX()-120+datesec.getWidth()*2,name.getY()+5+(15+name.getHeight())*5,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        clearAll=new JButton("Clear");
        clearAll.setBounds(name.getX()-130-next.getWidth()+datesec.getWidth()*2,name.getY()+5+(15+name.getHeight())*5,80,30);
        clearAll.setBackground(Color.black);
        clearAll.setForeground(Color.white);
        clearAll.addActionListener(this);
        add(clearAll);

 setSize(1000,1000);
 setLocation(100,100);
 setTitle("Registering");
 getContentPane().setBackground(Color.white);
 setVisible(true);



    }

    public static void main(String[] args) {
SignUp s=new SignUp();
    }

        @Override
        public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clearAll){
            System.out.println("clear button clicked");
            nameInput.setText(null);
            fnameInput.setText(null);
            //this below statement prints the exact text or string mentioned in the datechooser or textfield
            //if we dont add ".getText" and just add (JTextField) it'll convert the date
            // into a normal text field or input
            System.out.println(((JTextField)datesec.getDateEditor().getUiComponent()).getText());
            datesec.setDate(null);
            emailInput.setText(null);
            group.clearSelection();
        }else {
            //creating variables to store the values of the static variables which we're gonna pass the values to our database
            String formNo = Integer.toString(FormNum);
            String name = nameInput.getText();
            String fname = fnameInput.getText();
            //dateInput=(JTextField) (datesec.getDateEditor().getUiComponent());
            //already done above in the constructor
            String date = dateInput.getText();
            String gender = null;
            if (m.isSelected()) gender = "Male";
            else if (f.isSelected()) gender = "Female";
            String email = emailInput.getText();

            try {
                //this if is to check if any of the section in the form has remained unfilled
                if (name.equals("") || fname.equals("") || date.equals("") || gender.equals("") || email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all details!");
                } else {
                    //for database and jdbc connectivity,

                    CustomConnection c = new CustomConnection();
                    String query = "insert into signup values('" + formNo + "', '" + name + "', '" + fname + "', '" + date + "', '" + gender + "', '" + email + "')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new SignUpAddition(FormNum).setVisible(true);
                }
            } catch (Exception f) {
                System.out.println("Error has occured: " + f);
            }

            /*
            The code you provided appears to be Java code for working with a database using JDBC (Java Database Connectivity). Let's break down what this code does:

CustomConnection c = new CustomConnection();

This line creates an instance of the CustomConnection class, presumably a custom class you've defined for handling database connections. The variable c now holds an instance of this class.
String query = "insert into signup values('" + formNo + "', '" + name + "', '" + fname + "', '" + date + "', '" + gender + "', '" + email + "')";

This line creates an SQL query as a string. It appears to be an INSERT statement for inserting data into a table named signup. The values to be inserted seem to be taken from variables like formNo, name, fname, date, gender, and email. Note that this code is constructing the SQL query using string concatenation, which can be vulnerable to SQL injection if the input values are not properly sanitized.
c.s.executeUpdate(query);

This line executes the SQL query using the executeUpdate method on a Statement object represented by c.s. It appears that c.s is an instance variable or property of the CustomConnection class and holds a reference to a Statement object.
The executeUpdate method is typically used for executing SQL statements that modify the database, such as INSERT, UPDATE, or DELETE statements. In this case, it's used to insert the data specified in the query string into the signup table.
It's important to note that constructing SQL queries by concatenating input data, as shown in the code, can be unsafe and vulnerable to SQL injection if the input data is not properly sanitized or if it comes from untrusted sources. To mitigate this risk, consider using parameterized queries or prepared statements to safely pass data to your SQL queries.
             */
        }
        }
}
