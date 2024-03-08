package oy.tol.tra;
import java.util.ArrayList;
public class QueueImplementation<T> implements QueueInterface<T> {

    private ArrayList<T> arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    

    public QueueImplementation(int capacity) {
        this.capacity = capacity;
        this.arr = new ArrayList<>(capacity);
        front = 0;
        rear = -1;
        size = 0;
    }

    
    public void enqueue(T item) throws QueueAllocationException, NullPointerException {
        if (item == null) {
            throw new NullPointerException("the element is null");
        }
        if (size == capacity) {
            reallocate(capacity * 2);
        }
        rear = (rear + 1) % capacity;
        if (rear == arr.size()) {
            arr.add(item);
        }
        else{
            arr.set(rear, item);
        }
        size++;
    }
    
    
    private void reallocate(int newCapacity) {
        ArrayList<T> newArray = new ArrayList<>(newCapacity);
       
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            newArray.add(arr.get(index));
        }
    
        arr = newArray;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }

    
    public T dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty. Cannot dequeue.");
        }

        T item = arr.get(front);
        front = (front + 1) % capacity;
        size--;
        

        if (size == 0) {
            front = 0;
            rear = -1;
        }

        return item;
    }

    
    public boolean isEmpty() {
        return (size == 0);
    }

    
    public int capacity() {
        return capacity;
    }

    
    public T element() throws QueueIsEmptyException {
        if (rear == -1) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        return arr.get(front);
    }

    
    public int size() {
        return size;
    }

    
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (i + front) % capacity;
            builder.append(arr.get(index));
            if (i < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}