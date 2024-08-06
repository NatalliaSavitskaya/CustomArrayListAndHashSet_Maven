import java.util.LinkedList;

public class CustomHashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<T>[] buckets;
    private int size = 0;

    // Constructor
    public CustomHashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Method to add an element
    public void put(T element) {
        if (contains(element)) return;   // here the uniqueness is provided
        if (size >= buckets.length * LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(element);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        buckets[index].add(element);
        size++;
    }

    // Method to check if the set contains an element
    public boolean contains(T element) {
        int index = getIndex(element);
        LinkedList<T> bucket = buckets[index];
        return bucket != null && bucket.contains(element);
    }

    // Method to delete an element
    public void delete(T element) {
        int index = getIndex(element);
        LinkedList<T> bucket = buckets[index];
        if (bucket != null && bucket.remove(element)) {
            size--;
        } else System.out.println("There is no element to delete.");
    }

    // Method to get the index for an element
    private int getIndex(T element) {
        return element.hashCode() % buckets.length;
    }

    // Get the current size
    public int size() {
        return size;
    }

    // Iterate through the set
    public void iterate() {
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                for (T element : bucket) {
                    System.out.println(element);
                }
            }
        }
    }

    // Method to resize the array when it is full
    private void resize() {
        LinkedList<T>[] oldBuckets = buckets;
        int newCapacity = buckets.length * 2;
        buckets = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
        for (LinkedList<T> bucket : oldBuckets) {
            for (T element : bucket) {
                put(element);
            }
        }
    }
}