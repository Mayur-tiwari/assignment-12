class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

   boolean hasLoop() {
        if (head == null || head.next == null) {
            return false; // No loop if the list is empty or has only one node
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(4);
        list.push(3);
        list.push(1);

        list.head.next.next.next = list.head.next;

        boolean hasLoop = list.hasLoop();
        System.out.println(hasLoop);
    }
}
