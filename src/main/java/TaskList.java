import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


public class TaskList implements Iterable<Task> {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    @SuppressWarnings("unchecked")
    public TaskList() {

        addTask(new Task("Rive blade sammen", "Riv sammen og put i poser til bladkamp",
                LocalDate.of(2026, 2, 28)));
        addTask(new Task("Klargøre bede", "Vend jorden, fjern ukrudt",
                LocalDate.of(2026, 3, 15)));
        addTask(new Task("Beskære", "Skære døde grene af buskene overalt og gem til afbrænding",
                LocalDate.of(2026, 4, 24)));
        addTask(new GardenTask("Grave fælder", "Til når svigerfamilien kommer på besøg",
                LocalDate.of(2026, 2, 1), "Bedet bag skuret"));
        addTask(new GardenTask("Trampolin", "Sætte trampolin op igen",
                LocalDate.of(2026, 2, 19), "Baghave"));
        addTask(new GardenTask("Grave huller", "Vi skal have en skyttegrav i baghaven",
                LocalDate.of(2026, 2, 17), "Hjørne bag terrasse"));
        addTask(new Task("Installere katapult", "Vendes mod øst, mod bagboen",
                LocalDate.of(2026, 4, 25)));
        addTask(new Task("Bunker", "Find ud af, hvor i haven bunkeren skal bygges",
                LocalDate.of(2026, 2, 1)));
        addTask(new Task("Klippe hæk", "Hele vejen rundt om verdens længste hæk",
                LocalDate.of(2025, 6, 20)));
        addTask(new Task("Slå græsset", "Alle 2500 kvm",
                LocalDate.of(2025, 6, 30)));
        addTask(new GardenTask("Køb havetraktor", "Det bliver så sidste gang med en håndskubber",
                LocalDate.of(2025, 7, 1), "Bauhaus"));
    }

        //Kører alle tasks - der er kun brug for en liste
    public List<Task> taskByDueDate() {
        return (List<Task>) tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
    }


    public List<Task> tasksDueToday(LocalDate date) {
        return tasks.stream()
                .filter(task -> task.getDueDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Task> overdueTasks(LocalDate date) {
        LocalDate today = LocalDate.now();
        return tasks.stream()
                .filter(task -> task.getDueDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }


    String keyWord = "vi";
   public List<Task> filterOnKeyWord() {
        return tasks.stream()
                .filter(task ->
                        task.getDescription().toLowerCase()
                                .contains(keyWord))
                .toList();
    }


    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }
}



    /*

The class must be generic and accept any Task or subtype of Task. The class must also implement the Iterable interface to allow iterating over the tasks.
     */

