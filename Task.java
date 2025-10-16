package model;

public class Task {
    private String id;
    private String title;
    private String date;
    private String start;
    private String end;
    private String label;
    private String priority;
    private String repeat;
    private String notes;
    private boolean highPriority;
    private String color;

    public Task(String id, String title, String date, String start, String end,
                String label, String priority, String repeat, String notes) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.start = start;
        this.end = end;
        this.label = label;
        this.priority = priority;
        this.repeat = repeat;
        this.notes = notes;
        this.highPriority = "High".equalsIgnoreCase(priority);
        this.color = "#ffffff";
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getStart() { return start; }
    public String getEnd() { return end; }
    public String getLabel() { return label; }
    public String getPriority() { return priority; }
    public String getRepeat() { return repeat; }
    public String getNotes() { return notes; }
    public boolean isHighPriority() { return highPriority; }
    public String getColor() { return color; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setPriority(String priority) {
        this.priority = priority;
        this.highPriority = "High".equalsIgnoreCase(priority);
    }
    public void setColor(String color) { this.color = color; }
}
