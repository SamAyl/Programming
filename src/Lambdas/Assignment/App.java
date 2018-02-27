package Lambdas.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Person p1 = new Person(1, "abc");
        Person p2 = new Person(9, "abd");
        Person p3 = new Person(3, "cda");

        List<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);

        Collections.sort(list, (o1, o2) -> o1.name.compareTo(o1.name));
        System.out.println("Printing all the elements in ascending order of names");
        App app = new App();
        app.print(list);

        AlphaCheck checkForC = (List<Person>p, Character ch) -> {
            List<Person> people = new ArrayList<>();
            for (Person person : p) {
                if (person.name.contains(ch.toString())) {
                    people.add(person);
                }
            }
            return people;
        };
        Character ch = 'a';
        System.out.println("Printing all the elements which contains the alphabet '"+ ch +"' in their names");
        app.print(checkForC.containsC(list,ch));


        Collections.sort(list,(n1,n2)->n1.age - n2.age);
        System.out.println("Printing all the elements in ascending order of age");
        app.print(list);
    }


    public void print(List<Person> list) {
        for (Person p : list) {
            System.out.println(p.age + "  " + p.name);
        }
    }
}
