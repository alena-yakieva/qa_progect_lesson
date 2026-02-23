import java.util.ArrayList;
import java.util.List;

public class Park {

    private String parkName;
    private List<Attraction> attractions;

    public class Attraction {
        public String name;
        public String workingHours;
        public double cost;

        Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost + " руб.");
            System.out.println();
        }

    }

    Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    void addAttraction(String name, String workingHours, double cost) {
        Attraction attraction = new Attraction(name, workingHours, cost);
        attractions.add(attraction);
    }

    void displayAllAttractions() {
        System.out.println("Парк: " + parkName);

        for (Attraction attraction : attractions) {
            attraction.printInfo();
        }
    }
    List<Attraction> getAttractions() {
        return attractions;
    }


    public static void main(String[] args) {

        Park cityPark = new Park("Городской парк развлечений");

        cityPark.addAttraction("Колесо обозрения", "10:00–20:00", 300.00);
        cityPark.addAttraction("Карусель", "09:00–19:00", 150.00);
        cityPark.addAttraction("Американские горки", "11:00–21:00", 400.00);

        List<Park.Attraction> parkAttractions = cityPark.getAttractions();

        for (Park.Attraction attraction : parkAttractions) {
            System.out.println("Аттракцион: " + attraction.name);
            System.out.println("Время работы: " + attraction.workingHours);
            System.out.println("Стоимость: " + attraction.cost + " руб.");
            System.out.println();
        }
    }
}


