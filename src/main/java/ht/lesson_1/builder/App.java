package ht.lesson_1.builder;

public class App {
    public static void main(String[] args) {
//        Person person = new PersonBuilder().age(30)
//                .address("Moscow")
//                .firstName("Name")
//                .middleName("MiddleName")
//                .lastName("LastName")
//                .gender("Gender")
//                .country("Russia")
//                .phone("8 800 555 35 35")
//                .build();
        Person person = Person.builder().firstName("f").lastName("l").build();
        System.out.println(person.getFirstName() + " " + person.getLastName());

        Person person2 = Person.builder().firstName("1").build();
        System.out.println(person2.getFirstName() + " " + person2.getLastName());
    }
}
