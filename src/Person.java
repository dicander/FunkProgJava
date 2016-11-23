import java.util.ArrayList;

public class Person {

    public enum Sex {
        MALE, FEMALE, OTHER
    }

    String name;
    int age;
    Sex gender;

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Freja Lindberg", 18, Sex.OTHER));
        people.add(new Person("Marcus Dicander", 39, Sex.MALE));
        people.add(new Person("Ric Glassey", 37, Sex.MALE));
        people.add(new Person("Stefan Löfven", 59, Sex.MALE));
        people.add(new Person("Carola Häggkvist", 50, Sex.FEMALE));
        people.add(new Person("Edward Snowden", 33, Sex.MALE));
        people.add(new Person("Chelsea Manning", 28, Sex.FEMALE));
        people.add(new Person("Safra Catz", 54, Sex.FEMALE));
        people.add(new Person("Malala Yousafzai", 19, Sex.FEMALE));
        people.add(new Person("Aung San Suu Kyi", 71, Sex.FEMALE));
        people.add(new Person("Robin Miriam Carlsson", 37, Sex.FEMALE));
        System.out.println("Först skriver vi ut allihopa");
        people
            .stream()
            .forEach(e -> System.out.println(e));
        System.out.println();
        System.out.println("Tar filter bort eller lägger till?");
        people
            .stream()
            .filter(e -> e.getGender() == Person.Sex.FEMALE)
            .forEach(System.out::println);
        System.out.println();
        System.out.print("Genomsnittliga åldern för alla är: ");
        System.out.format(
                "%.2f\n",
                people
                    .stream()
                    .mapToInt(Person::getAge)
                    .average()
                    .getAsDouble());
        System.out.println();
        System.out.println("Ge mig alla som är under 40.");
        people
            .stream()
            .filter(e -> e.getAge() < 40)
            .forEach(System.out::println);
    }

    public Person(String name, int age, Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public Sex getGender() {
        return this.gender;
    }

    public String toString() {
        String answer = "";
        switch(this.gender) {
            case MALE: answer += "Han";
                       break;
            case FEMALE: answer += "Hon";
                         break;
            case OTHER:
            default:
                         answer += "Hen";
        }
        answer += " heter " + this.name + " och är ";
        answer += this.age + " år gammal.";
        return answer;
    }
}
