import java.time.LocalDate;
import java.time.Month;

public class Main {
    static void main() {

       TaskList <Task> taskList =TaskList.testData();

        System.out.println("Alle opgaver: ");
        taskList.taskByDueDate()
                .forEach(System.out::println);


        System.out.println("Opgaver den 1. februar");
        System.out.println("--------------------------------");
        taskList.tasksDueToday(LocalDate.of(2026, 2, 1))
                .forEach(System.out::println);

        System.out.println("--------------------------------");
        System.out.println("Opgaver før i dag: ");
        taskList.overdueTasks()
                .forEach(System.out::println);

        System.out.println("--------------------------------");
        System.out.println("Keyword: " + taskList.keyWord);
        taskList.filterOnKeyWord()
                .forEach(System.out::println);

        System.out.println("--------------------------------");
        System.out.println("Opgaver i marts: " );
        taskList.tasksInMonth(Month.MARCH)
                .forEach(System.out::println);

 /*       System.out.println("-------------------------------");
        System.out.println("Sorteret på dato - den besværlige måde: ");
        taskList.taskByDueDate()
                .forEach(task -> {
                    System.out.println("Deadline: " + task.getDueDate());
                    System.out.println("Opgave: " + task.getTitle());
                    System.out.println("Beskrivelse: " + task.getDescription());
                    System.out.println("--__--__--__--__--__--__");
                });
*/
    }
}

/*filter  on a keyword
sort by duedate
get task due today
overdue tasks
print list
 */

