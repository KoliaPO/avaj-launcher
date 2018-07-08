package Tower;

import Aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observer = new ArrayList<>();

    public void register(Flyable flyable) {
        observer.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observer.remove(flyable);
    }

    protected void conditionsChange() {
        for (int i = 0; i < observer.size(); i++)
            observer.get(i).updateConditions();
    }
}
