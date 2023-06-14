class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int findNthFromEnd(int n) {
        if (head == null) {
            return -1;
        }

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(6);
        linkedList.addNode(7);
        linkedList.addNode(8);
        linkedList.addNode(9);

        int n = 2;
        int nthNode = linkedList.findNthFromEnd(n);

        if (nthNode != -1) {
            System.out.println(nthNode);
        } else {
            System.out.println("Invalid input");
        }
    }
}
