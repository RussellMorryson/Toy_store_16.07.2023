import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void showToys(List <Toy> toys) {        
        if (toys.size() == 0) {
            System.out.println("\nИгрушки закончились!\n");
        } else {
            System.out.println("Игрушки, доступные для розыгрыша: ");
            for (Toy toy : toys) { System.out.println(toy.toString()); }
        }
    }

    public static void writingToFile(String text) {        
        try(FileWriter fw = new FileWriter("Notes.txt", true)) {
            fw.write("Розыграна игрушка: " + text + ".\n");    
            fw.close();
        } catch (IOException e) { System.out.println(e.getMessage()); }        
    }

    public static void clearFile() {        
        try(FileWriter fw = new FileWriter("Notes.txt", false)) {
            fw.write("");    
            fw.close();
        } catch (IOException e) { System.out.println(e.getMessage()); }        
    }

    public static void menu(List <Toy> toys) {
        clearFile();
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();        
        int choice = -1;
        String name = "";
        int weight = 0;
        
        while (true) {
            System.out.println("###############################################");
            System.out.println("# https://github.com/RussellMorryson          #");
            System.out.println("# Программа для розыгрыша игрушек             #");
            System.out.println("# =========================================== #");
            System.out.println("# |                 Меню                    | #");
            System.out.println("# =========================================== #");
            System.out.println("# [1]  - Вывести список игрушек               #");
            System.out.println("# [2]  - Добавить новую игрушку               #");
            System.out.println("# [3]  - Разыграть игрушку                    #");
            System.out.println("# [0]  - Выход                                #");
            System.out.println("###############################################");
            System.out.println("# Введите команду: ");
            
            choice = scanner.nextInt();           
            
            if (choice == 1) {
                showToys(toys);
                System.out.println("\nНажмите любую клавишу и Enter для выхода в главное меню: ");    
                choice = scanner.nextInt();
                choice =-1;
            } else if (choice == 2) {
                System.out.print("Добавление новой игрушки.\nВведите название игрушки: ");
                name = scanner.next();

                System.out.print("Введите 'вес' (вероятность выпадения) игрушки: ");
                weight = scanner.nextInt();
                
                Toy newToy = new Toy(name, weight);
                name = "";
                weight = 0;
                toys.add(newToy);
                System.out.println("\nИгрушка " + newToy.getName() + " добавлена! \nОперация выполнена!");
                System.out.println("\nНажмите любую клавишу и Enter для выхода в главное меню: ");
                choice = scanner.nextInt();
                choice =-1;
            } else if (choice == 3) {
                if (toys.size() == 0) {
                    showToys(toys);
                    System.out.println("\nНажмите любую клавишу и Enter для выхода в главное меню: ");
                    choice = scanner.nextInt();
                    choice =-1;
                } else {
                    List<Integer> firstDischargeArray = new ArrayList<>();
                    List<Integer> randArray = new ArrayList<>();
                    List<Integer> raffleArray = new ArrayList<>();
                
                    for (Toy toy : toys) {
                        for(int i =0; i < toy.getWeight(); i++) {
                            firstDischargeArray.add(toy.getID());
                        }
                    }                
                    int indexId = 0;
                    int count = 0;
                    for(int i = 0; i < firstDischargeArray.size(); i++) {                    
                        while(true) {
                            indexId = 0;
                            count = 0;
                            indexId = rand.nextInt(firstDischargeArray.size());
                            if (randArray.size() == 0) {
                                randArray.add(indexId);
                            } else {                        
                                for(int j =0; j < randArray.size(); j++) {
                                    if (randArray.get(j) == indexId) {
                                        count++;
                                    }
                                }
                            }
                            if (count == 0) {
                                randArray.add(indexId);
                                break;
                            }
                            }   
                        raffleArray.add(firstDischargeArray.get(indexId));
                    }
                    indexId = rand.nextInt(raffleArray.size());
                    for(Toy toy : toys) {
                        if (toy.getID() == raffleArray.get(indexId)) {
                            System.out.println("Вы выиграли: " + toy.getName());
                            writingToFile(toy.getName());
                            toys.remove(toy);
                            System.out.println("Находятся в розыгрыше: ");
                            showToys(toys);
                            break;
                        }
                    }
                    System.out.println("\nНажмите любую клавишу и Enter для выхода в главное меню: ");
                    choice = scanner.nextInt();
                    choice =-1;
                }                
            } else {
                System.out.println("\nКоманда введена некорректно!\nПовторите попытку!\n");
            }            
        }        
    }

    public static void main(String[] args) {

        Toy toy1 = new Toy("Bear",4);
        Toy toy2 = new Toy("Rabbit", 2);
        Toy toy3 = new Toy("Car", 3);
        Toy toy4 = new Toy("Duck", 3);

        List <Toy> toys = new ArrayList<Toy>();
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);

        menu(toys);
    }      
}