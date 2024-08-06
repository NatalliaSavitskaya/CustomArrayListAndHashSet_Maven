import java.util.Arrays;

public class CustomArrayList<T> {
    private Object[] elements;
    private int size = 0;

    private static final int INITIAL_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    // Constructor
    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    // Method to add an element
    public void put(T element) {
        if (size >= elements.length * LOAD_FACTOR) {
            resize();
        }
        elements[size++] = element;
    }

    // Method to get an element by index
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    // Method to delete an element by index
    public void delete(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    // Get the current size
    public int size() {
        return size;
    }

    // Resize the array
    private void resize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}