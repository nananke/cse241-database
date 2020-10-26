import java.sql.*; // Use 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.List;
import java.util.Scanner;
import java.beans.Introspector;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

class Advlist {
   static int count = 0;

   public static int generate(Statement s, String customer_id_record) {
      try {

         String strSelect = "SELECT * FROM  (SELECT c_id,c_address,c_name,tele_num FROM customer_info order BY dbms_random.value )  WHERE rownum = 1";
         ResultSet rset = s.executeQuery(strSelect);

         if (!rset.next()) {
            System.out.println("ssd");
            // System.out.println("Empty result, search again,maybe the department you
            // searched do not fit the requirement");
            throw new SQLException();
         }
         do { // Move the cursor to the next row, return false if no more row
            String c_id = rset.getString("c_id");
            String c_address = rset.getString("c_address");
            String c_name = rset.getString("c_name");
            String tele_num = rset.getString("tele_num");
            customer_id_record = c_id;
            System.out.printf("%-10s  -  %-13s  -  %10s     -     %19s  ", "ID", "NAME", "TELE", "ADDRESS");
            System.out.println();
            System.out.printf("%-10s  -  %-13s  -  %10s     -     %19s \n ", c_id, c_name, tele_num, c_address);
         } while (rset.next());
      } catch (SQLException e) {
         e.printStackTrace();
      }
      int ssaa = Integer.parseInt(customer_id_record);
      return ssaa;

  
   }

