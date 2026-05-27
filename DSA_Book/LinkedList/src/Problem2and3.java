public class Problem2and3 {
    private Node head;
    void add_node(int val) {
       Node newNode = new Node(val);
       if (head==null){
           System.out.println("Adding>>: "+val);
           head=newNode;
           return;
       }
       Node temp = head;
       while(temp.next!=null){
           temp= temp.next;
       }
        System.out.println("Adding>>: "+val);
       temp.next = newNode;
   }

   void print(){
        if (head==null){
            System.out.println("LL is Empty!");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
       System.out.println("null");
   }

   int nthNode(int n){
        if (head==null){
            System.out.println("LL is empty!");
        }
        Node fast = head;
        for (int i=0; i<n; i++){
            fast = fast.next;
        }
        Node slow = head;
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;

   }
}

class Node{
    Node next;
    int val;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}

class NodeTest{
    public static void main(String[] args) {
        Problem2and3 ll = new Problem2and3();
        ll.add_node(3);
        ll.add_node(47);
        ll.add_node(74);
        ll.add_node(65);
        ll.print();
        System.out.println(ll.nthNode(2));
    }
}
