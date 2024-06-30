import java.util.Scanner;
class node
{
	String item; int profit; int weight; int ratio;  node next;
	node(String i, int p, int w)
	{
		item=i; profit=p; weight=w; ratio=p/w; next =null;
	}
	node(){}
}
public class fknapsack {
	static node start =null;
	public static void insert(node n ,String i, int p, int w)
	{
		node temp=new node(i,p,w);
		while(n.next!=null)
		{
			n=n.next;
		}
		n.next=temp;
	}
	public static void display(node n)
	{
		if (start==null)
			System.out.println("underflow");
		else
		{
			while(n!=null)
			{
				System.out.print("{"+n.item+" "+n.profit+"  "+n.weight+" "+n.ratio+"}  ");
				n=n.next;
			}
			System.out.println();
		}
	}
	public static void sort( node n)
	{
		node ptr1=new node();  node ptr2=new node();
		for(ptr1=n;ptr1.next!=null;ptr1=ptr1.next)
		{
			for(ptr2=ptr1.next;ptr2!=null;ptr2=ptr2.next)
			{
				if(ptr2.ratio>ptr1.ratio)
				{
					int r=ptr1.ratio; int p=ptr1.profit; int w=ptr1.weight; String i=ptr1.item;
					ptr1.ratio=ptr2.ratio; ptr1.profit=ptr2.profit; ptr1.weight=ptr2.weight; ptr1.item=ptr2.item;
					ptr2.ratio=r; ptr2.profit=p; ptr2.weight=w;ptr2.item=i;
				}
			}
		}
	}
	public static void FK(node n,int m,int e)
	{
		String arr[]= new String [e];
		node ptr1=n;
		arr[0]=ptr1.item; int i=1; int profit=ptr1.profit; m=m-ptr1.weight;
		ptr1=ptr1.next;
		for(;ptr1!=null;ptr1=ptr1.next)
		{
			if(m>0)
			{
				if(m-ptr1.weight>=0)
				{
					profit=profit+ptr1.profit;
					m=m-ptr1.weight;
				}
				else
				{
					profit=profit +(ptr1.ratio*m);
				}
				arr[i]=ptr1.item;
				i++;
			}	
		}
		System.out.println("Knapsack has :");
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]!=null)
				System.out.print(arr[j]+"   ");
		}
		System.out.println("profit :"+profit);
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no of entries: ");//enter 3
		int e=sc.nextInt();
		System.out.print("Enter max weight: ");//enter 50
		int w=sc.nextInt();
		 node n=new node("a",100,20);
		start=n;
		insert(start,"b",60,10);
		insert(start,"c",120,30);
		System.out.println("Before sorting according to profit/weight :");
		display(start);
		sort(start);
		System.out.println("After sorting according to profit/weight  :");
		display(start);
		FK(start,w,e);
        sc.close();
	}

}
/*
Enter no of entries: 3
Enter max weight: 50
Before sorting according to profit/weight :
{a 100  20 5}  {b 60  10 6}  {c 120  30 4}  
After sorting according to profit/weight  :
{b 60  10 6}  {a 100  20 5}  {c 120  30 4}  
Knapsack has :
b   a   c   profit :240*/