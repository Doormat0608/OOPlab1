import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите операцию: \n");
        System.out.print("Введите 1 для поиска предложений, длина которых больше порога:\n");
        System.out.print("Введите 2 для поиска предложений, длина которых меньше порога:\n");
        int initialChoice = TryParseInt();

        // ввод текста
        System.out.print("Введите текст: ");
        String text = in.nextLine();

        // создаём экземпляр класса
        SentenceFilter sentenceFilter = null;
        String operationMessage = "";
        if (initialChoice == 1) {
            sentenceFilter = new SentenceFilterLonger(text); // Вариант 1
            operationMessage = "Поиск предложений длиной больше порога";
        } else if (initialChoice == 2) {
            sentenceFilter = new SentenceFilterShorter(text); // Вариант 2
            operationMessage = "Поиск предложений длиной меньше порога";
        }

        // выбор операции
        if (sentenceFilter != null) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1 - " + operationMessage);
            System.out.println("2 - Поиск самого длинного предложения");
            int secondChoice = TryParseInt();

            if (secondChoice == 1) {
                // ввод порога, фильтрация
                System.out.print("Введите порог: ");
                int threshold = TryParseInt();
                sentenceFilter.filterByLength(threshold);
            } else if (secondChoice == 2) {
                // поиск самого длинного предложения
                SentenceFinderLongest finder = new SentenceFinderLongest(text);
                finder.findLongestSentence();
            }
        }
    }

    // метод для безопасного преобразования строки в целое число
    public static Integer TryParseInt() {
        try {
            Scanner _in = new Scanner(System.in);
            String value = _in.nextLine();
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}