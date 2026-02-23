import java.time.LocalDate;

public class Product1 {
    // Поля класса
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean reservationStatus;

    public Product1(String name, LocalDate productionDate, String manufacturer,
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
            Product1 smartphone = new Product1(
                    "Smartphone XYZ",
                    LocalDate.of(2024, 5, 15),
                    "TechCorp",
                    "China",
                    29999.99,
                    true);
        smartphone.printInfo();
    }
    }



