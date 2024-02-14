import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;

    // Constructors, getters, and setters go here

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}
