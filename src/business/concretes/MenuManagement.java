package business.concretes;

import business.abstracts.MenuService;
import entities.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuManagement implements MenuService {
    Scanner scanner=new Scanner(System.in);
    List<Meal> foods=new ArrayList<>();
    @Override
    public void add() {
        boolean contunie = true;
        while (contunie) {
            Meal meal = new Meal();
            System.out.print("Enter meal name: ");
            String name = scanner.nextLine();
            meal.setName(name);
            System.out.print("Enter meal price: ");
            double price = 0;
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price > 0) {
                    meal.setPrice(price);
                } else {
                    System.out.println("Please enter a correct price!");
                    continue;
                }
                System.out.print("Enter meal category: ");
                String category = scanner.nextLine();
                meal.setCategory(category);
                foods.add(meal);
                System.out.println("Added meal: " + meal.getName() + " " + meal.getPrice() + " " + meal.getCategory());
                System.out.println("All meals:");
                for (Meal food : foods) {
                    System.out.println(food.getName() + " " + food.getPrice() + " " + food.getCategory());
                }
                System.out.println("New item -> 1\nBack to menu -> 0\nYour option:");
                int reqem = Integer.parseInt(scanner.nextLine());
                if (reqem == 0) {
                    contunie = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for price. Please enter a valid number.");
            }
        }
    }
    @Override
    public void update() {
            System.out.println("Current Menu Items:");
            for (int i = 0; i <foods.size(); i++) {
                System.out.println("ID: " + (i+1) + ")" + foods.get(i).getName());
            }
            System.out.print("Update item ID:");
            int itemId = Integer.parseInt(scanner.nextLine());
        int id = itemId - 1;
        if (id < 0 || id >=foods.size()) {
            System.out.println("Please enter correct ID.");
            return;
        }
            Meal select = foods.get(id);
            System.out.println("Selected Item: " + select.getName());
            System.out.println("Choose a field to update:");
            System.out.println("1. Name");
            System.out.println("2. Price");
            System.out.println("3. Category");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    select.setName(newName);
                    break;
                case 2:
                    System.out.print("Enter the new price: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    select.setPrice(newPrice);
                    break;
                case 3:
                    System.out.print("Enter the new category: ");
                    String newCategory = scanner.nextLine();
                    select.setCategory(newCategory);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        System.out.println("Your new menu: "+select.getName()+" "+select.getPrice()+" "+select.getCategory());
        System.out.println("Your updating is successfully!");

        }

    @Override
    public void delete() {
            if (foods.isEmpty()) {
                System.out.println("No menu item in there");
                return;
            }
            System.out.println("Current Menu Items:");
            for (int i = 0; i < foods.size(); i++) {
                System.out.println("ID: " + (i + 1) + ")" + foods.get(i).getName());
            }
            System.out.print("Delete menu ID:");
            int itemId = Integer.parseInt(scanner.nextLine());
            int id = itemId - 1;
            if (id < 0 || id >= foods.size()) {
                System.out.println("Wrong ID");
                return;
            }
            Meal select = foods.get(id);
            System.out.println("Are you sure you want to delete item?");
            System.out.println("Item: " + select.getName());
            System.out.print("YES\nNO\nAnswer:");
            String sure = scanner.nextLine();
            if (sure.equals("YES")) {
                foods.remove(id);
                System.out.println("Deleting successfully.");
            } else if (sure.equals("NO")) {
                System.out.println("Deletion cancelled.");
            } else {
                System.out.println("Something get wrong.");
            }
        }

    }


