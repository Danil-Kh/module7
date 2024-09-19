package org.example.JavaClassForDbScript;

public class MaxProjectClients {
    private String projectName;
    private int projectCount;

    public MaxProjectClients(String projectName, int projectCount) {
        this.projectName = projectName;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "Project Name: " + projectName + " Project Count: " + projectCount;
    }
}
