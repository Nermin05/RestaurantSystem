package business.concretes;

import business.abstracts.OrderService;
import entities.Meal;
import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager implements OrderService {
    Scanner scanner=new Scanner(System.in);
    List<Meal> orders=new ArrayList<>();
    @Override
    public void add() {
        boolean contunie = true;
        while (contunie) {
            Person person = new Person();
            Meal meal = new Meal();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            person.setName(name);
            System.out.print("Enter meal name: ");
            String mealName = scanner.nextLine();
            meal.setName(mealName);
            System.out.print("Enter meal price: ");
            double price = 0;
            price = Double.parseDouble(scanner.nextLine());
            if (price > 0) {
                meal.setPrice(price);
            } else {
                System.out.println("Please enter a correct price!");
                continue;
            }
            orders.add(meal);
            int total=0;
            System.out.println("All meals:");
            for (Meal order : orders) {
                System.out.println(person.getName() + " " + order.getName());
                total +=price;

            }
            System.out.println("And your total price:");
            System.out.println(total);
            System.out.println("New reservation -> 1\nBack to menu -> 0\nYour option:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                contunie = false;
            } else {
                System.out.println("Date or Time formatting are wrong");
            }
        }
    }

            @Override
            public void delete () {
                if (orders.isEmpty()) {
                    System.out.println("No order in there");
                    return;
                }
                System.out.println("Current order:");
                for (int i = 0; i < orders.size(); i++) {
                    System.out.println("ID: " + (i + 1) + ")" + orders.get(i).getName());
                }
                System.out.print("Delete order ID:");
                int orderId = Integer.parseInt(scanner.nextLine());
                int id = orderId - 1;
                if (id < 0 || id >= orders.size()) {
                    System.out.println("Wrong ID");
                    return;
                }
                Meal select = orders.get(id);
                System.out.println("Are you sure you want to delete order?");
                System.out.println("Order: " + select.getName());
                System.out.print("YES\nNO\nAnswer:");
                String sure = scanner.nextLine();
                if (sure.equals("YES")) {
                    orders.remove(id);
                    System.out.println("Deleting successfully.");
                } else if (sure.equals("NO")) {
                    System.out.println("Deletion cancelled.");
                } else {
                    System.out.println("Something get wrong.");
                }
            }


        }

