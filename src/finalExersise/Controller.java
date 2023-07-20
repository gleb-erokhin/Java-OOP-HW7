package finalExersise;

final.exersise;

// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.
public class Controller {
    public static void main(String[] args) {
        ICalculableFactory calculableFactory = new CalculableFactory();
        ViewCalculator view = new ViewCalculator(calculableFactory);

        view.start();
    }
}
