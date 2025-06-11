class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = prev = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    // 1️⃣ Insert a node at the beginning
    public void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // 2️⃣ Insert a node at the end
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 3️⃣ Remove a node at the beginning
    public void removeFromBeginning() {
        if (head == null) return; // Empty list

        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
    }

    // 4️⃣ Remove a node at the end
    public void removeFromEnd() {
        if (tail == null) return; // Empty list

        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
    }

    // 5️⃣ Search for a node with a specific value
    public boolean search(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // ✅ **Testing the Code**
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);
        dll.insertAtEnd(30);
        dll.display(); // Output: 20 <-> 10 <-> 30 <-> NULL

        dll.removeFromBeginning();
        dll.display(); // Output: 10 <-> 30 <-> NULL

        dll.removeFromEnd();
        dll.display(); // Output: 10 <-> NULL

        System.out.println("Search 10: " + (dll.search(10) ? "Found" : "Not Found"));
        System.out.println("Search 30: " + (dll.search(30) ? "Found" : "Not Found"));
    }
}
