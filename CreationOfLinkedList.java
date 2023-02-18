public class CreationOfLinkedList {
    static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    public void addMiddle(int index ,int data) {
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        // i = index - 1 (temp) -> previous node
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    public int removeFirst() {
        int val = head.data;
        if (size() == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if (size() == 1) {
            val = head.data;
            head = tail = null;
        }
        head = head.next;
        return val;
    }
    public int search(int element) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.data == element) {
                return count;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }
    public int search(int element ,Node head) {
        if (head == null) {
            return -1;
        }
        if (head.data == element) {
            return 0;
        }
        return 1 + search(element ,head.next);
    }
    public int removeLast() {
        int val = tail.data;
        tail.next = tail;
        return val;
    }
    public void reverse() {
        Node previous = null;
        Node current = tail = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    public static void main(String[] args) {
        CreationOfLinkedList list = new CreationOfLinkedList();
        list.addFirst(1);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        System.out.println("Elements are added to first in linked list");
        list.addLast(-9);
        list.addLast(-75);
        list.addLast(-74);
        list.addLast(-100);
        System.out.println("Elements are added to last in linked list");
        System.out.println();
        System.out.println("Print linked list");
        list.display();
        System.out.println("null");
        System.out.println();
        System.out.println("Size of linked list : " + list.size());
        System.out.println();
        System.out.println("Add middle in linked list");
        list.addMiddle(1 ,-1000);
        list.display();
        System.out.println("null");
        System.out.println();
        System.out.println("Remove node from first : " + list.removeFirst());
        list.display();
        System.out.println("null");
        System.out.println();
        System.out.println("Remove node from last : " + list.removeLast());
//        list.display();
        System.out.println();
        System.out.println("Element found at index iterative approach : " + list.search(-100));
        System.out.println("Element found at index recursive approach : " + list.search(-9 ,head));
        System.out.println();
        System.out.println("Reverse linked list");
        list.reverse();
    }
}
