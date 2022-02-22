import java.util.concurrent.TimeUnit;
import java.util.*;

public class login extends credit{
 
    //the main login function
    public void log() throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Choose one of the following and enter the respective numeral to continue\n");
        System.out.println("1.Admin");
        System.out.println("2.Employee");
        System.out.println("3.Customer");
        System.out.println("4.Credits");
        System.out.println("5.Exit");

        int cho;
        do {
            System.out.print("\nEnter your choice: ");
            cho = sc.nextInt();
            if (cho == 1) {
                Admin Ad = new Admin();
                Ad.Adminlog();
            } 
            else if (cho == 2) 
            {
                
                EmployeeHub eh = new EmployeeHub();
                eh.Employeeroom();
                    
                   
            } 
            else if (cho == 3) 
            {
                Customer csm = new Customer();
                csm.customerlog();
            } 
            else if(cho==4)
            {
                credit_count();
            }
            else if (cho == 5) 
            {
                System.out.println("You have chosen to terminate the program, adios!");

                try {
                TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                e.printStackTrace();
                }

                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.exit(0);

            } 
            else if (cho < 1 || cho > 5)
            {
                System.out.println("you chose wrong, choose again");
            }
        } while (cho < 1 || cho > 4);
        sc.close();
    }
}