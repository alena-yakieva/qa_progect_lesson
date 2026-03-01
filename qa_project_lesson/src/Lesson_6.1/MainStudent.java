import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainStudent {
    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("Анна Иванова", "ИТ-101", 1, Arrays.asList(4, 5, 4, 3)));
        students.add(new Student("Пётр Сидоров", "ИТ-102", 1, Arrays.asList(2, 2, 3, 2)));
        students.add(new Student("Мария Петрова", "ИТ-201", 2, Arrays.asList(5, 4, 5, 5)));
        students.add(new Student("Иван Козлов", "ИТ-202", 2, Arrays.asList(3, 3, 2, 3)));
        students.add(new Student("Елена Волкова", "ИТ-301", 3, Arrays.asList(2, 1, 2, 1)));


        students.forEach(System.out::println);


        StudentManager.printStudents(students, 1);

        System.out.println(" УДАЛЕНИЕ СТУДЕНТОВ СО СРЕДНИМ БАЛЛОМ < 3 ");
        StudentManager.removeLowPerformers(students);
        students.forEach(System.out::println);

        System.out.println("\n ПЕРЕВОД НА СЛЕДУЮЩИЙ КУРС ");
        StudentManager.promoteStudents(students);
        students.forEach(System.out::println);


        StudentManager.printStudents(students, 2);
        StudentManager.printStudents(students, 3);
        StudentManager.printStudents(students, 4);
    }
}

