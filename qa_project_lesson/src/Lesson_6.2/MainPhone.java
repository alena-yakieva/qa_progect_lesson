public class MainPhone {
    public static void main(String[] args) {
         TelephoneDirectory telephoneDirectory = new TelephoneDirectory();

         telephoneDirectory.add("Иванов", "8-999-123-456-78");
         telephoneDirectory.add("Петров", "8-999-123-456-89");
         telephoneDirectory.add("Петров", "8-999-123-456-98");
         telephoneDirectory.add("Сидоров", "8-999-123-456-87");
         telephoneDirectory.add("Иванов", "8-999-123-456-08");

         System.out.println("Иванов" + telephoneDirectory.get("Иванов"));
         System.out.println("Петров" + telephoneDirectory.get("Петров"));
         System.out.println("Сидоров" + telephoneDirectory.get("Сидоров"));
         System.out.println("Путин" + telephoneDirectory.get("Путин"));
    }
}
