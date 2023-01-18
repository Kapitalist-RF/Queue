import java.util.*;

public class Main {

    public static void main(String[] args) {

        Deque<Person> personDeque = new ArrayDeque<>(generateClients());
        while (!personDeque.isEmpty()) {
            Person person = personDeque.pollLast();
            if (person.getCountTickets() > 0) {
                person.setCountTickets(person.getCountTickets() - 1);
                System.out.println(person.getName() + " " + person.getSurname() + " прокатился на аттракционе!");
                if (person.getCountTickets() == 0) {
                    System.out.println(person.getName() + " " + person.getSurname() + " закончились билеты, покидает очередь!");
                } else {
                    personDeque.push(person);
                }
            }
        }

    }

    public static List<Person> generateClients() {
        LinkedList<Person> personLinkedList = new LinkedList<>();
        Random random = new Random();
        String[] name = new String[]{"Оля", "Дима", "Петя", "Вера", "Вася"};
        String[] surname = new String[]{"Иванов(а)", "Васильев(а)", "Ковалев(а)",
                "Родионов(а)", "Салтыков(а)", "Нетоложко"};
        for (int i = 0; i < name.length; i++) {
            personLinkedList.add(new Person(name[random.nextInt(5)], surname[random.nextInt(6)],
                    random.nextInt(5, 20)));
        }
        return personLinkedList;
    }

}
