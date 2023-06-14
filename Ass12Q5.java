class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    void detectAndRemoveLoop() {
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            // No loop found
            return;
        }

        slow = head;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(4);
        list.push(3);
        list.push(1);

        list.head.next.next.next = list.head.next;

        list.detectAndRemoveLoop();

        list.printList();
    }
}

