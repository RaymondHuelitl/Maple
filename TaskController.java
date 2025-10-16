package controller;

import model.Task;
import java.util.*;

public class TaskController {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAll() { return tasks; }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(Task updated) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(updated.getId())) {
                tasks.set(i, updated);
                return;
            }
        }
    }

    public void deleteTask(String id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
