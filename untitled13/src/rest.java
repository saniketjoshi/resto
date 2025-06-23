import java.util.Scanner;
class EKattaRestaurant
{
    static int[] stock = {0, 5, 5, 5, 5, 5, 5, 5, 5};
    public static int getPrice(int choice)
    {
        switch (choice)
        {
            case 1: return 80;
            case 2: return 120;
            case 3: return 60;
            case 4: return 70;
            case 5: return 70;
            case 6: return 80;
            case 7: return 100;
            case 8: return 150;
            case 0: return 0;
            default: return -1;
        }
    }
    public static String getItemName(int choice)
    {
        switch (choice)
        {
            case 1: return "Pizza";
            case 2: return "Pav bhaji";
            case 3: return "Fries";
            case 4: return "Sandwich";
            case 5: return "Cheese Fries";
            case 6: return "Cheese Sandwich";
            case 7: return "Cheese Pizza";
            case 8: return "Cheese pav bhaji";
            default: return "Invalid item";
        }
    }
    public static void refillStock(int choice)
    {
        stock[choice] = 5;
        System.out.println(getItemName(choice) + " stock refilled.");
    }
    public static boolean processOrder(int choice)
    {
        if (choice == 0)
        {
            return false;
        }
        if (stock[choice] == 0)
        {
            refillStock(choice);
        }
        if (stock[choice] > 0)
        {
            stock[choice]--;
            return true;
        }
        return false;
    }
    public static void displayMenu()
    {
        System.out.println("\nSelect the food item:");
        System.out.println("1 - Pizza (80rs)");
        System.out.println("2 - Pav bhaji (120rs)");
        System.out.println("3 - Fries (60rs)");
        System.out.println("4 - Sandwich (70rs)");
        System.out.println("5 - Cheese Fries (70rs)");
        System.out.println("6 - Cheese Sandwich (80rs)");
        System.out.println("7 - Cheese Pizza (100rs)");
        System.out.println("8 - Cheese pav bhaji (150rs)");
        System.out.println("Enter 0 to skip.");
    }
    public static void displayStock()
    {
        System.out.println("\nRemaining stock:");
        for (int i = 1; i <= 8; i++)
        {
            System.out.println(getItemName(i) + ": " + stock[i]);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To E-katta Restaurant!");
        while (true)
        {
            System.out.print("\nDo you want to order anything? (yes/no): ");
            String answer = sc.next().trim().toLowerCase();
            if (!answer.equals("yes"))
            {
                System.out.println("Thank you! Visit again.");
                break;
            }
            displayMenu();
            System.out.print("How many items do you want to order? ");
            int numItems = sc.nextInt();
            if (numItems <= 0)
            {
                System.out.println("You must order at least one item.");
                continue;
            }
            int total = 0;
            System.out.println("Your order:");
            for (int i = 1; i <= numItems; i++)
            {
                System.out.print("Enter choice for item " + i + ": ");
                int choice = sc.nextInt();
                int price = getPrice(choice);
                if(price == -1)
                {
                    System.out.println("Invalid choice for item " + i + ". Skipping.");
                    continue;
                }
                if (price > 0 && processOrder(choice))
                {
                    System.out.println("- " + getItemName(choice) + " (" + price + "rs)");
                    total += price;
                }
            }
            System.out.println("Total bill: " + total + "rs");
            displayStock();
        }
        sc.close();
    }
}