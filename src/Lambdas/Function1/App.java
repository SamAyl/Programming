package Lambdas.Function1;



import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args){

     Person person = new Person("Isa",10);
     Person person1 = new Person("Sai",20);
     Person person2 = new Person("Cathy",30);
     Person person3 = new Person("Isaih",40);

     List<Person> people = Arrays.asList(person,person1,person2,person3);

     App app = new App();
     app.print(people,p->p.name.startsWith("I"),p-> System.out.println(p.age + " "+ p.name));

    }

    public void print(List<Person > persons, Predicate<Person> personPredicate, Consumer<Person> consumer){

        for(Person person : persons){
            if(personPredicate.test(person)){
                consumer.accept(person);
            }
        }
    }


}
