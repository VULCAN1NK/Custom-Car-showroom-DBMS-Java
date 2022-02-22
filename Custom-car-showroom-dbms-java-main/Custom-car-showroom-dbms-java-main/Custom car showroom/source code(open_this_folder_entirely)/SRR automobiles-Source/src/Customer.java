import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Customer implements Serializable {
    Scanner in = new Scanner(System.in);
    public String Name;
    public String Address;
    public String Email;
    public String Password;
    public Long PhoneNum;

    Customer(String Name, String Address ,String Email,String Password, Long PhoneNum)
    {
        this.Name= Name;
        this.Address=Address;
        this.Email=Email;
        this.Password=Password;
        this.PhoneNum=PhoneNum;
    }

    public Customer() {
        Name= " ";
        Address=" ";
        Email=" ";
        Password="  ";
        PhoneNum = (long) 0;
    }

    public String toString()
    {
        return Name+","+Address+","+Email+","+Password+"," + PhoneNum;
    }

    public void customerlog()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Welcome to Customer portal");
        System.out.println("1.Sign up(new customer)\n2.Sign in(existing customer)");
        System.out.print("choice: ");
        int chc = in.nextInt();
        switch (chc) {
            case 1: Customer Cu = new Customer();
                try {
                    Cu.getcustomerdetails();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                break;
            
            case 2: Customer cs = new Customer();
                    cs.excustomer();
            
                break;
        
            default:
                System.out.println("error in choice..choose again");

                try{
                    TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

                customerlog();
                break;
        }
    }

    public void getcustomerdetails() throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();


        Scanner sc = new Scanner(System.in);
        System.out.println("Input the necessory details > \n");
        System.out.print("Name > ");
        String New_Customer_Name = sc.next();

        System.out.print("Address > ");
        String New_Customer_Address = sc.next();

        System.out.print("Email > ");
        String New_Customer_Email = sc.next();
        if (!New_Customer_Email.endsWith(".com")) {
            System.out.println("Invalid Email Provided");
            getcustomerdetails();
        }

            System.out.print("Password > ");
            String New_Customer_Password = sc.next();

            System.out.print("Phone number  > ");
            Long New_Customer_Number = sc.nextLong();
            if(String.valueOf(New_Customer_Number).length()!=10){
                System.out.println("Phone Number should be 10 numbers long.");
                getcustomerdetails();
            }

            try {
                File file = new File("customer.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pn = new PrintWriter(bw);

                pn.println(New_Customer_Name + "," + New_Customer_Address + "," + New_Customer_Email + ","
                        + New_Customer_Password + "," + New_Customer_Number);
                pn.close();
            } catch (IOException ia) {
                System.out.println("Exception occurred:");
                ia.printStackTrace();
            }

            try {
                File file = new File("customerlogindetails.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pn = new PrintWriter(bw);

                pn.println(New_Customer_Email + "," + New_Customer_Password);
                pn.close();
            } catch (IOException ia) {
                System.out.println("Exception occurred:");
                ia.printStackTrace();
            }
            System.out.println("Account created Succesfully");

            try{
                TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }


                Sales A = new Sales();
                try {
                    A.Salesroom();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
            sc.close();
    }

public void cus_dets() 
{    
    System.out.print("\033[H\033[2J");
    System.out.flush();  
    
    System.out.println("Name\t\tAddress\t\tEmail\t\tPassword\t\tPhoneNum");
    try {
        File f = new File("customer.txt");
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String d = s.nextLine();
            String[] dt = d.split(",");
            
            System.out.println(dt[0]+"\t\t"+dt[1]+"\t\t"+dt[2]+"\t\t"+dt[3]+"\t\t"+dt[4]);

        }
        s.close();

    } catch (FileNotFoundException e) {
        System.out.println("bleh");

    }
}

public void Addlogindetails() {
    try {
        File f = new File("customerlogindetails.txt");
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String d = s.nextLine();
            String[] dt = d.split(",");
            System.out.println("Email\t\tPassword");
            System.out.println(dt[0] + "\t\t" + dt[1]);

        }
        s.close();

    } catch (FileNotFoundException e) {
        System.out.println("bleh");

    }
}



public void excustomer() {

   System.out.print("\033[H\033[2J");
   System.out.flush();

    int c1=0;
    try {
        File f = new File("customerlogindetails.txt");
        Scanner s = new Scanner(f);
        System.out.println("Enter Email > ");
        String old_Mail = in.next();

        while (s.hasNextLine()) {
            String d = s.nextLine();
            String[] dt = d.split(",");

            if (dt[0].compareTo(old_Mail) == 0) {
                c1=1;
                int c2=0;
                System.out.println("Enter Password > ");
                String old_Password = in.next();
                if (old_Password.compareTo(dt[1]) == 0) {
                    c2=1;
                    Sales sa = new Sales();
                    try {
                        sa.Salesroom();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
                if(c2==0)
                {
                  System.out.println("Password doesn't match!");
                  try{
                    TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
            customerlog();
                }
            }
        }
        s.close();

    } catch (FileNotFoundException e) {
        System.out.println("bleh");

    }
    if(c1==0)
    {
        System.out.println("id does not exist!");

        try{
            TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
    e.printStackTrace();
   }
   customerlog();

  }
}

public void viewsorder() {

    System.out.print("\033[H\033[2J");
    System.out.flush();

    System.out.println("Enter your id(email): ");
    String s_id =in.nextLine();
    Order O1 = new Order();
    try {
        File f = new File("customerlogindetails.txt");
        Scanner s = new Scanner(f);

        while (s.hasNextLine()) {
            String d = s.nextLine();
            String[] dt = d.split(",");
            if (dt[0].compareTo(s_id)==0) {
                O1.viewSpecificOrder(s_id);
            }

        }

        s.close();

    } catch (FileNotFoundException e) {
        System.out.println("Exeption");

    }
}
}
