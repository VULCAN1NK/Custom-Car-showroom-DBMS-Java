import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class product {
    Scanner in = new Scanner(System.in);

    //Method to display product information

    public void viewproduct() throws FileNotFoundException {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("");
         
        car ca = new car();
        ca.display_Car();
        }
    
    //Method to book a product

    public void BookProduct() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Order O = new Order();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the car u wish to order");
        String wid = sc.nextLine();
        int ct=0;
        try {
            File f=new File("car.txt");
            Scanner s= new Scanner(f);
            while (s.hasNextLine()) {
                String d= s.nextLine();
                String[] dt = d.split(",");
                
                if(dt[0].compareTo(wid)==0)
                {   ct=1;
                    System.out.println("Enter your email id and password to continue");
                    System.out.print("User ID: ");
                    String uid = sc.nextLine();
                    int ct1=0, ct2=0;
                    try {
                        File f1=new File("customerlogindetails.txt");
                        Scanner s1= new Scanner(f1);
                        while (s1.hasNextLine()) {
                            String d1= s1.nextLine();
                            String[] dt1= d1.split(",");
                            if(dt1[0].compareTo(uid)==0)
                            {
                                ct1=1;
                                System.out.print("Password : ");
                                String upas = sc.nextLine();
                                if(upas.compareTo(dt1[1])==0)
                                {   
                                    ct2=1;
                                    O.placeorder(uid,wid);
                                }
                                
                          }
                            
                        }
                            if(ct1==0);
                            {
                                System.out.println("user id doesn't exist");
                                BookProduct();
                            }
                            if(ct2==0);
                            {
                                System.out.println("invalid password");
                                BookProduct();
                            }

                              s1.close();
                            }
                              catch(IOException ia){
                                     System.out.println("Exception occurred:");
                                     ia.printStackTrace();
                                }

                }
                
                
                  }
                  if(ct==0)
                {
                    System.out.println("id does not exist!");

                    try {
                        TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                        e.printStackTrace();
                        }

                    BookProduct();


                }
                  s.close();
                }
                  catch(IOException ia){
                         System.out.println("Exception occurred:");
                         ia.printStackTrace();
                    }
          
       /* System.out.println("If u need to go back press '0' or need to go to Login page press 1 ");
            int Back = in.nextInt();
            if (Back == 0) {
                try {
                    sale.Salesroom();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (Back == 1) {
                login A = new login();
                try {
                    A.log();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/

            sc.close();
    }
    
}