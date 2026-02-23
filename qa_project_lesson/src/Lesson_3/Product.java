import java.time.LocalDate;
import java.util.Arrays;

public class Product {
    // Поля класса
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean reservationStatus;

    public Product(String name, LocalDate productionDate, String manufacturer,
                    String countryOfOrigin, double price, boolean reservationStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }


    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Production Date: " + productionDate);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Country of Origin: " + countryOfOrigin);
        System.out.println("Price: " + price + " руб.");
        System.out.println("Reservation Status: " + reservationStatus);
        System.out.println();
    }

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                LocalDate.of(20025,02,02),
                "Samsung Corp.",
                "Korea",
                5599,
                true);

        productsArray[1] = new Product(
                "Samsung Galaxy S25 Ultra",
                LocalDate.of(2024,03,01),
                "Samsung Electronics",
                "Korea",
                89999,
                true);

        productsArray[2] = new Product(
                "Apple iPhone 16 Pro",
                LocalDate.of(2024,04,01),
                "Apple Inc.",
                "США (сборка — Китай)",
                120000,
                true);

        productsArray[3] = new Product(
                "Xiaomi 14T Pro",
                LocalDate.of(2025,05,01),
                "Xiaomi Corporation",
                "Китай",
                65000,
                true);

        productsArray[4] = new Product(
                "Google Pixel 9 Pro",
                LocalDate.of(2024,10,01),
                "Google LLC",
                "Вьетнам",
                79990,
                false);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
        }
    }
}

