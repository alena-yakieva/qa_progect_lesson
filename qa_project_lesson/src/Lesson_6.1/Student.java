import java.util.ArrayList;
import java.util.List;

public class Student {
private String name;
private String group;
private int course;
private List<Integer> grades;

public Student(String name, String group, int course, List<Integer> grades) {
    this.name = name;
    this.group = group;
    this.course = course;
    this.grades = new ArrayList<>(grades);
}

public String getName() {
    return name;
}

public String getGroup() {
    return group;
}

public int getCourse() {
    return course;
}

public void setCourse(int course) {
    this.course = course;
}

public List<Integer> getGrades() {
    return new ArrayList<>(grades);
}

public double getAverageGrade() {
    if (grades.isEmpty()) {
        return 0.0;
    }
    return grades.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
}

@Override
public String toString() {
    return String.format("Студент: %s, Группа: %s, Курс: %d, Оценки: %s, Средний балл: %.2f",
            name, group, course, grades, getAverageGrade());
}
}


