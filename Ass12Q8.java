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

    boolean isCircular() {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = list.head;

        boolean isCircular = list.isCircular();
        System.out.println(isCircular);
    }
}