   public static void main(String[] arg) throws SQLException, IOException, java.lang.ClassNotFoundException {
      // Class.forName ("oracle.jdbc.driver.OracleDriver");
      String u = "";
      String ps = "";
      boolean condition_0 = false;
      String customer_id_record = "";
      do {
         try {
            System.out.println("enter Oracle user id");
            Scanner scnr2 = new Scanner(System.in);
            u = scnr2.nextLine();
            System.out.println("enter Oracle password for your id");
            Scanner scnr3 = new Scanner(System.in);
            ps = scnr3.nextLine();
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241", u, ps);
            con.setAutoCommit(false);
            Statement s = con.createStatement();
            Statement s2 = con.createStatement();
            Statement s3 = con.createStatement();
            Statement s4 = con.createStatement();
            Statement s5 = con.createStatement();
            Statement s6 = con.createStatement();
            Statement s7 = con.createStatement();
            Statement s8 = con.createStatement();
            Statement s9 = con.createStatement();
            Statement s10 = con.createStatement();
            Statement s11 = con.createStatement();
            condition_0 = true;
            System.out.println("connected");
            System.out.println();
            System.out.println();

            System.out.println("Assigning with a alreadly exist customer randomly");
            System.out.println();
            System.out.println("<<<<<<<<<<SELECTING>>>>>>>>");
            System.out.println("<<<<<<<<<<SELECTING>>>>>>>>");
            System.out.println("<<<<<<<<<<SELECTING>>>>>>>>");
            System.out.println("<<<<<<<<<<SELECTING>>>>>>>>");
            System.out.println("HERE IS YOU RANDOM CUSTOMER INFORMATION");
            System.out.println();
            System.out.println();

            int new_num = generate(s, customer_id_record);
            System.out.println();
            System.out.println("C_ID = " + new_num);
            System.out.println();
            String new_string = Integer.toString(new_num);
            System.out.println();
            System.out.println("Welcome to the bank interface");
            System.out.println("please select the service you want to do");
            System.out.println("1. Account deposit/withdrawal");
            System.out.println("2. Purchases using a card");
            System.out.println("3. Open a new account.");
            System.out.println();
            System.out.println("enter below");

            Boolean choice_condition = false;

            do {
               Scanner scnr4 = new Scanner(System.in);
               int choice = scnr4.nextInt();
               if (choice == 1) {
                  System.out.println("1");
                  // option 1
                  System.out.println(new_string);
                  opt1(s5, s6, s7, s8, s9, s10, s11, new_string, con);
                  choice_condition = true;
               } else if (choice == 2) {
                 // System.out.println("2");
                  // option2
                  Boolean card_choice_boolean = false;
                do{
                  System.out.println("Choice a card you want to use; enter 1 for credit card; enter 2 for debit card");
                  Scanner scrn_11 = new Scanner(System.in);
                  int choice_card = scrn_11.nextInt();
                  if(choice_card == 1 ){
                     card_choice_boolean = true;
                     opt2_credit_card(new_string,con);
                  }
                  else if (choice_card ==2){
                     card_choice_boolean = true;
                     opt2_debit_card(new_string,con);
                  }
                  else{
                     System.out.println("please enter a vaild number, re-enter");
                  }
               }while(card_choice_boolean == false);



                  choice_condition = true;
               } else if (choice == 3) {
                  System.out.println("3");
                  // option 3
                 opt3(con);
                  choice_condition = true;
               } else {
                  System.out.println("please select a vaild opt,again");

               }
            } while (choice_condition == false);

            // depart_search(s);
            // updating_debit_card(s,s2,s3);
            try {
               con.commit();
            } catch (Exception e) {
               System.out.println("commit fail");
            }
            s.close();
            con.close();

         } catch (Exception e) {
            System.out.println("password or username incorrect, cannot login, try again");
            System.out.println();
         }

         System.out.println();
         System.out.println(" press 1 to re-run, press anyother key to quit bank interface; However, to ensure the security, you have to enter you username and password again");
       try{
         Scanner sssss = new Scanner(System.in);
         int sssssss = sssss.nextInt();
         if (sssssss == 1){
            condition_0 = false;
         }
         else
         {
            condition_0 = true;
         }

      }catch(Exception e){
         System.out.println("GOODBEY");
      }


      } while (condition_0 == false);
   }



public static void opt3(Connection con){
   System.out.println("WELECOME TO THE CREATE ACCOUNT PHASE");
   System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
   System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
   Boolean bo = false;
   int last_accoutID = 0;
   try{
      String strSelect = "select * from (select * from account_info order by account_id DESC) where rownum = 1 ";
      Statement s2 = con.createStatement();
      ResultSet rset_2 = s2.executeQuery(strSelect);
      if (!rset_2.next()) {}
      do { // Move the cursor to the next row, return false if no more row
         String a_id = rset_2.getString("account_id");
         last_accoutID = Integer.parseInt(a_id) + 1;
    //     System.out.printf("%-10s  -  %-13s  -  %10s  -  %10s  ", "ID", "running_balance", "credit_limit", "ccard_num");
  //       System.out.println(a_id);
         
      } while (rset_2.next());

   }

catch(SQLException ee){
   ee.printStackTrace();
}


   do{
   System.out.println("Please select a type of account; press 1 for checking or saving; press 2 for saving account, you cannot save less than 500$(min_balance) ?");
   Scanner scrn = new Scanner(System.in);
   int atype = scrn.nextInt();
   if(atype == 1){
      System.out.println("apply for a checking account ");
      try {
         Statement s11 = con.createStatement();
         System.out.println();
         System.out.println(last_accoutID);
         String sql =   "insert into account_info(account_id,type) values("+last_accoutID+",'checking')";
         s11.executeUpdate(sql);
         System.out.println();

      } catch (SQLException e) {
         e.printStackTrace();
      }


      try {
         Statement s13 = con.createStatement();
         System.out.println();
         String sql =    "insert into checking_account(checking_id , running_balance, interest_rate) values ("+last_accoutID+",'0','%0.2')";
         s13.executeUpdate(sql);
         System.out.println();
         System.out.println("Applied successed");
         System.out.println("HERE IS YOU ACCOUNT INFOMATION");
         System.out.println("Account_ID: "+last_accoutID+"; Balance: 0"+"; Interest rate: 0.2%");
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      bo = true;

   }
   else if(atype ==2){

      System.out.println("apply for a saving account ");
      try {
         Statement s11 = con.createStatement();
         System.out.println();
         System.out.println(last_accoutID);
         String sql =   "insert into account_info(account_id,type) values("+last_accoutID+",'saving')";
         s11.executeUpdate(sql);
         System.out.println();
         //System.out.println("Applied successed");
      } catch (SQLException e) {
         e.printStackTrace();
      }


      try {
         Statement s13 = con.createStatement();
         System.out.println();
         String sql =    "insert into saving_account(saving_id , running_balance, interest_rate) values ("+last_accoutID+",'500','%2.2')";
         s13.executeUpdate(sql);
         System.out.println();
         System.out.println("Applied successed");
         System.out.println("Account_ID: "+last_accoutID+"; Balance: 0"+"; Interest rate: %2.2");
      } catch (SQLException e) {
         e.printStackTrace();
      }

      bo = true;
   }
   else{
      System.out.println("please enter a vaild number");
      bo = false;
   }
}while(bo == false);


}



// since debit card it tied to a checking account balance, we can re-use the funtion for checking account
public static void opt2_debit_card(String customer_id, Connection con){
   //ArrayList<String[]> card_record = new ArrayList<String[]>();

 System.out.println("we will show your checking account that ties to this debit card");

   try {

      Statement s = con.createStatement();
      String strSelect = "select * from own_account,checking_account where checking_id = a_id and c_id = "+customer_id;
      ResultSet rset = s.executeQuery(strSelect);

      if (!rset.next()) {
         
      }
      do { // Move the cursor to the next row, return false if no more row
         String a_id = rset.getString("a_id");
    
     
         System.out.println();
         System.out.println(a_id);
         mins_accout_balance_checking(a_id, "checking", con);
      } while (rset.next());
   } catch (SQLException e) {
      //e.printStackTrace();
      System.out.println();
      System.out.println("Sorry,this customer has no checking account,as well as debit card, regenerate a customer");


      try{
         String strSelect_0 = "select * from ( select * from own_account,checking_account   where  checking_id = a_id    order by dbms_random.value ) where rownum =1 ";
         Statement s2 = con.createStatement();
         ResultSet rset_2 = s2.executeQuery(strSelect_0);
         if (!rset_2.next()) {}
         do { // Move the cursor to the next row, return false if no more row
            String a_id = rset_2.getString("a_id");
            mins_accout_balance_checking(a_id, "checking", con);
         } while (rset_2.next());
      }
      catch(SQLException ee){
         ee.printStackTrace();
      }
      
   }

}




//function for card purchase
public static void opt2_credit_card(String customer_id, Connection con){
   ArrayList<String[]> card_record = new ArrayList<String[]>();
   String custom = " ";
   custom = customer_id;
   try {
      

      String strSelect = "select c_id,running_balance, credit_limit from customer_info, credit_card, has_credit_card where customer_info.c_id = has_credit_card.customer_id and credit_card.ccard_num = has_credit_card.credit_id and customer_info.c_id  = "+custom;
      Statement s10 = con.createStatement();
      ResultSet rset = s10.executeQuery(strSelect);
      if (!rset.next()) {}
//case1
      do { // Move the cursor to the next row, return false if no more row
         String c_id = rset.getString("c_id");
         String running_balance = rset.getString("running_balance");
         String credit_limit = rset.getString("credit_limit");
         String ccard_num = rset.getString("ccard_num");
         System.out.printf("%-10s  -  %-13s  -  %10s  ", "ID", "running_balance", "credit_limit", "ccard_num");
         System.out.println();
         System.out.printf("%-10s  -  %-13s  -  %10s  \n ", c_id, running_balance, credit_limit, ccard_num);
         String[] NumPlusBalace = { c_id, running_balance,credit_limit,ccard_num };
         card_record.add(NumPlusBalace);
         
      } while (rset.next());
      using_credit_card(card_record,con);

   }catch(SQLException e){

      //case2
      System.out.println("This customer does not have a credit card; regenerate a random customer that has credit card");

   try{
      String strSelect = "select * from (select c_id,running_balance, credit_limit, ccard_num from customer_info, credit_card, has_credit_card where customer_info.c_id = has_credit_card.customer_id and credit_card.ccard_num = has_credit_card.credit_id order by dbms_random.value ) where ROWNUM = 1";
      Statement s2 = con.createStatement();
      ResultSet rset_2 = s2.executeQuery(strSelect);
      if (!rset_2.next()) {}
      do { // Move the cursor to the next row, return false if no more row
         String c_id = rset_2.getString("c_id");
         String running_balance = rset_2.getString("running_balance");
         String credit_limit = rset_2.getString("credit_limit");
         String ccard_num = rset_2.getString("ccard_num");
         System.out.printf("%-10s  -  %-13s  -  %10s  -  %10s  ", "ID", "running_balance", "credit_limit", "ccard_num");
         System.out.println();
         System.out.printf("%-10s  -  %-13s  -  %10s  -  %10s  \n ", c_id, running_balance, credit_limit, ccard_num);
         String[] NumPlusBalace = { c_id, running_balance,credit_limit,ccard_num };
         card_record.add(NumPlusBalace);
         
      } while (rset_2.next());
      using_credit_card(card_record,con);
   }
   catch(SQLException ee){
      ee.printStackTrace();
   }

   }
 
}




public static void using_credit_card(ArrayList<String[]> s,Connection con){
   for(int i = 0; i <s.size(); i++){
      System.out.println("HERE IS YOUR CREDIT CARD INFO");
      System.out.println("card_num: " +s.get(i)[3]);
      System.out.println("running_balance: " +s.get(i)[1]);
      System.out.println("limit: " +s.get(i)[2]); 
      System.out.println();
      System.out.println();
      System.out.println();
   }
   Boolean condition = false;
   do{
   System.out.println();
   System.out.println("Enter the number of card you want to use");
   Scanner scrn = new Scanner(System.in);
   String card_num = scrn.nextLine();
    for(int i = 0; i <s.size(); i++){
       if (card_num.equals(s.get(i)[3])){
         
          System.out.println("enter succeed, proceed to next step");
          System.out.println("<<<<<<>>>>>>>>>>><<<<<<>>>>>>>><<>>");
          System.out.println("<<<<<<>>>>>>>>>>><<<<<<>>>>>>>><<>>");
          System.out.println("<<<<<<>>>>>>>>>>><<<<<<>>>>>>>><<>>");
          System.out.println("How much is the item you want to buy?");
          System.out.println("enter a numerical number");
          Boolean num_check = false;
          int price2 = 0;
          do{
             try{
         Scanner scrn_item = new Scanner(System.in);
         price2 = scrn_item.nextInt();
          num_check = true;
             }catch(Exception e){
                num_check = false;
                System.out.println("re-enter");
             }
          }while(num_check == false);
          
          int price = price2;
          
          
          
          System.out.println("<<<<<<>>>>>>>>>>><<<<<<>>>>>>>><<>>");
          System.out.println("checking if exceed card limit");
          System.out.println("<<<<<<>>>>>>>>>>><<<<<<>>>>>>>><<>>");
          int rest_balance = Integer.parseInt(s.get(i)[2]) - Integer.parseInt(s.get(i)[1]) - price;
          if(rest_balance>=0){
             System.out.println("GOOD, You can buy it");

             try {
               Statement s11 = con.createStatement();
               System.out.println();
               String sql = "update credit_card SET running_balance = running_balance +" + price + "where "
                     + "ccard_num = " +  s.get(i)[3];
               s11.executeUpdate(sql);
               System.out.println();
               System.out.println("BOUGHT!!!");
               
               System.out.println("SERVICE END");
      
            } catch (SQLException e) {
               e.printStackTrace();
            }

             condition = true;
          }
          else{
            System.out.println("Dont have enough balance to buy it, enter a less number or switch to another card");
            condition = false;
          }
       }
       
    }
    if (condition == false){
       System.out.println("re-enter a valid card number");
    }
   }

   while(condition == false);

}



   // randomly assign with a alreadly existed user
   public static void opt1(Statement s, Statement s6, Statement s7, Statement s8, Statement s9, Statement s10,
         Statement s11, String customer_id, Connection con) {
      String customer_id_record = "";

      customer_id_record = customer_id;
      // customer_id = "1021";
      System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
      System.out.println("  Deposit & Withdraw Interface");
      System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
      System.out.println();
      System.out.println("Here is you account infomation");
     // System.out.println(customer_id_record);
      System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");

      try {

         String strSelect = "select * from own_account,account_info where c_id =" + customer_id
               + "and a_id = account_id";
         ResultSet rset = s.executeQuery(strSelect);

         if (!rset.next()) {
            System.out.println("Sorry, This customer does not have any account in this Bank");
            System.out
                  .println("Re-generate a new random customer that has at least one account");
            System.out.println("TYPE 1 to re-generate");

            Boolean choice_check = false;
            do {
               Scanner scnr = new Scanner(System.in);
               int choice = scnr.nextInt();
               // code for re generate a random new customer that count(account_id)>=1

               if (choice == 1) {
                  System.out.println("re-generate");
                  try {
                     String re_c_id = " select c_id from(select count(a_id),c_id from account_info,own_account where account_id = a_id  group by c_id    order BY dbms_random.value )where ROWNUM = 1 ";
                     ResultSet rset_10 = s10.executeQuery(re_c_id);
                     if (!rset_10.next()) {
                     }

                     do { // Move the cursor to the next row, return false if no more row
                        String c_id = rset_10.getString("c_id");
                        System.out.printf("%-10s", "CustomerID");
                        System.out.println();
                        System.out.printf("%-10s\n ", c_id);
                        // customer_id_record = c_id;
                        opt1(s, s6, s7, s8, s9, s10, s11, c_id, con);

                     } while (rset_10.next());

                  } catch (SQLException e) {
                     // e.printStackTrace();
                  }

                  choice_check = true;
               } 
            } while (choice_check == false);

         }

         else {
            ArrayList<String[]> account_record = new ArrayList<String[]>();
            do { // Move the cursor to the next row, return false if no more row
               String c_id = rset.getString("c_id");
               String a_id = rset.getString("a_id");
               String type = rset.getString("type");
               System.out.printf("%-10s  -  %-13s  -  %10s ", "CustomerID", "account_id", "type");
               System.out.println();
               System.out.printf("%-10s  -  %-13s  -  %10s \n ", c_id, a_id, type);
               String[] a_idPlusType = { a_id, type };
               account_record.add(a_idPlusType);
            } while (rset.next());
            System.out.println("<<<<<<<<<>>>>>>>>>>>");
            // for(int i = 0; i<account_record.size();i++){
            // System.out.println(account_record.get(i)[0]);
            // }

            System.out.println("<<<<<<<<<>>>>>>>>>>>");
            System.out.println("<<<<<<<<<>>>>>>>>>>>");
            Boolean condition_check = false;
            do {
               System.out.println("If you want to deposit, enter 1; If you want to withdraw, enter 2");
               Scanner scrn = new Scanner(System.in);
               int DW_choice = scrn.nextInt();

               if (DW_choice == 1) {
                  condition_check = true;
                  System.out.println("For deposit, you have to choice the bank with teller, here is the list");
                  System.out.println();
                  // System.out.println("We will randomly assign you with a avaiable bank");

                  try {
                     String strSelect_dbank = "select Bank_id from bank where type = 'other'";
                     ResultSet rset_dbank = s7.executeQuery(strSelect_dbank);

                     if (!rset_dbank.next()) {
                        System.out.println("Sorry, No record");

                     }
                     do { // Move the cursor to the next row, return false if no more row
                        String b_id = rset_dbank.getString("bank_id");
                        System.out.printf("%-10s", "bank ID: ");
                        System.out.printf("%-10s\n ", b_id);

                     } while (rset_dbank.next());
                     Boolean condition = false;
                     do {
                        System.out.println("Please eneter the bank_id you want to go");
                        Scanner new_s = new Scanner(System.in);
                        String entered_bid = new_s.nextLine();
                        int entered_bid_int = Integer.parseInt(entered_bid);

                        if (entered_bid_int == 900 || entered_bid_int == 901 || entered_bid_int == 902
                              || entered_bid_int == 905 || entered_bid_int == 907 || entered_bid_int == 909
                              || entered_bid_int == 911 || entered_bid_int == 913 || entered_bid_int == 915
                              || entered_bid_int == 917) {

                           money_dopsite(account_record, s9, s10, con);
                           condition = true;
                        } else {
                           System.out.println("Check List Again; Please enter a vaild bank ID");
                        }
                     } while (condition == false);

                  } catch (SQLException e) {
                     e.printStackTrace();
                  }
               } else if (DW_choice == 2) {

                  System.out.println("For withdraw, you can use any bank, here is the list");
                  Statement s12 = con.createStatement();

                  try {
                     String strSelect_dbank_0 = "select Bank_id from bank";
                     ResultSet rset_dbank_0 = s12.executeQuery(strSelect_dbank_0);

                     if (!rset_dbank_0.next()) {
                        System.out.println("Sorry, No record");

                     }
                     do { // Move the cursor to the next row, return false if no more row
                        String b_id = rset_dbank_0.getString("bank_id");
                        System.out.printf("%-10s", "bank ID: ");
                        System.out.printf("%-10s\n ", b_id);

                     } while (rset_dbank_0.next());
                     Boolean condition = false;
                     do {
                        System.out.println("Please eneter the bank_id you want to go");
                        Scanner new_s_0 = new Scanner(System.in);
                        String entered_bid_0 = new_s_0.nextLine();
                        int entered_bid_int = Integer.parseInt(entered_bid_0);

                        if (entered_bid_int == 900 || entered_bid_int == 901 || entered_bid_int == 902
                              || entered_bid_int == 904 || entered_bid_int == 905 || entered_bid_int == 906
                              || entered_bid_int == 907 || entered_bid_int == 908 || entered_bid_int == 909
                              || entered_bid_int == 910 || entered_bid_int == 911 || entered_bid_int == 912
                              || entered_bid_int == 913 || entered_bid_int == 914 || entered_bid_int == 915
                              || entered_bid_int == 916 || entered_bid_int == 917 || entered_bid_int == 918
                              || entered_bid_int == 919) {
                            money_withdraw(account_record,con);
                         //  money_dopsite(account_record, s9, s10, con);
                           condition = true;
                        } else {
                           System.out.println("Check List Again; Please enter a vaild bank ID");
                        }
                     } while (condition == false);
                  } catch (SQLException e) {
                     e.printStackTrace();
                  }

                  condition_check = true;

               } else {
                  System.out.println("Please enter vaild number");
               }
            } while (condition_check == false);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

   }
public static void money_withdraw(ArrayList<String[]> s,Connection con){
   String c = "checking";
   //String sav = "saving";
   System.out.println("Here is you account record List again, Which account you want to withdraw?");
   for (int i = 0; i < s.size(); i++) {
      System.out.println("Account_id: " + s.get(i)[0] + ";  Account_type: " + s.get(i)[1]);
      System.out.println();
   }

   Boolean condition = false;

   // int cc = 0;
   do {
      System.out.println();
      System.out.println("Please enter accountID you want to withdraw");
      Scanner new_s = new Scanner(System.in);
      String entered_bid = new_s.nextLine();

      for (int i = 0; i < s.size(); i++) {
         // System.out.println(s.get(i)[0]);
         if (entered_bid.equals(s.get(i)[0])) {
            // System.out.println("Matched");
            condition = true;
            if(s.get(i)[1].equals(c)){
            mins_accout_balance_checking(s.get(i)[0], s.get(i)[1],con);
            }
            else{
               mins_accout_balance_saving(s.get(i)[0], s.get(i)[1],con);
            }
         }
      }
      if (condition == false) {
         System.out.println("ERROR, re-enter");
      }

   } while (condition == false);
}


public static void mins_accout_balance_saving(String a, String b, Connection con){
 
   System.out.println("<<<<<<<>>>>>>>");
   System.out.println(" Withdraw_INFORMATION");
   System.out.println("<<<<<<<>>>>>>>");
   System.out.println("<<<<<<<>>>>>>>");
   System.out.println("   REMINDER   ");
   System.out.println("bank a rule for saving acount: min_balance is 500$, if less than 500$, saving account will automatically minus 10$ as penalties");
   System.out.println("<<<<<<<>>>>>>>");
   System.out.println("<<<<<<<>>>>>>>");
   String running_balance = "";
   try {
  
      Statement s9 = con.createStatement();
      String strSelect = "select * from account_info," + b + "_account where account_info.account_id = " + b
            + "_account." + b + "_id and account_info.account_id = " + a;
      ResultSet rset = s9.executeQuery(strSelect);

      if (!rset.next()) {
         // nothing get
      }

      else {
         do {
            String type = rset.getString("type");
            String a_id = rset.getString("account_id");
            running_balance = rset.getString("running_balance");
            String interest_rate = rset.getString("interest_rate");
            System.out.printf("%-10s  -  %-13s  -  %10s ", "type", "account_id", "running_balance", "interest_rate");
            System.out.println();
            System.out.printf("%-10s  -  %-13s  -  %10s\n ", type, a_id, running_balance, interest_rate);
         } while (rset.next());

      }
   } catch (SQLException e) {
      e.printStackTrace();
   }


   Boolean condition_new = false;
   do {
      Boolean overdraw_check = false;
     

      System.out.println("How much money you want to withdraw from this " + b + " account?");
     // do{ 
      Scanner scrn = new Scanner(System.in);
      int withdraw_money = scrn.nextInt();
      System.out.println();
      System.out.println("So, the amount you want to withdraw is: " + withdraw_money + "?");
      System.out.println("Press 1 to continue, press 2 to re-enter, press anyother key to exit");

      Scanner scrn_1 = new Scanner(System.in);
      int choice = scrn_1.nextInt();
      if (choice == 1) {
         System.out.println("WITHDRAW COMMAND COMFIRED, STARTING");
         System.out.println();
         System.out.println("For saving account, we need to check if go negative");
         int rb = Integer.parseInt(running_balance) - withdraw_money; 
         if(rb>=0&&rb>=500){
            System.out.println("greater, can do the withdraw without penalities");

            try {
               Statement s11 = con.createStatement();
               System.out.println();
               String sql = "update " + b + "_account SET running_balance = running_balance - " + withdraw_money + "where "
                     + b + "_id = " + a;
               s11.executeUpdate(sql);
               System.out.println();
               System.out.println("SERVICE END");
               // try {
               // con.commit();
               // } catch (Exception e) {
               // System.out.println("commit fail");
               // }
            } catch (SQLException e) {
               e.printStackTrace();
            }


            try {
               Statement s10 = con.createStatement();
               String strSelect = "select * from account_info," + b + "_account where account_info.account_id = " + b
                     + "_account." + b + "_id and account_info.account_id = " + a;
               ;
               ResultSet rset = s10.executeQuery(strSelect);
   
               if (!rset.next()) {
                  // nothing get
               }
   
               else {
                  do {
                     String type = rset.getString("type");
                     String a_id = rset.getString("account_id");
                     String running_balance_12 = rset.getString("running_balance");
                     String interest_rate = rset.getString("interest_rate");
                     System.out.printf("%-10s  -  %-13s  -  %10s ", "type", "account_id", "running_balance",
                           "interest_rate");
                     System.out.println();
                     System.out.printf("%-10s  -  %-13s  -  %10s\n ", type, a_id, running_balance_12, interest_rate);
                  } while (rset.next());
   
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }



            condition_new = true;
         }

         else if(rb>=0&&rb<500){
            System.out.println("penalities applied here");

            try {
               Statement s11 = con.createStatement();
               System.out.println();
               String sql = "update " + b + "_account SET running_balance = running_balance - 10 -" + withdraw_money + "where "
                     + b + "_id = " + a;
               s11.executeUpdate(sql);
               System.out.println();
               System.out.println("SERVICE END");
               // try {
               // con.commit();
               // } catch (Exception e) {
               // System.out.println("commit fail");
               // }
            } catch (SQLException e) {
               e.printStackTrace();
            }


            try {
               Statement s10 = con.createStatement();
               String strSelect = "select * from account_info," + b + "_account where account_info.account_id = " + b
                     + "_account." + b + "_id and account_info.account_id = " + a;
               ;
               ResultSet rset = s10.executeQuery(strSelect);
   
               if (!rset.next()) {
                  // nothing get
               }
   
               else {
                  do {
                     String type = rset.getString("type");
                     String a_id = rset.getString("account_id");
                     String running_balance_12 = rset.getString("running_balance");
                     String interest_rate = rset.getString("interest_rate");
                     System.out.printf("%-10s  -  %-13s  -  %10s ", "type", "account_id", "running_balance",
                           "interest_rate");
                     System.out.println();
                     System.out.printf("%-10s  -  %-13s  -  %10s\n ", type, a_id, running_balance_12, interest_rate);
                  } while (rset.next());
   
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }



            condition_new = true;
         }

         else{
            System.out.println("OVERDRAW, enter a lower number");
            condition_new = false;
         }


         System.out.println();
         System.out.println();
         System.out.println();
   

        
      } else if (choice == 2) {
         condition_new = false;
      } else {
         System.out.println("GOODBYE");
         condition_new = true;
      }
   } while (condition_new == false);
   System.out.println();
   System.out.println();

   









   System.out.println("WITHDRAW SUCCEED!!!");

   System.out.println("SERVICE END");
   
}

public static void mins_accout_balance_checking(String a, String b, Connection con){
 
   System.out.println("<<<<<<<>>>>>>>");
   System.out.println(" Withdraw_INFORMATION");
   System.out.println("<<<<<<<>>>>>>>");
   String running_balance = "";
   try {
  
      Statement s9 = con.createStatement();
      String strSelect = "select * from account_info," + b + "_account where account_info.account_id = " + b
            + "_account." + b + "_id and account_info.account_id = " + a;
      ResultSet rset = s9.executeQuery(strSelect);

      if (!rset.next()) {
         // nothing get
      }

      else {
         do {
            String type = rset.getString("type");
            String a_id = rset.getString("account_id");
            running_balance = rset.getString("running_balance");
            String interest_rate = rset.getString("interest_rate");
            System.out.printf("%-10s  -  %-13s  -  %10s ", "type", "account_id", "running_balance", "interest_rate");
            System.out.println();
            System.out.printf("%-10s  -  %-13s  -  %10s\n ", type, a_id, running_balance, interest_rate);
         } while (rset.next());

      }
   } catch (SQLException e) {
      e.printStackTrace();
   }


   Boolean condition_new = false;
   do {
      Boolean overdraw_check = false;
     

      System.out.println("How much money you want to withdraw/spend from this " + b + " account?");
     // do{ 
      Scanner scrn = new Scanner(System.in);
      int withdraw_money = scrn.nextInt();
      System.out.println();
      System.out.println("So, the amount you want to withdraw/spend is: " + withdraw_money + "?");
      System.out.println("Press 1 to continue, press 2 to re-enter, press anyother key to exit");

      Scanner scrn_1 = new Scanner(System.in);
      int choice = scrn_1.nextInt();
      if (choice == 1) {
         System.out.println("WITHDRAW/SPEND COMMAND COMFIRED, STARTING");
         System.out.println();
         System.out.println("For checking account, we need to check if go negative");
         int rb = Integer.parseInt(running_balance) - withdraw_money; 
         if(rb>=0){
            System.out.println("greater, can do the withdraw/spend");

            try {
               Statement s11 = con.createStatement();
               System.out.println();
               String sql = "update " + b + "_account SET running_balance = running_balance - " + withdraw_money + "where "
                     + b + "_id = " + a;
               s11.executeUpdate(sql);
               System.out.println();
               System.out.println("SERVICE END");
     
            } catch (SQLException e) {
               e.printStackTrace();
            }


            try {
               Statement s10 = con.createStatement();
               String strSelect = "select * from account_info," + b + "_account where account_info.account_id = " + b
                     + "_account." + b + "_id and account_info.account_id = " + a;
               ;
               ResultSet rset = s10.executeQuery(strSelect);
   
               if (!rset.next()) {
                  // nothing get
               }
   
               else {
                  do {
                     String type = rset.getString("type");
                     String a_id = rset.getString("account_id");
                     String running_balance_12 = rset.getString("running_balance");
                     String interest_rate = rset.getString("interest_rate");
                     System.out.printf("%-10s  -  %-13s  -  %10s ", "type", "account_id", "running_balance",
                           "interest_rate");
                     System.out.println();
                     System.out.printf("%-10s  -  %-13s  -  %10s\n ", type, a_id, running_balance_12, interest_rate);
                  } while (rset.next());
   
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }



            condition_new = true;
         }
         else{
            System.out.println("OVERDRAW, enter a lower number");
            condition_new = false;
         }

         System.out.println();
         System.out.println();
         System.out.println();
   
        
      } else if (choice == 2) {
         condition_new = false;
      } else {
         System.out.println("GOODBYE");
         condition_new = true;
      }
   } while (condition_new == false);
   System.out.println();
   System.out.println();
   System.out.println("WITHDRAW SUCCEED!!!");

   System.out.println("SERVICE END");

   
}
   /*
    * public static void opt2(){
    * 
    * }
    * 
    * public static void opt3(){
    * 
    * }
    */
   public static void money_dopsite(ArrayList<String[]> s, Statement s9, Statement s10, Connection con) {
      System.out.println("Here is you account record List again, Which account you want to deposit?");
      for (int i = 0; i < s.size(); i++) {
         System.out.println("Account_id: " + s.get(i)[0] + ";  Account_type: " + s.get(i)[1]);
         System.out.println();
      }

      Boolean condition = false;

      // int cc = 0;
      do {
         System.out.println();
         System.out.println("Please enter accountID you want to deposit");
         Scanner new_s = new Scanner(System.in);
         String entered_bid = new_s.nextLine();

         for (int i = 0; i < s.size(); i++) {
            // System.out.println(s.get(i)[0]);
            if (entered_bid.equals(s.get(i)[0])) {
               // System.out.println("Matched");
               condition = true;
               add_to_balance(s.get(i)[0], s.get(i)[1], s9, s10, con);
            }
         }
         if (condition == false) {
            System.out.println("ERROR, re-enter");
         }

      } while (condition == false);

   }

   public static void add_to_balance(String a, String b, Statement s9, Statement s10, Connection con) {
      System.out.println("<<<<<<<>>>>>>>");
      System.out.println(" INFORMATION");
      System.out.println("<<<<<<<>>>>>>>");

      try {

         String strSelect = "select * from account_info," + b + "_account where account_info.account_id = " + b
               + "_account." + b + "_id and account_info.account_id = " + a;
         ResultSet rset = s9.executeQuery(strSelect);

         if (!rset.next()) {
            // nothing get
         }

         else {
            do {
               String type = rset.getString("type");
               String a_id = rset.getString("account_id");
               String running_balance = rset.getString("running_balance");
               String interest_rate = rset.getString("interest_rate");
               System.out.printf("%-10s  -  %-13s  -  %10s ", "type", "account_id", "running_balance", "interest_rate");
               System.out.println();
               System.out.printf("%-10s  -  %-13s  -  %10s\n ", type, a_id, running_balance, interest_rate);
            } while (rset.next());

         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      Boolean condition_new = false;
      do {
         System.out.println("How much money you want to add to this " + b + " account?");
         Scanner scrn = new Scanner(System.in);
         int add_money = scrn.nextInt();
         System.out.println();
         System.out.println("So, the amount you want to add is: " + add_money + "?");
         System.out.println("Press 1 to continue, press 2 to re-enter, press anyother key to exit");

         Scanner scrn_1 = new Scanner(System.in);
         int choice = scrn_1.nextInt();
         if (choice == 1) {
            System.out.println("DEPOSIT COMMAND COMFIRED, STARTING");
            System.out.println();
            System.out.println("SUCCEED!!! here is the updated info about this account");

            try {
               System.out.println();
               String sql = "update " + b + "_account SET running_balance = running_balance + " + add_money + "where "
                     + b + "_id = " + a;
               s10.executeUpdate(sql);
               System.out.println();
               System.out.println("SERVICE END");
               // try {
               // con.commit();
               // } catch (Exception e) {
               // System.out.println("commit fail");
               // }
            } catch (SQLException e) {
               e.printStackTrace();
            }

            try {

               String strSelect = "select * from account_info," + b + "_account where account_info.account_id = " + b
                     + "_account." + b + "_id and account_info.account_id = " + a;
               ;
               ResultSet rset = s10.executeQuery(strSelect);

               if (!rset.next()) {
                  // nothing get
               }

               else {
                  do {
                     String type = rset.getString("type");
                     String a_id = rset.getString("account_id");
                     String running_balance = rset.getString("running_balance");
                     String interest_rate = rset.getString("interest_rate");
                     System.out.printf("%-10s  -  %-13s  -  %10s ", "type", "account_id", "running_balance",
                           "interest_rate");
                     System.out.println();
                     System.out.printf("%-10s  -  %-13s  -  %10s\n ", type, a_id, running_balance, interest_rate);
                  } while (rset.next());

               }
            } catch (SQLException e) {
               e.printStackTrace();
            }

            condition_new = true;
         } else if (choice == 2) {
            condition_new = false;
         } else {
            System.out.println("GOODBYE");
            condition_new = true;
         }
      } while (condition_new == false);

      System.out.println("SERVICE END");
      // mainCaller();

   }

}