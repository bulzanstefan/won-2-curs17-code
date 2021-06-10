package ro.fasttrackit.curs17;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class TryStreams {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Ana", 32),
                new Person("Mihai", 22),
                new Person("Mihai", 12),
                new Person("Mihai", 32),
                new Person("George", 12),
                new Person("Laurentiu", 52),
                new Person("Ecaterina", 32),
                new Person("Darius", 26),
                new Person("Carol", 33),
                new Person("Zaro", 33)
        );

        //get all names
        List<String> names = persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(toList());

        System.out.println(names);

        List<Person> major = persons.stream()
                .filter(person -> person.getAge() > 17)
                .collect(toList());

        System.out.println(major);

        List<Person> falsePredicate = persons.stream()
                .filter(person -> false)
                .collect(toList());
        System.out.println(falsePredicate);

        Optional<Person> anabela = persons.stream()
                .filter(person -> person.getName().equals("Anabela"))
                .findFirst();
        System.out.println(anabela);

        persons.stream()
                .filter(person -> person.getAge() > 10)
                .findAny()
                .map(Person::getName)
                .ifPresent(System.out::println);

        //sorting
        System.out.println(persons.stream()
                .map(Person::getAge)
                .sorted()
                .collect(toList()));

        System.out.println(persons.stream()
                .map(Person::getName)
                .sorted()
                .collect(toList()));

        System.out.println(persons.stream()
                .sorted(comparing(Person::getName).reversed())
                .collect(toList()));

        System.out.println(persons.stream()
                .sorted(comparingInt(Person::getAge).thenComparing(Person::getName))
                .collect(toList()));
        System.out.println(persons.stream()
                .sorted(comparing(Person::getName)
                        .thenComparing(Person::getAge))
                .collect(toList()));
        System.out.println(persons.stream()
                .sorted(comparing(Person::getName).reversed()
                        .thenComparing(Person::getAge).reversed())
                .collect(toList()));
    }
}

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
