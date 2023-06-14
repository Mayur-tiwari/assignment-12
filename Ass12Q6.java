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

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
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

    public void retainMDeleteN(int M, int N) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            for (int i = 1; i < M && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                break;
            }

            Node temp = current.next;
            for (int i = 1; i <= N && temp != null; i++) {
                temp = temp.next;
            }

            current.next = temp;
            current = temp;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);

        int M = 2;
        int N = 2;

        list.retainMDeleteN(M, N);

        list.display();
    }
}
