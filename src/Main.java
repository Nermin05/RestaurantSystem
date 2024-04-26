import business.concretes.MenuManagement;
import business.concretes.OrderManager;
import business.concretes.ReservManager;
import entities.Meal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuManagement menuManagement=new MenuManagement();
        ReservManager reservManager=new ReservManager();
        OrderManager orderManager=new OrderManager();
    while (true) {
            System.out.println("1)Manage Menu \n2)Handle Reservations \n3)Process Orders\n4)Exit\nChoose your option:");
            int secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    System.out.println("1)Add menu\n2)Update menu\n3)Remove menu\nChoose Your option:");
                    int secim2 = scanner.nextInt();
                    switch (secim2) {
                        case 1:
                           menuManagement.add();
                           break;
                        case 2:
                            menuManagement.update();
                            break;
                        case 3:
                            menuManagement.delete();
                            break;
                        default:
                            System.out.println("Something get wrong");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1)Add reserv\n2)Remove reserv\nChoose Your option:");
                    int secim3 = scanner.nextInt();
                    switch (secim3) {
                        case 1:
                            reservManager.addReserv();
                            break;
                        case 2:
                            reservManager.deleteReserv();
                            break;
                        default:
                            System.out.println("Something get wrong");
                            break;
                    }
                    break;
                    case 3:
                        System.out.println("1)Add order\n2)Remove order\nChoose Your option:");
                        int secim4 = scanner.nextInt();
                        switch (secim4) {
                            case 1:
                                orderManager.add();
                                break;
                            case 2:
                                orderManager.delete();
                                break;
                            default:
                                System.out.println("Something get wrong");
                                break;
                        }
                        break;

                default:
                    System.exit(0);
            }
        }
    }
}