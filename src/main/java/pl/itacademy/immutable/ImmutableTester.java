package pl.itacademy.immutable;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ImmutableTester {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Map<Person, String> beerLovers = new HashMap<>();

        final String krakowCity = "Krakow";
        Address krakow = new Address(krakowCity);
        Address wroclaw = new Address("Wroclaw");
        Person kowalski = Person.createPerson("Jan", "Kowalski", krakow);
        Person nowak = Person.createPerson("Ola", "Nowak", wroclaw);
        Person sereda = Person.createPerson("Oleg", "Sereda", krakow);

        Student student = new Student("Grzegorz", "Brzerzeczikiewicz", krakow, "it-academy");

        beerLovers.put(kowalski, "Ciemne");
        beerLovers.put(nowak, "Jasne");
        beerLovers.put(sereda, "craftowe");
//        beerLovers.put(student, "Lagger");

        System.out.println("Beer lovers map: " + beerLovers);

        String kowalskiFavoriteBeer = beerLovers.get(kowalski);
        String nowakFavoriteBeer = beerLovers.get(nowak);
//        String studentFavoriteBeer = beerLovers.get(student);
        System.out.println("Kowalski favorite beer is: " + kowalskiFavoriteBeer);
        System.out.println("Nowak favorite beer is: " + nowakFavoriteBeer);
//        System.out.println("Student favorite beer is: " + studentFavoriteBeer);

        krakow.setCity("Krakow miastem krolej polskich");
        Address nowakAddress = nowak.getAddress();
        nowakAddress.setCity("Krakow miastem krolej polskich");
        student.setGroupName("Java fundamentals");
        System.out.println("Beer lovers map after changes: " + beerLovers);

        nowakFavoriteBeer = beerLovers.get(nowak);
        kowalskiFavoriteBeer = beerLovers.get(kowalski);
//        studentFavoriteBeer = beerLovers.get(student);
        System.out.println("Kowalski favorite beer is: " + kowalskiFavoriteBeer);
        System.out.println("Nowak favorite beer is: " + nowakFavoriteBeer);
//        System.out.println("Student favorite beer is: " + studentFavoriteBeer);


        Field lastName = kowalski.getClass().getDeclaredField("lastName");
        lastName.setAccessible(true);
        lastName.set(kowalski, "Kowalski super hero");

        System.out.println(kowalski);
        System.out.println(beerLovers.get(kowalski));

        Certificate certificate = new Certificate("Oracle", "Java developer");
        ImmutableClass immutableClass = new ImmutableClass("first", krakow, certificate);
        System.out.println(immutableClass.hashCode());

        immutableClass.getAddress().setCity("Katowice");
        System.out.println(immutableClass.hashCode());
    }
}
