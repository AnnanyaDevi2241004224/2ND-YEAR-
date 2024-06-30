class link
{
	int startt; int finish; String name; link next;
	link(){}
	link(int s,int f,String n)
	{
		startt=s; finish =f; name= n; next =null;
	}
}
public class IntervalScheduling
{
	static link start =null;
	public static void insert(link node ,int s,int f,String n)
	{
		link temp=new link(s,f,n);
		while(node.next!=null)
		{
			node=node.next;
		}
		node.next=temp;
	}
	public static void display(link node)
	{
		if (start==null)
			System.out.println("underflow");
		else
		{
			while(node!=null)
			{
				System.out.print("{"+node.startt+" "+node.finish+"  "+node.name+"}  ");
				node=node.next;
			}
			System.out.println();
		}
	}
	public static void sort(link node)
	{
		link ptr1=new link();  link ptr2=new link();
		for(ptr1=node;ptr1.next!=null;ptr1=ptr1.next)
		{
			for(ptr2=ptr1.next;ptr2!=null;ptr2=ptr2.next)
			{
				if(ptr1.finish>ptr2.finish)
				{
					int s=ptr1.startt; int f=ptr1.finish; String n=ptr1.name;
					ptr1.startt=ptr2.startt; ptr1.finish=ptr2.finish;ptr1.name=ptr2.name;
					ptr2.startt=s;ptr2.finish=f;ptr2.name=n;
				}
			}
		}
	}
	public static void IS(link node,int x)
	{
		String arr[]= new String [x];
		link ptr1=node;
		arr[0]=ptr1.name; int i=1;
		for(;ptr1.next!=null;ptr1=ptr1.next)
		{
			if(ptr1.finish<=ptr1.next.startt)
			{
				arr[i]=ptr1.next.name; i++;
			}
		}
		System.out.println("Intervals to be Scheduled :");
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]!=null)
				System.out.print(arr[j]+"   ");
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("PS C:\\Annanya_Devi_2241004224>  & 'C:\\Program Files\\Java\\jdk-21\\bin\\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '--module-path' 'C:\\Annanya_Devi_2241004224\\Ad2\\bin' '-m' 'Ad2/fknapsack'");

		link node =new link(1,3,"a");
		start=node;
		insert(start,2,5,"b");
		insert(start,3,9,"c");
		insert(start,6,8,"d");
		System.out.println("Before sorting according to finish time:");
		display(start);
		sort(start);
		System.out.println("After sorting according to finish time:");
		display(start);
		IS(start,4); // 4 is the no of intervals given as input  
	}
}
/*
OUTPUT: 
Before sorting according to finish time:
{1 3  a}  {2 5  b}  {3 9  c}  {6 8  d}  
After sorting according to finish time:
{1 3  a}  {2 5  b}  {6 8  d}  {3 9  c}  
Intervals to be Scheduled :
a   d  
*/