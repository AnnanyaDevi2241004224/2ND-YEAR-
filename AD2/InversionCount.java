public class InversionCount 
{
	public static int  CountAndSort(int arr[],int si,int ei)
	{
		int count=0;
		if(si>=ei)
			return count;
		else
		{
			int mid=(ei+si)/2;
			count +=CountAndSort(arr,si,mid);
			count +=CountAndSort(arr,mid+1,ei);
			count +=MergeAndSort(arr,si,mid,ei);
		}
		return count;
	}
	public static int MergeAndSort(int arr[],int si,int mid,int ei)
	{
		int count=0;
		int merged[]=new int [ei-si+1];
		int idx1=si;
		int idx2=mid+1;
		int x=0;
		while(idx1<=mid && idx2<=ei)
		{
			if(arr[idx1]<=arr[idx2])
				merged[x++]=arr[idx1++];
			else
			{
				count += (mid - idx1 + 1);
				merged[x++]=arr[idx2++];
			}
		}
		while(idx1<=mid)
		{
			merged[x++]=arr[idx1++];
		}
		while(idx2<=ei)
		{
			merged[x++]=arr[idx2++];
		}
		for(int i=0,j=si;i<merged.length;i++,j++)
		{
			arr[j]=merged[i];
		}
		
		return count;
	}

	public static void main(String[] args) 
	{
		int arr[]= {6,3,9,5,2,8};
		System.out.println("Before sorting :");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"   ");
		}
		System.out.println();
		int res=CountAndSort(arr,0,arr.length-1);
		System.out.println("After sorting :");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"   ");
		}
		System.out.println();
		System.out.println("no of inversions : "+res);

	}

}

