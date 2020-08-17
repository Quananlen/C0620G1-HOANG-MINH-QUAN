package thuc_hanh;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        System.out.println("So sanh theo ten:");
        lists.forEach(st -> System.out.println(st.toString()));

//        lists.sort((std1,std2)-> std1.getAge() - std2.getAge());
        lists.sort(Comparator.comparingInt(Student::getAge));
        System.out.println("So sanh theo tuoi:");
        lists.forEach(st -> System.out.println(st.toString()));

//        AgeComparator ageComparator = new AgeComparator();
//        Collections.sort(lists,ageComparator);
//        lists.forEach(st -> System.out.println(st.toString()));

    }
}
