import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Order {

    //implementing arraylists to store the id of the customer and the car

    public ArrayList<String> us_id = new ArrayList<String>();
    public ArrayList<String> cs_id = new ArrayList<String>();
    Sales S = new Sales();
    
    //Method for placing an order having two parameters, the customer id and the id of the car

    public void placeorder(String a, String b) {
        
        us_id.add(a);
        cs_id.add(b);


        try {
            File file = new File("Order.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pn = new PrintWriter(bw);

            pn.println(us_id + "," + cs_id);
            pn.close();
        } catch (IOException ia) {
            System.out.println("Exception occurred:");
            ia.printStackTrace();
        }

        System.out.println("\t\tThe order has been succesfully placed!\n\n");
        System.out.println("\t\tPress enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        try {
            S.Salesroom();
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }

    //Method to view all orders for admin and employee

    public void ViewOrders() throws FileNotFoundException {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner input = new Scanner(new File("Order.txt"));
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
    }

    //Method for finding specific customer orders

    public void viewSpecificOrder(String s) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("The Details of the Product You Have Booked is:");
        System.out.println("----------------------------------------------");
        System.out.println("Car ID\t\tName\t\tCompany\t\tMileage\t\tPrice\t\tdate of manf.");

        try {
            File fview=new File("Order.txt");
            Scanner scan= new Scanner(fview);
            while (scan.hasNextLine()) {
                String d= scan.nextLine();
                String[] el = d.split(",");
                String rp = el[0].replace("[","");
                String rp1 = rp.replace("]","");
               if(rp1.compareTo(s)==0)
               {    
                   String rp2 = el[1].replace("[","");
                   String rp3 = rp2.replace("]","");
                   String temp_cid = rp3;
    
                try {
                    File fview1=new File("car.txt");
                    Scanner scan1= new Scanner(fview1);
                    while (scan1.hasNextLine()) {
                        String d1= scan1.nextLine();
                        String[] el1 = d1.split(",");
                        
                        if(el1[0].compareTo(temp_cid)==0)
                        {
                            
                            System.out.println(el1[0]+"\t\t"+el1[1]+"\t\t"+el1[2]+"\t\t"+el1[3]+"\t\t"+el1[4]+"\t\t"+el1[5]);
                        }
                        
                        
                    }
                    scan1.close();
        
                }
                 catch (FileNotFoundException e) {
                     System.out.println("Exception");
                    
                }
               }
                
            }
            scan.close();

        }
         catch (FileNotFoundException e) {
             System.out.println("Exception");
            
        }
        
    }
}
