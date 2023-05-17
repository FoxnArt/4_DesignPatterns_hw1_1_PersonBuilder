import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return (age != -1);
    }
    public boolean hasAddress() {
        return (address != null);
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (age != -1) {
            age++;
        } else {
            System.out.println("Возраст не известен. Сначала укажите возраст.");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = address == null ? 0 : address.hashCode();
        result = (31 * result) + name.hashCode();
        result = (31 * result) + surname.hashCode();
        result = (31 * result) + age;
        return result;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(age)
                .setAddress(address);
    }
}
