package main;

import controller.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        AuthController auth = new AuthController();
        TaskController taskController = new TaskController();
        LabelController labelController = new LabelController();
        CalendarController calendarController = new CalendarController();

        if (auth.login("demo@pandtask.app", "Demo User")) {
            System.out.println("Logged in as: " + auth.getCurrentUser().getName());
        }

        // Create and add new class/event
        Task class1 = new Task("101", "Math Class", "2025-10-20", "09:00", "10:30",
                "School", "High", "None", "Chapter 5 Review");
        class1.setColor("#3b82f6"); // blue for School
        taskController.addTask(class1);
        calendarController.addToCalendar(class1);

        // Example of color edit
        labelController.updateLabelColor("Work", "#16a34a");

        // Display
        System.out.println("Total tasks: " + taskController.getAll().size());
        calendarController.printCalendar();

        for (Label l : labelController.getAll()) {
            System.out.println("Label: " + l.getName() + " | Color: " + l.getColor());
        }
    }
}
