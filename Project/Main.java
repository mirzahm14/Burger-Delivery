import java.util.*;

public class Main{
    public static void main(String[] args)
    {
        BurgerQueen burger= new BurgerQueen();                       // create object of PizzaHut class
        Scanner sc= new Scanner(System.in);
        int choice=0;

        // add all the available pizzas to menu
        burger.accept_menu("Cheese Whopper",30000, 50000, 70000, 15);
        burger.accept_menu("BBQ Beef Rasher", 40000, 55000, 82500, 22);
        burger.accept_menu("BBQ Beef Rasher Supreme", 45000, 70000, 90000, 22);
        burger.accept_menu("Mozzarella Beef Burger", 30000, 45000, 60000, 15);
        burger.accept_menu("Chicken Royal Burger", 35000, 50000, 65000, 22);
        burger.accept_menu("Double Cheese Burger", 30000, 50000, 70000, 12);
        burger.accept_menu("Tropical Whopper", 30000, 40000, 57000, 18);
        burger.accept_menu("BBQ Angus Burger", 50000, 70000, 90000, 25);
        burger.accept_menu("Cheese Lava Angus Burger", 45000, 65000, 80000, 25);
        burger.accept_menu("Cheese Lava Angus Burger", 45000, 55000, 65000, 25);

        // add registered customers
        burger.accept_customer("Mirza", "Jalan Paledang",1, "6281283309013");
        burger.accept_customer("Esha", "401, KB Society, Baner",3, "7517362175");
        burger.accept_customer("Prerana", "22, Greenland County, Deccan Gymkhana",5, "8345267906");
        
        int main_choice_mismatch=0;
        do
        {
            burger.clearScreen();
            main_choice_mismatch=0;
            try
            {
                System.out.print("\n\t\t\t\t\tWhat would you like to do? \n\t\t\t\t\t1. Place an order\n\t\t\t\t\t2. View menu card\n\t\t\t\t\t3. Exit\n\t\t\t\t");
                choice= sc.nextInt();
            }
            catch(InputMismatchException e)  // catch invalid input
            {
                sc.next();
                System.out.print("\n\t\t\t\tIncorrect choice! Please enter again!");
                main_choice_mismatch=1;
            }

            switch(choice)
            {
                case 1: burger.clearScreen();
                        burger.take_order();
                        break;
                case 2: burger.clearScreen();
                        burger.display_menu();
                        System.out.print("\n\n\t\t\t\t\t(Enter 0 to return to main menu) ");
                        sc.nextInt();
                        break;
                case 3: break;
                default: System.out.println("\n\t\t\t\t\tInvalid choice! Please enter again.");
            }
        }while(main_choice_mismatch==1 || choice!=3);

    }
}