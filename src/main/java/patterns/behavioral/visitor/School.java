package patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> listPerson;
    private Visitor visitor;

    public School() {
        this.listPerson = new ArrayList<>();
    }

    public void print(){
        for (Person person: listPerson) {
            visitor.showInfo(person);
        }
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void addPerson(Person person){
        listPerson.add(person);
    }
}
