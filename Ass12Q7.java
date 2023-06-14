class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void insertAtAlternatePositions(Node first, Node second) {
        Node currFirst = first;
        Node currSecond = second;
        Node nextFirst, nextSecond;

        while (currFirst != null && currSecond != null) {
            nextFirst = currFirst.next;
            nextSecond = currSecond.next;

            currFirst.next = currSecond;
            currSecond.next = nextFirst;

            currFirst = nextFirst;
            currSecond = nextSecond;
        }

        second = currSecond;
    }

    public static void displayList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(5);
        first.next = new Node(7);
        first.next.next = new Node(17);
        first.next.next.next = new Node(13);
        first.next.next.next.next = new Node(11);

        Node second = new Node(12);
        second.next = new Node(10);
        second.next.next = new Node(2);
        second.next.next.next = new Node(4);
        second.next.next.next.next = new Node(6);

        System.out.print("First List: ");
        displayList(first);
        System.out.print("Second List: ");
        displayList(second);

        insertAtAlternatePositions(first, second);

        System.out.print("Modified First List: ");
        displayList(first);
        System.out.print("Modified Second List: ");
        displayList(second);
    }
}
