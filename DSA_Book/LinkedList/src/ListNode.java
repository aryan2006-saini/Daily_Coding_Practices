public class ListNode {
    ListNode next;
    int val;
    public ListNode(int val){
        this.next = null;
        this.val = val;
    }
}

class Stack{
    public ListNode head;

    void push(int val){
        ListNode newNode = new ListNode(val);
        if (head==null){
            System.out.println("Adding>>>: "+newNode.val);
            head=newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        System.out.println("Adding>>>: "+newNode.val);
        temp.next= newNode;
    }

    void pop(){
        if (head==null){
            System.out.println("Cannot remove from empty stack!");
            return;
        }
        if (head.next==null){
            System.out.println("removing>>: "+head.val);
            head=null;
            return;
        }
        ListNode temp = head;

        while (temp.next.next!=null){
            temp = temp.next;
        }
        System.out.println("Removing>>>: "+ temp.next.val);
        temp.next = null;
    }

    void print(){
        if (head==null){
            System.out.println("Stack is empty!");
            return;
        }

        ListNode temp = head;

        while (temp!=null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
class Test{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.print();
        stack.push(2);
        stack.push(10);
        stack.push(46);
        stack.push(38);
        stack.print();
        stack.pop();
        stack.print();
    }
}

