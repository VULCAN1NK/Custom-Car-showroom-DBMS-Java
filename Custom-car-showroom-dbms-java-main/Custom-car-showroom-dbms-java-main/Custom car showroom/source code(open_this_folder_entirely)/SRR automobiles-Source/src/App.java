public class App {
    public static void main(String[] args) throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("##################################");
        System.out.println("----------------------------------");
        System.out.println("   WELCOME TO SRR AUTOMOBILES     ");
        System.out.println("----------------------------------");
        System.out.println("##################################");

        System.out.println("\n\n");

        System.out.println("Press Enter key to contine...");
        System.in.read();


        login lg = new login();
        lg.log();
    }
}

