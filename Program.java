import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    static void showToys(List <Toy> toys) {
        if (toys.size() == 0) {
            System.out.println("\nИгрушки закончились!\n");
        } else {
            System.out.println("\nСписок игрушек: \n");
            for (Toy toy : toys) {
                System.out.println(toy.toString());
            }
        }
    }

    static void menu(List <Toy> toys) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        String name = "";
        int weight = 0;

        while (true) {
            System.out.println("\nhttps://github.com/RussellMorryson\n");
            System.out.println("======================================");
            System.out.println("|                 Меню               |");
            System.out.println("======================================");
            System.out.println("1 / add - Добавить новую игрушку");
            System.out.println("2 / show - Вывести список оставшихся игрушек");
            System.out.println("3 / raffle - Разыграть игрушку");
            System.out.println("0 / exit - Выход\n");
            System.out.println("Введите команду: ");
            choice = scanner.nextLine();
            System.out.println("***************************************");
            if (choice == "1" || choice.toLowerCase() == "add") {
                System.out.print("Операция: Добавить игрушку.\nВведите название игрушки: ");
                    name = scanner.nextLine();
                System.out.print("Введите 'вес' (вероятность выпадения) игрушки: ");
                    weight = scanner.nextInt();
                Toy newToy = new Toy(name, weight);
                    name = "";
                    weight = 0;
                    toys.add(newToy);
                System.out.println("\nИгрушка " + newToy.getName() + " добавлена! \nОперация выполнена!\n");
                
            } else if (choice == "2" || choice.toLowerCase() == "show") {                
                showToys(toys);
                System.out.println("\nОперация выполнена!\n");   
            } else if (choice == "3" || choice.toLowerCase() == "raffle") {                
                List <Integer> raffleArray = new ArrayList<>();
                for(Toy toy : toys) {
                    for(int i = 0; i < toy.getWeight(); i++) {
                        raffleArray.add(toy.getWeight());
                    }
                }
            }
        }
    }     

    public static void main(String[] args) {
        Toy toy1 = new Toy("Bear",4);
        Toy toy2 = new Toy("Rabbit", 2);
        Toy toy3 = new Toy("Car", 3);
        Toy toy4 = new Toy("Duck", 3);

/*
        PriorityQueue <Toy> queueToys = new PriorityQueue<>();
        queueToys.add(toy1);
        queueToys.add(toy2);
        queueToys.add(toy3);
        queueToys.add(toy4);
        for(Toy t : queueToys) {
            System.out.println(t.getWeight());
        }*/
        List <Toy> toys = new ArrayList<>();
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);

        System.out.println("Игрушки, доступные для розыгрыша: ");
        showToys(toys);
        menu(toys);
    }
}