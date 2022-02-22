import java.io.FileNotFoundException;
import java.util.*;

interface ad_log {
    void Adminlog();
}

interface ad_room {
    void adminroom();
}

public class Admin implements ad_log , ad_room {
    private String adminid;
    private String adminpass;
    Scanner in = new Scanner(System.in);
    Admin() {
        adminid= "admin";
        adminpass= "admin";
    }
    public void Adminlog()
    {   
        System.out.print("\033[H\033[2J");
        System.out.flush();

        int c = 1 ;
        do{
        System.out.print("Enter ID:       ");
        String id = in.nextLine();
        System.out.print("Enter Password: ");
        String pass = in.nextLine();
        if (id.compareTo(adminid) == 0 && pass.compareTo(adminpass) == 0)
        {
            c = 0;
            
            try {
                adminroom();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    while (c != 0);
    }
    public void adminroom() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        product pd = new product();
        Employee E = new Employee();
        Customer C = new Customer();
        
        System.out.println("------------------------------------");
        System.out.println("WELCOME TO THE ADMINISTRATIVE LOUNGE");
        System.out.println("------------------------------------");
        
        System.out.println("Enter your choice: ");
        System.out.println("--------------------\n");
            
        System.out.println("1.View Product\n2.Add Product\n3.View Employee\n4.Add Employee\n5.Add customer details\n6.View customer details\n7.View Orders\n8.Go to login page\n");
        System.out.print("choice: ");
        int B = in.nextInt();

        if (B == 1) {
            try {
                pd.viewproduct();
            } catch (FileNotFoundException e) {
                
                e.printStackTrace();
            }
            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("If u need to go back press '0' or need to go to Login page press 1 ");
            int Back = in.nextInt();
            if (Back == 0) {
                Admin A = new Admin();
                A.adminroom();
            }
            if (Back == 1) {
                login A = new login();
                try {
                    A.log();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        }
        if (B == 2) {
            car Car = new car();
            try {
                Car.getcdetails();
            } catch (Exception e) {
                
                e.printStackTrace();
            }

            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("\n");

            System.out.println("If u need to go back press '0' or need to go to Login page press 1 ");
            int Back = in.nextInt();
            if (Back == 0) {
                Admin A = new Admin();
                A.adminroom();
            }
            if (Back == 1) {
                login A = new login();
                try {
                    A.log();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        }
        if (B == 3) {
            try {
                E.Viewemployee();
            } catch (Exception e) {
                
                e.printStackTrace();
            }

            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("\n");

            System.out.println("If u need to go back press '0' or need to go to Login page press 1 ");
            int Back = in.nextInt();
            if (Back == 0) {
                Admin A = new Admin();
                A.adminroom();
            }
            if (Back == 1) {
                login A = new login();
                try {
                    A.log();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        }
        if (B == 4) {
            try {
                
                E.getEmployeedetails();
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
        if (B == 5) {
            try {
                C.getcustomerdetails();
            } catch (Exception e) {
                
                e.printStackTrace();
            }

            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("\n");

            System.out.println("If u need to go back press '0' or need to go to Login page press 1 ");
            int Back = in.nextInt();
            if (Back == 0) {
                Admin A = new Admin();
                A.adminroom();
            }
            if (Back == 1) {
                login A = new login();
                try {
                    A.log();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        }
        if (B == 6) {
            C.cus_dets();

            System.out.println("-------------------------------------------------------------------------------------------------------");
            System.out.println("\n");

            System.out.println("If u need to go back press '0' or need to go to Login page press 1 ");
            int Back = in.nextInt();
            if (Back == 0) {
                Admin A = new Admin();
                A.adminroom();
            }
            if (Back == 1) {
                login A = new login();
                try {
                    A.log();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        }
        if(B==7)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            

            Order oo = new Order();
            try {
                oo.ViewOrders();
            } catch (FileNotFoundException e) {
                
                e.printStackTrace();
            }

            System.out.println("If u need to go back press '0' and 1 to Login ");
            int Back = in.nextInt();

            if (Back == 0) 
            {
                adminroom();
            }

            if (Back == 1) 
            {
                login L = new login();
                try {
                    L.log();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }

        }
        if (B == 8) {
            login A = new login();
            try {
                A.log();
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
    in.close();
    }
    
     
}

