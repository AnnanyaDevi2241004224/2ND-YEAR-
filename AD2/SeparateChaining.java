
import java.util.Scanner;
class Node{
	int value; Node next;
	Node(int el)
	{
		value=el;
	}
}
public class SeparateChaining {
	public static int hash(int key,int p) {
		int i=key%p;
		if(i<0)
			i=i*-1;
		return i;
	}
	public void insert(Node[] hashtable,int arr[],int p) {
		for(int i=0;i<arr.length;i++) {
			int h=hash(arr[i],p);
				Node ptr=hashtable[h];
				Node temp=new Node(arr[i]);
				temp.next=ptr;
				ptr=temp;
				hashtable[h]=ptr;
		}
	}
	public void display(Node hashtable[]) {
		for(int i=0;i<hashtable.length;i++) {
			Node ptr=hashtable[i];
			System.out.print("Index "+i+":");
			while(ptr.next!=null) {
				System.out.print(ptr.value+"-->");
				ptr=ptr.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SeparateChaining spc=new SeparateChaining ();
		int arr[]= {42,10,5,15,-12,21,28};
		System.out.println("Enter a Prime Number:");
		int p=sc.nextInt();
		Node[] hashtable=new Node[p];
		for(int i=0;i<p;i++) {
			hashtable[i]=new Node(0);
		}
		spc.insert(hashtable,arr,p);
		spc.display(hashtable);
	}
}
