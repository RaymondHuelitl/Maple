package controller;

import model.Label;
import java.util.*;

public class LabelController {
    private final List<Label> labels = new ArrayList<>();

    public LabelController() {
        labels.add(new Label("School", "#3b82f6"));
        labels.add(new Label("Work", "#22c55e"));
        labels.add(new Label("Meal Prep", "#f59e0b"));
        labels.add(new Label("Self-Care", "#a855f7"));
        labels.add(new Label("Birthdays", "#ef4444"));
    }

    // Retrieve all labels
    public List<Label> getAll() {
        return labels;
    }

    // Find label by name
    public Label getByName(String name) {
        for (Label l : labels) {
            if (l.getName().equalsIgnoreCase(name)) return l;
        }
        return null;
    }

    // Add new label
    public void addLabel(Label label) {
        if (getByName(label.getName()) == null) {
            labels.add(label);
        } else {
            System.out.println("Label '" + label.getName() + "' already exists.");
        }
    }

    // Update label name
    public void updateLabelName(String oldName, String newName) {
        Label label = getByName(oldName);
        if (label != null) {
            label.setColor(newName);
        } else {
            System.out.println("Label '" + oldName + "' not found.");
        }
    }

    // Update label color
    public void updateLabelColor(String name, String newColor) {
        Label label = getByName(name);
        if (label != null) {
            label.setColor(newColor);
        } else {
            System.out.println("Label '" + name + "' not found.");
        }
    }

    // Remove label
    public void removeLabel(String name) {
        labels.removeIf(l -> l.getName().equalsIgnoreCase(name));
    }

    // Print all labels for debugging or display
    public void printLabels() {
        System.out.println("Current Labels:");
        for (Label l : labels) {
            System.out.println("- " + l.getName() + " | Color: " + l.getColor());
        }
    }
}
