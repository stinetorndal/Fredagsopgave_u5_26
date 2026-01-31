import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class TaskList<T extends Task> implements Iterable<T> {
    private List<T> tasks = new ArrayList<>();

    public void addTask(T task) {
        tasks.add(task);
    }

    public static TaskList<Task> testData() {
        TaskList<Task> taskList = new TaskList<>();

        taskList.addTask(new Task("Rive blade sammen", "Riv sammen og put i poser til bladkamp",
                LocalDate.of(2026, 2, 28)));
        taskList.addTask(new Task("Klargøre bede", "Vend jorden, fjern ukrudt",
                LocalDate.of(2026, 3, 15)));
        taskList.addTask(new Task("Beskære", "Skære døde grene af buskene overalt og gem til afbrænding",
                LocalDate.of(2026, 4, 24)));
        taskList.addTask(new GardenTask("Grave fælder", "Til når svigerfamilien kommer på besøg",
                LocalDate.of(2026, 2, 1), "Bedet bag skuret"));
        taskList.addTask(new GardenTask("Trampolin", "Sætte trampolin op igen",
                LocalDate.of(2026, 2, 19), "Baghave"));
        taskList.addTask(new GardenTask("Grave huller", "Vi skal have en skyttegrav i baghaven",
                LocalDate.of(2026, 2, 17), "Hjørne bag terrasse"));
        taskList.addTask(new Task("Installere katapult", "Vendes mod øst, mod bagboen",
                LocalDate.of(2026, 4, 25)));
        taskList.addTask(new Task("Bunker", "Find ud af, hvor i haven bunkeren skal bygges",
                LocalDate.of(2026, 2, 1)));
        taskList.addTask(new Task("Klippe hæk", "Hele vejen rundt om verdens længste hæk",
                LocalDate.of(2025, 6, 20)));
        taskList.addTask(new Task("Slå græsset", "Alle 2500 kvm",
                LocalDate.of(2025, 6, 30)));
        taskList.addTask(new GardenTask("Køb havetraktor", "Det bliver så sidste gang med en håndskubber",
                LocalDate.of(2025, 7, 1), "Bauhaus"));
        return taskList;
    }

    //Kører alle tasks - der er kun brug for en liste
    public List<T> taskByDueDate() {
        return (List<T>) tasks.stream()
                .sorted(Comparator.comparing(T::getDueDate))
                .toList();
    }


    public List<T> tasksDueToday(LocalDate date) {
        return tasks.stream()
                .filter(task -> task.getDueDate().equals(date))
                .collect(toList());
    }

    public List<Task> overdueTasks() {
        LocalDate today = LocalDate.now();
        return tasks.stream()
                .filter(task -> task.getDueDate().isBefore(today))
                .collect(toList());
    }


    String keyWord = "klippe";
    public List<T> filterOnKeyWord() {
        return tasks.stream()
                .filter(task ->
                        task.getDescription().toLowerCase()
                                .contains(keyWord))
                .toList();
    }

        public List<T> tasksInMonth(Month month) { //Month fra java.time - ENUM
        return tasks.stream()
                .filter(task -> task.getDueDate()
                        .getMonth().equals(month))
                .toList();
    }

    @Override
    public Iterator<T> iterator() {
        return tasks.iterator();
    }
}





