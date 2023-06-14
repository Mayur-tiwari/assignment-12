class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class PalindromeLinkedList {
    Node head;

    boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseLinkedList(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        list.head = new Node('R');
        list.head.next = new Node('A');
        list.head.next.next = new Node('D');
        list.head.next.next.next = new Node('A');
        list.head.next.next.next.next = new Node('R');

        if (list.isPalindrome()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
