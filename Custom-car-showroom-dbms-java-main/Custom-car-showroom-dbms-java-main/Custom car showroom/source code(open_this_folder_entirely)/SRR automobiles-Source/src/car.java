import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class car implements Serializable{

    String cName;
    String cCompany;
    float cMileage;
    double cPrice;
    String dom;
    String cid;

    car(String cid, String N, String Cm, float Mi, double Pr, String dom)
    {
        cName = N;
        cCompany = Cm;
        cMileage = Mi;
        cPrice = Pr;
        this.dom = dom;
        this.cid = cid; ;
    }

    public car() 
    {
        cName = "No name";
        cCompany = "No Company";
        cMileage = 00;
        cPrice = 00.0;
        dom = "nodate0000";
        cid = "0000"; 

    }

//overriding the toString function manually
@Override
    public String toString()
    {
        return cid +","+cName+","+cCompany+","+cMileage+","+cPrice+","+dom;
    }


    public void getcdetails() throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Car ID:                  ");
        String cid=sc.nextLine();
        if(String.valueOf(cid).length()!=4)
        {
            System.out.println("Wrong car id format");
            getcdetails();
        }
        System.out.println(""); 

        System.out.print("Enter the name of the car:     ");
        String cName=sc.nextLine();
        System.out.println("");

        System.out.print("Enter the company of the car:   ");
        String cCompany=sc.nextLine();
        System.out.println("");

        System.out.print("Enter the mileage of the car: ");
        Float cMileage=sc.nextFloat();
        System.out.println("");

        System.out.print("Enter the price of the car:   ");
        Double cPrice=sc.nextDouble();
        System.out.println("");

        System.out.print("Enter the date of manufacturing of the car: ");
        String dom=sc.next();
        System.out.println("");


       try{
        File file =new File("car.txt");
        if(!file.exists()){
           file.createNewFile();
        }
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pn = new PrintWriter(bw);
      
        pn.println(cid +","+cName+","+cCompany+","+cMileage+","+cPrice+","+dom );
        pn.close();
  }
  catch(IOException ia){
         System.out.println("Exception occurred:");
         ia.printStackTrace();
    }
    System.out.println("\n");
    System.out.println("The new Car has been Succesfully Added");

    try {
        TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }



    Admin adm = new Admin();
    adm.adminroom();

    sc.close();
}

   //Method to display all car details
    public void display_Car(){
        System.out.println("Car ID\t\tName\t\tCompany\t\tMileage\t\tPrice\t\tdom ");
        try {
            File f=new File("car.txt");
            Scanner s= new Scanner(f);
            while (s.hasNextLine()) {
                String d= s.nextLine();
                String[] dt = d.split(",");
                
                System.out.println(dt[0]+"\t\t"+dt[1]+"\t\t"+dt[2]+"\t\t"+dt[3]+"\t\t"+dt[4]+"\t\t"+dt[5]);
                
            }
            s.close();

        }
         catch (FileNotFoundException e) {
             System.out.println("Exception has occured");
            
        }
    }


    }

    

    

