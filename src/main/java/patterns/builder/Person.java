package patterns.builder;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String country;
    private final String address;
    private final String phone;
    private final String gender;
    private final int age;

    public Person(BuilderPerson builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.country = builder.country;
        this.address = builder.address;
        this.phone = builder.phone;
        this.gender = builder.gender;
        this.age = builder.age;
    }

    public static BuilderPerson builder(){
        return new BuilderPerson();
    }

    public static class BuilderPerson{
        private String firstName, lastName, middleName, country, address, phone, gender;
        private int age;

        public BuilderPerson firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public BuilderPerson lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public BuilderPerson middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public BuilderPerson country(String country) {
            this.country = country;
            return this;
        }

        public BuilderPerson address(String address) {
            this.address = address;
            return this;
        }

        public BuilderPerson phone(String phone) {
            this.phone = phone;
            return this;
        }

        public BuilderPerson gender(String gender) {
            this.gender = gender;
            return this;
        }

        public BuilderPerson age(int age) {
            this.age = age;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        Person person = Person.builder()
                .address("Moscow")
                .country("Russia")
                .age(18)
                .firstName("Andrey")
                .middleName("Aleksandrovich")
                .lastName("Shevelenko")
                .gender("man")
                .phone("8-123-123-1231")
                .build();

        System.out.println(person);
    }
}
