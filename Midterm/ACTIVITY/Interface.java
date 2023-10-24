import java.util.*;

public class Interface
{
   public static void main (String[] args)
   {
      Scanner scan = new Scanner (System.in);
      Student student = new Student();
      System.out.print("Enter first name >> ");
      student.setFirstName(scan.nextLine());
      
      System.out.print("Enter middle name >> ");
      student.setMiddleName(scan.nextLine());
      
      System.out.print("Enter last name >> ");
      student.setLastName(scan.nextLine());
      
      System.out.print("Enter suffix name >> ");
      student.setSuffix(scan.nextLine());
      
      System.out.println("\nFirst name: " + student.getFirstName());
      System.out.println("Middle name: " + student.getMiddleName());
      System.out.println("Last name: " + student.getLastName());
      System.out.println("Suffix: " + student.getSuffix());
      System.out.println("Full name: " + student.getFullName());
   }
}