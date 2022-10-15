package patterns.behavioral.visitor;



public class MainClass {
    public static void main(String[] args) {

        School school = new School();

        Student student = new Student("Иван","Иванов", 2);
        Teacher teacher = new Teacher("Петр", "Васильевич", 10);

        school.addPerson(student);
        school.addPerson(teacher);

        Visitor visitor = new VisitorText();
        school.setVisitor(visitor);
        school.print();

        visitor = new VisitorXML();
        school.setVisitor(visitor);
        school.print();
    }
}

