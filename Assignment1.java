import java.util.Scanner;

public class Assignment1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PropertyTax home = new PropertyTax();
    System.out.print("Enter the actual value of the property: ");
    double propertyValue = scanner.nextDouble();
    System.out.println("Enter the type of property.");
    System.out.print("Type 'R' for residential, 'C' for commercial, 'F' for farmland: ");
    String propertyType = scanner.next();
    System.out.println("");

    home.setPropertyValue(propertyValue);
    home.setPropertyType(propertyType.charAt(0));
    System.out.println(home.toString());
    scanner.close();
  }
}
