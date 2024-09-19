package org.example.JavaClassForDbScript;

public class ProjectPrices {
    private int project;
    private double projectPrice;

    public ProjectPrices(int project, double projectPrice) {
        this.project = project;
        this.projectPrice = projectPrice;
    }

    @Override
    public String toString() {
        return "project=" + project +
                ", projectPrice=" + projectPrice;
    }
}
