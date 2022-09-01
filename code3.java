class node{
    public int data;
    public node next;
    public node(int data){
        this.data = data;
        this.next =null;
    }
}
public class code3{
    node add(node head,int data){
        if(head==null)return new node(data);
        head.next = add(head.next,data);
        return head;
    }
    void display(node head,node headCopy,boolean isStaringPoint){
        if(head==null){
            System.out.println("NULL");
            return;
        }
        if(isStaringPoint==false && head==headCopy){
            return;
        }

        System.out.print(head.data+"->");
        display(head.next,headCopy,false);
    }
    void makeItCircular(node head,node headCopy){
        if(head==null){
            return;
        }
        if(head.next==null){
            head.next = headCopy;
            return;
        }
        makeItCircular(head.next, headCopy);
    }
    public static void main(String[] args) {
        var code = new code3();

        node head = null;

        head = code.add(head, 10);
        head = code.add(head, 20);
        head = code.add(head, 30);

        code.makeItCircular(head, head);

        code.display(head,head,true);

    }
}