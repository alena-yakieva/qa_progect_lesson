class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ExceptionArr {
    public static void main(String[] args) {
        // Корректный массив
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "0", "1", "2"},
                {"3", "4", "5", "6"}
        };

        // Массив с ошибкой данных
        String[][] dataErrorArray = {
                {"1", "2", "3", "4"},
                {"5", "X", "7", "8"},
                {"9", "0", "1", "2"},
                {"3", "4", "5", "6"}
        };

        // Массив с неправильным размером
        String[][] sizeErrorArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}
        };

        // Тест корректного массива
        try {
            int result = processArray(correctArray);
            System.out.println("Результат для корректного массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест массива с ошибкой данных
        try {
            int result = processArray(dataErrorArray);
            System.out.println("Результат: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест массива неправильного размера
        try {
            int result = processArray(sizeErrorArray);
            System.out.println("Результат: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Демонстрация генерации и поимки ArrayIndexOutOfBoundsException
        try {
            System.out.println(correctArray[5][5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nПоймано ArrayIndexOutOfBoundsException: " + e.toString());
        }
    }

    public static int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4 (строки). Текущий размер: " + arr.length + "x" + (arr.length > 0 ? arr[0].length : 0));
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                throw new MyArraySizeException("Строка " + i + " массива равна null");
            }
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4x4 (столбцы). Ошибка в строке " + i + ". Текущий размер строки: " + arr[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + arr[i][j]);
                }
            }
        }
        return sum;
    }
}
