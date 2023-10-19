import java.util.*;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public class RestaurantApp 
{
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> carts = new ArrayList<>();
    static ArrayList<Order> confirmedOrders = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int userOption1, userOption2 = 0, quantity, order;
        
        products.add(new Product(1, 100, "C1"));
        products.add(new Product(2, 150, "C2"));
        products.add(new Product(3, 100, "C3"));
        products.add(new Product(4, 35, "R1"));
        products.add(new Product(5, 50, "R2"));

        do
        {
            displayMenu();
            System.out.print("\nSelect Order: ");
            order = scan.nextInt();
            Product p1 = products.get(order - 1);
            System.out.printf("%s (Quantity): ", p1.getName());
            quantity = scan.nextInt();
            carts.add(p1);
            p1.setQuantity(quantity);

            Product.displayAllCart();

            System.out.println("\n1) Add more Order \n2) Confirm Order \n3) Delete Orders");
            System.out.print("Select an option: ");
            userOption1 = scan.nextInt();

            switch (userOption1)
            {
                case 1:
                continue;
                
                case 2: 

                    for (Product cart: carts)
                        confirmedOrders.add(new Order(cart.quantity, cart.name, cart.price, cart.price * cart.quantity));
                    carts.clear();

                    Order.displayAllOrders();
                    
                    System.out.println("\nDo you want to order again?");
                    System.out.println("1) Yes \n2) No");
                    System.out.print("Select an option: ");
                    userOption2 = scan.nextInt();
                    confirmedOrders.clear();
                    break;

                case 3:
                    carts.clear();
                    Product.displayAllCart();
                    break;
            }

        }while(userOption2 != 2);

        scan.close();
         
    }

    static void displayMenu()
    {
        System.out.println("\n===============MENU===============\n");
        int i = 0;
        for (Product product: products)
        {
            i++;
            product.displayProduct();
            if (i == 3)
            System.out.println("\n==============ADD=ONS==============\n"); 
        }
        System.out.println("\n===================================");

    }


}

class Product
{
    int id, quantity;
    double price;
    String name;

    Product(int id, double price, String name)
    {
        this.price = price;
        this.name = name;
        this.id = id;
    }


    void displayProduct()
    {
        System.out.printf("\t%d. %s - Php %.2f\n", id, name, price);
    }

    void displayCart()
    {
        System.out.printf("Order: %s - Php %.2f Quantity: %d\n", name, price, quantity);
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    static void displayAllCart()
    {
        System.out.println("\n===============CART================\n");

        if (RestaurantApp.carts.isEmpty())
        {
            System.out.println("\t   Cart is Empty.");
            return;
        }

        for (Product cart: RestaurantApp.carts)
            cart.displayCart();

        System.out.println("Total Amount: Php " + calculateTotal());
        System.out.printf("Total Amount to dollars: $%.2f\n", calculateTotal() / 56.80);
        System.out.println("\n===================================");
    }

    static double calculateTotal()
    {
        double total = 0;
        for (Product cart: RestaurantApp.carts)
        {
            total += cart.quantity * cart.price;
        }

        return total;
    }

}

class Order
{
    int quantity;
    String name;
    static String date;
    double total, price;
    LocalDateTime myDateObj = LocalDateTime.now(); 
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);  

   
    Order(int quantity, String name, double price, double total)
    {
        this.name = name;
        this.quantity = quantity;
        this.total = total;
        this.price = price;
        date = String.valueOf(formattedDate);
    }

    static void displayDate()
    {
        System.out.println(date);
    }

    void displayOrder()
    {
        System.out.printf("%s - Php %.2f Quantity: %d = %.2f\n", name, price, quantity, total);
    }

    static void displayAllOrders()
    {   
        if (RestaurantApp.confirmedOrders.isEmpty())
        {
            return;
        }

        System.out.println("\n===============ORDER===============\n");
        System.out.println("   You have successfully Ordered:\n");
        double total = 0;

        displayDate();

        for (Order confirmedOrder: RestaurantApp.confirmedOrders)
        {
            confirmedOrder.displayOrder();
            total += confirmedOrder.total;
        }

        System.out.println("Total Amount: Php " + total);
        System.out.printf("Total Amount to dollars: $ %.2f\n", total / 56.80);
        System.out.println("\n===================================");
    }
    
}
