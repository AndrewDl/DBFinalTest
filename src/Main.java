/**
 * Created by Andrew on 06/10/16.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Новий запис");
            System.out.println("2. Змінити оцінку");
            System.out.println("3. Видалити");
            System.out.println("4. Показати таблицю");
            System.out.println("5. Показати студентів за оцінкою");
            System.out.println("6. Вихід");
            System.out.println("Выберите номер действия, которое вы хотите выполнить:");
            int n = sc.nextInt();
            if (n == 1) {
                sc = new Scanner(System.in);
                System.out.println("Enter name to insert someone:");
                String name = sc.nextLine();
                if(DB_Students.DB_SELECT(name) == false) {
                    System.out.println("Enter his/her mark:");
                    double mark = sc.nextDouble();
                    DB_Students.DB_INSERT(name, mark);
                    System.out.println("Your insert is successful!");
                }
                else{
                    System.out.println("We have already had this student in the database.");
                }

            }
            if (n == 2) {
                sc = new Scanner(System.in);
                System.out.println("Enter the name of student:");
                String name = sc.nextLine();
                System.out.println("Enter new mark of student:");
                double mark = sc.nextDouble();
                DB_Students.DB_UPDATE(name, mark);
                System.out.println("Your update is successful!");
            }
            if (n == 3) {
                sc = new Scanner(System.in);
                System.out.println("Enter id to delete someone:");
                int id = sc.nextInt();
                DB_Students.DB_DELETE(id);
                System.out.println("Your delete is successful!");
            }
            if (n == 4) {
                DB_Students.DB_SELECT();
            }
            if (n == 5) {
                sc = new Scanner(System.in);
                System.out.println("Enter mark of student:");
                double mark = sc.nextDouble();
                DB_Students.DB_SELECT(mark);
            }
            if (n == 6) {
                return;
            }

        }
    }
}
