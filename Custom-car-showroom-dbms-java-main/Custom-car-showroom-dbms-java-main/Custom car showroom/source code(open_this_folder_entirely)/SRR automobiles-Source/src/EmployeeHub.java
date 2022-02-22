import java.util.*;

public class EmployeeHub extends product {

    public void Employeeroom() throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner in = new Scanner(System.in);
        System.out.println("------------");
        System.out.println("EMPLOYEE ROOM");
        System.out.println("-------------\n");
        System.out.println("Welcome to employee Lounge, choose to proceed \n");
        System.out.println("1)View orders\n2)View Products\n0)Quit\n");

        int B = in.nextInt();

        if (B == 2) 
        {
           viewproduct();
            System.out.println("If u need to go back press '0' and to login press 1 ");
            int Back = in.nextInt();

            if (Back == 0) 
            {
                Employeeroom();
            }

            if (Back == 1) 
            {
                login L = new login();
                L.log();
            }

        }


        if (B == 1) 
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            

            Order oo = new Order();
            oo.ViewOrders();

            System.out.println("If u need to go back press '0' and 1 to Login ");
            int Back = in.nextInt();

            if (Back == 0) 
            {
                Employeeroom();
            }

            if (Back == 1) 
            {
                login L = new login();
                L.log();
            }
        }

        if (B == 0)
        {
         login L = new login();
                L.log();  
        }

       in.close();
    }
}

