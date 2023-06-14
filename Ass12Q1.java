class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void deleteMiddle() {
        if (head == null || head.next == null) {
            return;
        }

        Node slowPtr = head;
        Node fastPtr = head;
        Node prev = null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }

        prev.next = slowPtr.next;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.deleteMiddle();
        list.printList();
    }
}
