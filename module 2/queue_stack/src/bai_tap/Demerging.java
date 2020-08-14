package bai_tap;

import java.util.*;
import java.util.Queue;

public class Demerging {
    public static class Person {
        boolean gender = false;
        String name = "";
        String birthday = "";

        public Person() {
        }

        public Person(boolean gender, String name, String birthday) {
            this.gender = gender;
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static Comparator<Person> BirthdayComparator = new Comparator<Person>() {
        public int compare(Person p1, Person p2) {
            String birthday1 = p1.birthday;
            String birthday2 = p2.birthday;
            return birthday1.compareTo(birthday2);
        }
    };

    public static void main(String[] args) {
        List<Person> arr = new ArrayList<>();
        Person male1 = new Person(true, "Male 1", "1.1.1991");
        Person female1 = new Person(false, "Female 1", "2.2.1992");
        Person male2 = new Person(true, "Male 2", "3.3.1993");
        Person female2 = new Person(false, "Female 2", "4.4.1994");
        arr.add(male2);
        arr.add(female1);
        arr.add(male1);
        arr.add(female2);
        System.out.println(arr);

        Collections.sort(arr, Demerging.BirthdayComparator);
        System.out.println(arr);

        Queue<Person> queueF = new LinkedList<>();
        Queue<Person> queueM = new LinkedList<>();
        for (Person person : arr) {
            if (person.gender) queueM.offer((person));
            else queueF.add(person);
        }

        ArrayList<Person> arr2 = new ArrayList<>();
        while (!queueF.isEmpty()) {
            arr2.add(queueF.remove());
        }
        while (!queueM.isEmpty()) {
            arr2.add(queueM.remove());
        }
        System.out.println(arr2);
    }
}
