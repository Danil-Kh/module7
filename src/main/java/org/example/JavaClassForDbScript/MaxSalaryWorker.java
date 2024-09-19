package org.example.JavaClassForDbScript;

public class MaxSalaryWorker {
    private String name;
    private double salary;

    public MaxSalaryWorker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " + salary;
    }
}
