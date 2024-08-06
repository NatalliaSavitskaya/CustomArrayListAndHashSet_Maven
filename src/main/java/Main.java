import java.sql.Timestamp;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Ticket ticket1 = new Ticket("Alexandria", "012", Timestamp.valueOf("2024-07-28 13:18:06.5338071"),
                true, 'A', 5.15F, BigDecimal.valueOf(19.99));
        Ticket ticket2 = new Ticket("Mafia", "258", Timestamp.valueOf("2024-07-25 14:18:06.5338071"),
                false, 'B', 0.0F, BigDecimal.valueOf(00.10));
        Ticket ticket3 = new Ticket("Cinema", "857", Timestamp.valueOf("2024-08-28 23:18:06.5338071"),
                false, 'C', 10.15F, BigDecimal.valueOf(100.00));

        CustomArrayList<Ticket> customArrayList = new CustomArrayList<>();
        customArrayList.put(ticket1);
        customArrayList.put(ticket2);
        customArrayList.put(ticket3);
        customArrayList.put(ticket1); // This will not be added again
        System.out.println("CustomArrayList size: " + customArrayList.size() + "\n");
        System.out.println("Element at index 1: " + customArrayList.get(1) + "\n");
        customArrayList.delete(1);
        System.out.println("CustomArrayList size after deletion: " + customArrayList.size() + "\n");
        System.out.println("Element at index 1: " + customArrayList.get(1) + "\n");

        CustomHashSet<Ticket> customHashSet = new CustomHashSet<>();
        customHashSet.put(ticket1);
        customHashSet.put(ticket2);
        customHashSet.put(ticket3);
        System.out.println("Iterating over CustomHashSet:\n");
        customHashSet.iterate();
        System.out.println("CustomHashSet size: " + customHashSet.size() + "\n");
        System.out.println("Contains Element2: " + customHashSet.contains(ticket2) + "\n");
        customHashSet.delete(ticket2);
        System.out.println("CustomHashSet size after deletion: " + customHashSet.size() + "\n");
        System.out.println("Contains Element2: " + customHashSet.contains(ticket2) + "\n");
        System.out.println("Iterating over CustomHashSet:" + "\n");
        customHashSet.iterate();
    }
}