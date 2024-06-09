package BankManagementSystem;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DataRetrieval {
    private String formNum;
     static ArrayList<String> card_list;
    public static void main(String[] args) {
        System.out.println(checkID_Pin("1087-8563-6256-1122","5020"));

        //        System.out.println(find("6264-2550-1104-1122"));
    }
    public static boolean[] checkID_Pin(String cardnum, String password) {
        if(cardnum.length()==16){
            String dash="-";
            String temp="";
            int start=0;
            int end=4;
            for(int i=0;i<3;i++){
                temp=temp+cardnum.substring(start,end)+dash;
                start+=4;
                end+=4;
            }
            temp=temp+cardnum.substring(start,end);
            cardnum=temp;
        }
        boolean []credentials={false,false};
        boolean found=false;
        CustomConnection customConnection = new CustomConnection();
        try {
            System.out.println("inside try");
            String sql = "SELECT card FROM signupthree";
//            String sql = "SELECT * FROM signup";
            ResultSet resultSet = customConnection.s.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("inside while");
//                int form=resultSet.getInt("formno");
//                String name=resultSet.getString("name");
//                String f_name=resultSet.getString("father_name");
//                String date=resultSet.getString("dob");
//                String gender=resultSet.getString("gender");
//                String email=resultSet.getString("email");
//                System.out.println("Form: " + form + ", Name: " + name + ", Father's Name: " + f_name +
//                        ", Date of Birth: " + date + ", Gender: " + gender + ", Email: " + email);
               if(cardnum.equals(resultSet.getString("card"))){
                   System.out.println("inside if");
                   found=true;
                   credentials[0]=true;
                   System.out.println("card number found");
               break;}
            }
String sql2="SELECT pin FROM signupthree WHERE card='"+cardnum+"'";
            System.out.println(sql2);
            ResultSet rst=customConnection.s.executeQuery(sql2);
            String pin="";
            while(rst.next()){
                pin=rst.getString("pin");
                System.out.println("pin number: "+pin);
            }


if(found){

    if(!pin.equals(password)){found=false;
    }
    else credentials[1]=true;

}
        } catch (Exception e) {
            System.out.println("Error occurred while retrieving data: " + e);
        }
return credentials;
    }
    public static String retrieveUserInfo(String cardnum){
        if(cardnum.length()==16){
            String dash="-";
            String temp="";
            int start=0;
            int end=4;
            for(int i=0;i<3;i++){
                temp=temp+cardnum.substring(start,end)+dash;
                start+=4;
                end+=4;
            }
            temp=temp+cardnum.substring(start,end);
            cardnum=temp;
        }
        String userName="";
        CustomConnection c=new CustomConnection();
        try{
            String sql="SELECT name FROM signup WHERE formno=(SELECT formno FROM signupthree WHERE card='"+cardnum+"')";
            ResultSet rst=c.s.executeQuery(sql);
            while(rst.next()){
                userName=userName+rst.getString("name");
            }
        }
        catch(Exception e){
            System.out.println("Error occured while retrieving data");
        }
        return userName;
    }
    public static boolean find(String cardnum){
        boolean found=false;
        for(int i=0;i<card_list.size();i++){
            if(cardnum.equals(card_list.get(i)))found=true;
        }
        return found;
    }
}
