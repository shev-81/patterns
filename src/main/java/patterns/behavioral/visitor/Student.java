package patterns.behavioral.visitor;

public class Student implements Person {
    private String Name;
    private String surName;
    private int groupID;

    public Student(String name, String surName, int groupID) {
        Name = name;
        this.surName = surName;
        this.groupID = groupID;
    }

    public int getGroupID() {
        return groupID;
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