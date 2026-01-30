import java.time.LocalDate;

// Fordi ikke alle opgaver har en lokation

public class GardenTask extends Task{
    private String gardenLocation;  //Hvor i haven skal opgave udføres

    public GardenTask (String title, String description, LocalDate dueDate, String gardenLocation) {
        super(title, description, dueDate);
        this.gardenLocation = gardenLocation;
    }

    public String getGardenLocation() { return gardenLocation; }

    @Override
    public String toString() {
        // Kalder super.toString() og tilføjer lokation
        return super.toString() + "Lokation: " + gardenLocation + "\n";
    }


}
