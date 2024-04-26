package business.concretes;

import business.abstracts.ReservService;
import entities.Meal;
import entities.Person;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservManager implements ReservService {
    Scanner scanner=new Scanner(System.in);
    List<Person> reservation=new ArrayList<>();
    @Override
    public void addReserv() {
        boolean contunie = true;
        while (contunie) {
            Person person = new Person();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            person.setName(name);
            System.out.print("Enter date: ");
            String date= scanner.nextLine();
            person.setDate(date);
            System.out.println("Enter time: ");
            String time= scanner.nextLine();
            person.setTime(time);
            if (date.contains(".") && time.contains(":")) {
                reservation.add(person);
                System.out.println("All meals:");
                for (Person reserv : reservation) {
                    System.out.println(reserv.getName() + " " + reserv.getDate() + " " + reserv.getTime());
                }
                System.out.println("New reservation -> 1\nBack to menu -> 0\nYour option:");
                int number = Integer.parseInt(scanner.nextLine());
                if (number == 0) {
                    contunie = false;
                }
            }
            else {
                System.out.println("Date or Time formatting are wrong");
            }
        }

    }

    @Override
    public void deleteReserv() {
        if (reservation.isEmpty()) {
            System.out.println("No any reservation in there");
            return;
        }
        System.out.println("Current reservations:");
        for (int i = 0; i < reservation.size(); i++) {
            System.out.println("ID: " + (i + 1) + ")" + reservation.get(i).getName());
        }
        System.out.print("Delete reserv ID:");
        int reservId = Integer.parseInt(scanner.nextLine());
        int id = reservId - 1;
        if (id < 0 || id >= reservation.size()) {
            System.out.println("Wrong ID");
            return;
        }
        Person select = reservation.get(id);
        System.out.println("Are you sure you want to delete item?");
        System.out.println("Item: " + select.getName());
        System.out.print("YES\nNO\nAnswer:");
        String sure = scanner.nextLine();
        if (sure.equals("YES")) {
            reservation.remove(id);
            System.out.println("Deleting successfully.");
        } else if (sure.equals("NO")) {
            System.out.println("Deletion cancelled.");
        } else {
            System.out.println("Something get wrong.");
        }
    }

    }

