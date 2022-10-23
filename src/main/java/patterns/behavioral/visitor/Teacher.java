package patterns.behavioral.visitor;

public class Teacher implements Person {

    private String Name;
    private String surName;
    private int totalGroups;

    public Teacher(String name, String surName, int totalGroups) {
        Name = name;
        this.surName = surName;
        this.totalGroups = totalGroups;
    }

    public int getTotalGroups() {
        return totalGroups;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getSurName() {
        return surName;
    }
}
