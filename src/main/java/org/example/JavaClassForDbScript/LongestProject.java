package org.example.JavaClassForDbScript;

public class LongestProject {
    private int projectId;
    private int monthCount;

    public LongestProject(int projectId, int monthCount) {
        this.projectId = projectId;
        this.monthCount = monthCount;
    }
    @Override
    public String toString() {
        return "Projectid: " + projectId +" Monthcount: "+  monthCount;
    }
}
