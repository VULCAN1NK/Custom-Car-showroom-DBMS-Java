import java.io.IOException;
import java.util.concurrent.TimeUnit;

abstract class creditC{
    abstract void credit_count();
}
public class credit extends creditC {

    @Override
    void credit_count() {
        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\n");

        System.out.println("                       SRR AUTOMOBILES                            ");
        System.out.println("\n");

        try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("\n");

        try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
       
         System.out.println("This Project has Been done by: \n");

         try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

         System.out.println("Adithya Krishna     -   AM.EN.U4AIE21005");

         try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

         System.out.println("Adithya S Nair      -   AM.EN.U4AIE21006"); 

         try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

         System.out.println("Anoop B Manuel      -   AM.EN.U4AIE21015");

         try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

         System.out.println("Athul Gireesh       -   AM.EN.U4AIE21020");

         try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

         System.out.println("Navneeth Krishna    -   AM.EN.U4AIE21047\n\n");

         try {
            TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

        System.out.println("-------------------------------------------------------------------\n\n");

        try {
            TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\n\n\t\tTHANK YOU FOR USING SRR AUTOMOBILES, VISIT AGAIN!\n\n");
            System.out.println("\t\tPress enter key to continue...");
            try {
                System.in.read();
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            login log=new login();
            try {
                log.log();
            } catch (Exception e) {
                
                e.printStackTrace();
            }
       }

    
}
