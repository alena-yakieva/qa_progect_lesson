import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private final Map<String, List<String>> telephoneDirectory = new HashMap<>();

    public void add(String surname, String phone) {
        List<String> phones = telephoneDirectory.computeIfAbsent(surname, k -> new ArrayList<>());
        phones.add(phone);
    }

    public List<String> get(String surname) {
        List<String> phones = telephoneDirectory.get(surname);
        if (phones == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(phones);
    }
}
