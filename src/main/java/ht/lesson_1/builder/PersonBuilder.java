package lesson_1.builder;

public class PersonBuilder implements Builder {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    @Override
    public Builder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public Builder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public Builder middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @Override
    public Builder country(String country) {
        this.country = country;
        return this;
    }

    @Override
    public Builder address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Builder phone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public Builder age(int age) {
        this.age = age;
        return this;
    }

    @Override
    public Builder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public Person build() {
        return new Person(firstName,
                lastName,
                middleName,
                country,
                address,
                phone,
                age,
                gender);
    }

}
