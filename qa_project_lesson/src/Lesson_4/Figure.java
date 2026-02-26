import java.util.ArrayList;
import java.util.List;

public interface Figure {
    String getFillColor();
    String getBorderColor();
    double getPerimeter();

    default double getArea() {
        return 0.0;
    }
    default void printInfo() {
        System.out.printf(" Периметр: %.2f, Площадь: %.2f, Цвет заливки: %s, Цвет границы: %s%n",
                getPerimeter(), getArea(), getFillColor(), getBorderColor());
    }

    class Circle implements Figure {
        private final double radius;
        private final String fillColor;
        private final String borderColor;

        public Circle(double radius, String fillColor, String borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }
        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
        @Override
        public String getFillColor() {
            return fillColor;
        }
        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    class Rectangle implements Figure {
        private final double width;
        private final double height;
        private final String fillColor;
        private final String borderColor;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }
        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }
        @Override
        public double getArea() {
            return width * height;
        }
        @Override
        public String getFillColor() {
            return fillColor;
        }
        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    class Triangle implements Figure {
        private final double sideA;
        private final double sideB;
        private final double sideC;
        private final String fillColor;
        private final String borderColor;

        public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
            if (!isValidTriangle(sideA, sideB, sideC)) {
                throw new IllegalArgumentException("Треугольник с такими сторонами не существует!");
            }
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor =fillColor;
            this.borderColor = borderColor;
        }
        private boolean isValidTriangle(double a, double b, double c) {
            return (a + b > c) && (a + c > b) && (b + c > a);
        }
        @Override
        public double getPerimeter() {
            return sideA + sideB + sideC;
        }
        @Override
        public double getArea() {
            double p = getPerimeter() / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }
        @Override
        public String getFillColor() {
            return fillColor;
        }
        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    public class Main {
        public static void main(String[] args) {
            List<Figure> figureList = new ArrayList<>();

            figureList.add(new Circle(5.5, "Желтый", "Синий"));
            figureList.add(new Rectangle(3.0, 8.0, "Красный", "Черный"));
            figureList.add(new Triangle(3.0, 4.0, 5.0, "Белый", "Зеленый"));


            for (Figure figure : figureList) {
                figure.printInfo();
            }
        }
    }
}

