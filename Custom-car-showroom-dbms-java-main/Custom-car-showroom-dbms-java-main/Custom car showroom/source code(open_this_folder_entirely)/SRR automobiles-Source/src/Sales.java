import java.util.*;

public class Sales extends product {

   //Salesroom introdus customer screen

    public void Salesroom() throws Exception {
        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner in = new Scanner(System.in);

        System.out.println("---------------------------------------\n");
        System.out.println("WELCOME TO CUSTOMER LOUNGE");
        System.out.println("---------------------------------------\n");
        System.out.println("Enter your Choice");
        System.out.println("\n1)View Products\n2)Book a product\n3)View Order\n0)Quit\n ");
        System.out.print("Choice: ");
        int B = in.nextInt();
        
        if (B == 1) {

            //calls into the employye function to reroute to product information(implementation of inter-class navigation)

            Employee emp=new Employee();
            emp.dispcars();

            System.out.println("If u need to go back press '0' and to login press 1 ");
            int Back = in.nextInt();
            if (Back == 0) {
                Sales S = new Sales();
                S.Salesroom();
            }
            if (Back == 1) {
                login L = new login();
                L.log();
            }
        }
        if (B == 2) {
            BookProduct();
            System.out.println("If u need to go back press '0' and 1 to Login ");
            int Back = in.nextInt();
            if (Back == 0) {
                Sales S = new Sales();
                S.Salesroom();
            }
            if (Back == 1) {
                login L = new login();
                L.log();
            }
        }
        if (B == 0) {
            login L = new login();
            L.log();
        }
        if (B == 3) {
            Customer cs = new Customer();
            cs.viewsorder();
            
            System.out.println("If u need to go back press '0' and 1 to Login ");
            int Back = in.nextInt();
            if (Back == 0) {
                Sales S = new Sales();
                S.Salesroom();
            }
            if (Back == 1) {
                login L = new login();
                L.log();
            }
        }
        in.close();
        
    }
}