package patterns.behavioral.visitor;

public class VisitorXML implements Visitor {

    @Override
    public void showInfo(Person person) {

        if(person instanceof Student)
            System.out.println("<Root>\n<Name>" + person.getName() + "</Name>\n<Surname>" + person.getSurName() + "</Surname>\n<Group>" + ((Student)person).getGroupID() + "</Group>\n</Root>");
        if(person instanceof Teacher)
            System.out.println("<Root>\n<Name>" + person.getName() + "</Name>\n<Surname>" + person.getSurName() + "</Surname>\n<TotalGroup>" + ((Teacher)person).getTotalGroups() + "</TotalGroup>\n</Root>");

    }
}

