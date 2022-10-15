package patterns.behavioral.visitor;

public class VisitorText implements Visitor{

    @Override
    public void showInfo(Person person) {
        if(person instanceof Student)
            System.out.println("Имя: " + person.getName()+ "\nФамилия: " + person.getSurName() + "\nГруппа - " + ((Student)person).getGroupID());
        if(person instanceof Teacher)
            System.out.println("Имя: " + person.getName()+ "\nФамилия: " + person.getSurName() + "\nВсего групп - " + ((Teacher)person).getTotalGroups());
    }
}

