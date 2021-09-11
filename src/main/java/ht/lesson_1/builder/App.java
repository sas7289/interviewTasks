package lesson_1.builder;

public class App {
    public static void main(String[] args) {
        Person person = new PersonBuilder().age(30)
                .address("Moscow")
                .firstName("Name")
                .middleName("MiddleName")
                .lastName("LastName")
                .gender("Gender")
                .country("Russia")
                .phone("8 800 555 35 35")
                .build();
        System.out.println(person);
    }
}
