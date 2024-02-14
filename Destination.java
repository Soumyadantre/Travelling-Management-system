import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    // Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(activities, that.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, activities);
    }
}

