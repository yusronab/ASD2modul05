package LinkedList;
public class SinglyLinkedList {
    protected Node first;
    protected Node last;
    public int size;

    public SinglyLinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){
        return size;
    }

    public void insertAwal(int val){
        Node nptr = new Node(val, null);
        if(first == null){
            first = nptr;
            last = first;
        }else{
            nptr.SetLink(first);
            first = nptr;
        }
        size++;
    }

    public void insertAkhir(int val){
        Node nptr = new Node(val, null);
        if(first == null){
            first = nptr;
            last = first;
        }else{
            last.SetLink(nptr);
            last = nptr;
        }
        size++;
    }

    public void insertAtPos(int val, int pos){
        Node nptr = new Node(val, null);
        if(pos > size)
        System.out.println("Posisi melebihi batas linked list");
        else if(pos == 1)
        insertAwal(val);
        else if(pos == size)
        insertAkhir(val);
        else{
            Node ptr = first;
            pos = pos - 1;
            for(int i=1; i<size; i++){
                if(i == pos){
                    Node tmp = ptr.GetLink();
                    ptr.SetLink(nptr);
                    nptr.SetLink(tmp);
                    break;
                }
            ptr = ptr.GetLink();
            }
        size++;
        }
    }

    public void deleteAwal(){
        first = first.GetLink();
        size--;
    }

    public void deleteAkhir(){
        Node temp = first;
        for(int i=1; i<size-1; i++)
            temp = temp.GetLink();
            last = temp;
            last.SetLink(null);
        size--;
    }

    public void deleteAtPos(int pos){
        if(pos > size)
        System.out.println("Posisi node melebihi ukuran");
        else if(pos == 1)
        this.deleteAwal();
        else if(pos == size)
        this.deleteAkhir();
        else{
            Node ptr = first;
            pos--;
            for(int i=1; i<=pos; i++){
                if(i == pos){
                    Node temp = ptr.GetLink();
                    temp = temp.GetLink();
                    ptr.SetLink(temp);
                    break;
                }
                ptr = ptr.GetLink();
            }
        size--;
        }
    }

    public void display(){
        Node ptr = first;
        while(true){
            if(ptr == null)
            break;
            System.out.print(ptr.GetData() + "->");
            ptr = ptr.GetLink();
        }
        System.out.println();
    }
}
