package model;

public class Label {
    private String name;
    private String color;

    public Label(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() { return name; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
