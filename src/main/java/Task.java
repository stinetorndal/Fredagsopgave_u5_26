import java.time.LocalDate;

public class Task {
    private String title;       //Opgavens titel
    private String description; //Opgavens beskrivelse
    private LocalDate dueDate;  //Deadline for opgaven


    public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

        @Override
        public String toString() {
            return """
                   Titel: %s
                   Beskrivelse: %s
                   Deadline: %s
                   """.formatted(title, description, dueDate)
                    ;
    }
}
