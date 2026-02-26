public abstract class Animal {
    String name;
    static int count = 0;

    public abstract void run(int length);
    public abstract void swim(int length);

        public Animal(String name) {
            this.name = name;
            count++;
        }
        public static int getCount() {
            return count;
        }
}
class Dog extends Animal {
    private static int countDogs = 0;
    private final int MAX_RUN = 500;
    private final int MAX_SWIM = 10;

    public Dog(String name) {
        super(name);
        countDogs++;
    }
    @Override
    public void run(int length) {
        if (length <= MAX_RUN) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не может пробежать " + length + " м.");
        }
    }
    @Override
    public void swim(int length) {
        if (length <= MAX_SWIM) {
            System.out.println(name + " проплыл " + length + " м.");
        } else {
            System.out.println(name + " не может проплыть " + length + " м.");
        }
    }
    public static int getCountDogs() {
        return countDogs;
    }
}
class Cat extends Animal {
    private static int countCats = 0;
    private final int MAX_RUN = 200;
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
        countCats++;
    }

    @Override
    public void run(int length) {
        if (length <= MAX_RUN) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не может пробежать " + length + " м.");
        }
    }
    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать!");
    }

    public boolean eat(Bowl bowl,int amount) {
        if (bowl.takeFood(amount)) {
            satiety = true;
            System.out.println(name + " поел и теперь сыт.");
            return true;
        } else {
            System.out.println(name + " не смог поесть - недостаточно еды в миске.");
            return false;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
    public static int getCountCats() {
        return countCats;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public boolean takeFood(int amount) {
        if (amount <= foodAmount && amount > 0) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println(" В миску добавлено " + amount + " единиц еды. Теперь в миске " + foodAmount);
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

    class Main {
        public static void main(String[] args) {

            Dog dogBobik = new Dog("Бобик");
            Dog dogSharik = new Dog("Шарик");
            Cat catMurzik = new Cat("Мурзик");
            Cat catBarsik = new Cat("Барсик");


            dogBobik.run(150);  // Бобик пробежал 150 м.
            dogBobik.swim(5);     // Бобик проплыл 5 м.
            catMurzik.run(250);   // Мурзик не может пробежать 250 м. (максимум 200 м.)
            catBarsik.swim(1);   // Барсик не умеет плавать!

            System.out.println("Всего животных создано: " + Animal.getCount());
            System.out.println("Собак создано: " + Dog.getCountDogs());
            System.out.println("Котов создано: " + Cat.getCountCats());

            System.out.println("\n--- Кормление котов ---");
            Bowl bowl = new Bowl(15);

            Cat[] cats = {catMurzik, catBarsik};

            for (Cat cat : cats) {
                cat.eat(bowl, 10);
            }


            bowl.addFood(10);

            for (Cat cat : cats) {
                if (!cat.isSatiety()) {
                    cat.eat(bowl, 10);
                }
            }

            // Вывод информации о сытости
            System.out.println("\n--- Состояние котов ---");
            for (Cat cat : cats) {
                System.out.println(cat.name + " сыт: " + cat.isSatiety());
            }

            System.out.println("Осталось еды в миске: " + bowl.getFoodAmount());
        }
    }

