import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Employee implements Serializable {
    String Name;
    String id ;
    String Email;
    Double salary;

    Employee(String Name, String id ,String Email, Double new_Employee_salary)
    {
        this.Name= Name;
        this.id=id;
        this.Email=Email;
        this.salary=new_Employee_salary;
    }

    public Employee() {
        Name=" ";
        id=" ";
        Email=" ";
        salary=0.0;

    }

    public String toString()
    {
        return Name+" , "+id+" , "+Email+" , " + salary;
    }

    public void getEmployeedetails() throws Exception
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the necessory details > ");
        System.out.print("Name > ");
        String New_Employee_Name = sc.nextLine();
        System.out.print("id > ");
        String New_Employee_id = sc.next();
        System.out.print("Email > ");
        String New_Employee_Email = sc.next();
        if (!New_Employee_Email.endsWith(".com")) {
            System.out.println("Invalid Email Provided");

            try{
                TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
           
           getEmployeedetails();
        }

        System.out.print("Salary  > ");
        Double New_Employee_salary = sc.nextDouble();
        
       try{
        File file =new File("Employee.txt");
        if(!file.exists()){
           file.createNewFile();
        }
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pn = new PrintWriter(bw);
      
        pn.println(New_Employee_Name+","+New_Employee_id+","+New_Employee_Email+","+New_Employee_salary );
        pn.close();
  }
  catch(IOException ia){
         System.out.println("Exception occurred:");
         ia.printStackTrace();
    }
    

    System.out.println("\nEmployee details have been succesfully added!");

   try{
        TimeUnit.SECONDS.sleep(1);
} catch (InterruptedException e) {
e.printStackTrace();
}

    Admin adi = new Admin();
    try {
        adi.adminroom();
        
    } catch (Exception e) {
        System.out.println("oh no...");
    }
    
    sc.close();
    
}


/*//Adds employee details 

    void Addemployee() throws Exception {
        Employee E = new Employee();
        E.getEmployeedetails();
    }*/



    // displays employee details


    public void Viewemployee() throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("Employee Name\t\t\tID\t\t\tEmail\t\t\tSalary");
        try {
            File f=new File("Employee.txt");
            Scanner s= new Scanner(f);
            while (s.hasNextLine()) {
                String d= s.nextLine();
                String[] dt = d.split(",");
                
                System.out.println(dt[0]+"\t\t"+dt[1]+"\t\t"+dt[2]+"\t\t"+dt[3]);
                
            }
            s.close();

        }
         catch (FileNotFoundException e) {
             System.out.println("bleh");
            
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Press Enter key to continue....");
        System.in.read();
        Admin an = new Admin();
        an.adminroom();
        sc.close();
    }

    public void dispcars() {
        product p1=new product();
            try {
                p1.viewproduct();
            } catch (Exception e) {

                e.printStackTrace();
            }
    }
   
}