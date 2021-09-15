package ht.lesson_1.builder;

public interface Builder {
    Builder firstName(String firstName);
    Builder lastName(String lastName);
    Builder middleName(String middleName);
    Builder country(String country);
    Builder address(String address);
    Builder phone(String phone);
    Builder age(int age);
    Builder gender(String gender);
    Person build();
}
