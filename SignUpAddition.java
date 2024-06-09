package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionListener

import com.toedter.calendar.JDateChooser;
public class SignUpAddition extends JFrame implements ActionListener {

    private int FormNum;
    private JLabel register, ReligionText,categoryText,qualificationText,incomeText,occupationText,Elder;
    private JComboBox<String> religion,category,income,qualification,Occupation;
    private JButton next,clearAll;
    private JRadioButton OldYes,OldNo;
    private ButtonGroup group;

    public SignUpAddition(int Formnumber) {
        setLayout(null);
        this.FormNum=Formnumber;
        //title heading code
        register=new JLabel("Sign Up Form: Section 2 ");
        register.setFont(new Font("Calibri",Font.BOLD,38));
        register.setBounds(250,40,600,45);
        add(register);

        ReligionText=new JLabel("Religion: ");
        ReligionText.setFont(new Font("Calibri",Font.BOLD,28));
        ReligionText.setBounds(150,110,200,45);
        add(ReligionText);

        String[]Rnames={"Muslim","Hindu","Christian","Sikh","Buddhist"};

        religion=new JComboBox();

        for(int i=0;i<Rnames.length;i++)religion.addItem(Rnames[i]);

//        religion.setFont(new Font("Calibri",Font.TRUETYPE_FONT,22));
        religion.setBounds(ReligionText.getX()+20+ReligionText.getWidth()/2, ReligionText.getY()+5, 400,30);
        add(religion);


        categoryText=new JLabel("Category: ");
        categoryText.setFont(new Font("Calibri",Font.BOLD,28));
        categoryText.setBounds(ReligionText.getX()-12,ReligionText.getY()+(ReligionText.getHeight())+15,400,45);
        add(categoryText);


        String[]Cnames={"Premium","Platinum","Gold","Regular"};

        category=new JComboBox();

        for(int i=Cnames.length-1;i>=0;i--)category.addItem(Cnames[i]);
//        category.setFont(new Font("Calibri",Font.TRUETYPE_FONT,22));
        category.setBounds(ReligionText.getX()+20+ReligionText.getWidth()/2,ReligionText.getY()+(ReligionText.getHeight())+15+5,400,30);
        add(category);


        incomeText=new JLabel("Income: ");
        incomeText.setFont(new Font("Calibri",Font.BOLD,28));
        incomeText.setBounds(categoryText.getX()+15,ReligionText.getY()+(15+ReligionText.getHeight())*2,400,45);
        add(incomeText);


        String[]Income={"< 25000","25000 - 74999","75000 - 124999","125000 - 200000","> 200000"};

        income=new JComboBox();

        for (String s : Income) income.addItem(s);
        income.setBounds(ReligionText.getX()+20+ReligionText.getWidth()/2,ReligionText.getY()+5+(15+ReligionText.getHeight())*2,400,30);
        add(income);



        qualificationText=new JLabel("Qualification: ");
        qualificationText.setFont(new Font("Calibri",Font.BOLD,28));
        qualificationText.setBounds(ReligionText.getX()-60,ReligionText.getY()+(15+ReligionText.getHeight())*3,400,45);
        add(qualificationText);

        String[]Qualification={"Intermediate","A levels","Undergraduate","Graduate","PHD"};

        qualification=new JComboBox();

        for(int i=0;i<Qualification.length;i++)qualification.addItem(Qualification[i]);
        qualification.setBounds(ReligionText.getX()+20+ReligionText.getWidth()/2,ReligionText.getY()+(15+ReligionText.getHeight())*3,400,30 );

        add(qualification);
//        f=new JRadioButton("Female");
//        f.setBounds(ReligionText.getX()+ReligionText.getWidth()/2+m.getWidth(),ReligionText.getY()+(15+ReligionText.getHeight())*3,80,30 );
//        f.setBackground(Color.white);
//        add(f);
//
//        group=new ButtonGroup();
//        group.add(m);
//        group.add(f);


        occupationText=new JLabel("Occupation: ");
        occupationText.setFont(new Font("Calibri",Font.BOLD,28));
        occupationText.setBounds(qualificationText.getX()+20,ReligionText.getY()+(15+ReligionText.getHeight())*4,400,45);
        add(occupationText);

        String[]Occ={"Salaried","Non Salaried","Entrepenuer"};

        Occupation=new JComboBox();
        for(int i=0;i<Occ.length;i++)Occupation.addItem(Occ[i]);



        Occupation.setBounds(ReligionText.getX()+20+ReligionText.getWidth()/2,ReligionText.getY()+5+(15+ReligionText.getHeight())*4,400,30);
        add(Occupation);

        Elder=new JLabel("Elder Citizen: ");
        Elder.setFont(new Font("Calibri",Font.BOLD,28));
        Elder.setBounds(qualificationText.getX()+5,ReligionText.getY()+(15+ReligionText.getHeight())*5,400,45);
        add(Elder);

        OldYes=new JRadioButton("Yes");
        OldYes.setBounds(qualificationText.getX()*3,ReligionText.getY()-3+(15+ReligionText.getHeight())*5,70,45);
        OldYes.setBackground(Color.white);
        add(OldYes);

        OldNo=new JRadioButton("No");
        OldNo.setBounds(qualificationText.getX()*4,ReligionText.getY()-3+(15+ReligionText.getHeight())*5,100,45);
        OldNo.setBackground(Color.white);
        add(OldNo);


 group=new ButtonGroup();
        group.add(OldNo);
        group.add(OldYes);


        next=new JButton("Next");
        next.setBounds(ReligionText.getX()+religion.getWidth()+30,ReligionText.getY()+5+(15+ReligionText.getHeight())*6,80,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        clearAll=new JButton("Clear");
        clearAll.setBounds(ReligionText.getX()-next.getWidth()+religion.getWidth(),ReligionText.getY()+5+(15+ReligionText.getHeight())*6,80,30);
        clearAll.setBackground(Color.black);
        clearAll.setForeground(Color.white);
        clearAll.addActionListener(this);
        add(clearAll);

        setSize(1000,1000);
        setLocation(100,100);
        setTitle("Sign Up Form 2");
        getContentPane().setBackground(Color.white);
        setVisible(true);



    }

    public static void main(String[] args) {
        SignUpAddition s=new SignUpAddition(1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clearAll){
            System.out.println("clear button clicked");
            religion.setSelectedIndex(0);
            category.setSelectedIndex(0);
            income.setSelectedIndex(0);
            qualification.setSelectedIndex(0);
            Occupation.setSelectedIndex(0);
            group.clearSelection();
            //this below statement prints the exact text or string mentioned in the datechooser or textfield
            //if we dont add ".getText" and just add (JTextField) it'll convert the date
            //into a normal text field or input

        }else {
            String rel = (String) religion.getSelectedItem();
            String categ = (String) category.getSelectedItem();
            String inc = (String) income.getSelectedItem();

            //already done above in the constructor
            String education = (String) qualification.getSelectedItem();;
            String occ=(String) Occupation.getSelectedItem();
            String elder="";
            if(OldYes.isSelected())elder="Yes";else if(OldNo.isSelected()){elder="No";}

            try {
                if (elder.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all details!");
                } else {
                    //for database and jdbc connectivity
                    CustomConnection c = new CustomConnection();
                    String query = "insert into SignUpAddition values('" + FormNum+"', '" + rel + "', '" + categ + "', '" + inc + "', '" + education + "', '" + occ +"', '" + elder + "')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new SignUpThree(FormNum).setVisible(true);
                }
            } catch (Exception f) {
                System.out.println("Error has occured: " + f);
            }
            /*
            The code you provided appears to be Java code for working with a database using JDBC (Java Database Connectivity). Let's break down what this code does:

* CustomConnection c = new CustomConnection();
This line creates an instance of the CustomConnection class, presumably a custom class you've defined for handling database connections. The variable c now holds an instance of this class.


* String query = "insert into signup values('" + formNo + "', '" + name + "', '" + fname + "', '" + date + "', '" + gender + "', '" + email + "')";
This line creates an SQL query as a string. It appears to be an INSERT statement for inserting data into a table named signup. The values to be inserted seem to be taken from variables like formNo, name, fname, date, gender, and email. Note that this code is constructing the SQL query using string concatenation, which can be vulnerable to SQL injection if the input values are not properly sanitized.

* c.s.executeUpdate(query);
This line executes the SQL query using the executeUpdate method on a Statement object represented by c.s. It appears that c.s is an instance variable or property of the CustomConnection class and holds a reference to a Statement object.
The executeUpdate method is typically used for executing SQL statements that modify the database, such as INSERT, UPDATE, or DELETE statements. In this case, it's used to insert the data specified in the query string into the signup table.
It's important to note that constructing SQL queries by concatenating input data, as shown in the code, can be unsafe and vulnerable to SQL injection if the input data is not properly sanitized or if it comes from untrusted sources. To mitigate this risk, consider using parameterized queries or prepared statements to safely pass data to your SQL queries.
             */
        }
    }
}
