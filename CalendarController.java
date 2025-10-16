package controller;

import model.Task;
import java.util.*;

public class CalendarController {
    private final Map<String, List<Task>> calendar = new HashMap<>();

    public void addToCalendar(Task task) {
        calendar.computeIfAbsent(task.getDate(), k -> new ArrayList<>()).add(task);
    }

    public List<Task> getTasksOnDate(String date) {
        return calendar.getOrDefault(date, new ArrayList<>());
    }

    public void printCalendar() {
        for (String date : calendar.keySet()) {
            System.out.println("Date: " + date);
            for (Task t : calendar.get(date)) {
                System.out.println(" - " + t.getTitle() + " (" + t.getLabel() + ", " + t.getPriority() + ")");
            }
        }
    }
}
