import java.util.Random;

public class Driver
{
	public static void main(String[] args) 
	{
		Player[] playerList = new Player[100];
		for(int i = 0; i < playerList.length; i++)
		{
			Random r = new Random();
			playerList[i] = new Player("Player" + i, r.nextInt(1000));
		}
		int age = 4;
		mergeSort(playerList, 0, playerList.length - 1);
		boolean isFound = Driver.binarySearch(playerList, age);
		if(isFound)
		{
			for(int i = playerList.length - 1; i > -1; i--)
			{
				if(age == playerList[i].getAge())
				{
					playerList[i].display();
				}
			}
		}
		else
		{
			System.out.println("There is no player of age " + age);
		}
	}
	
	public static boolean binarySearch(Player[] ar, int searchFor)
	{
		int begin = 0;
		int end = ar.length - 1;
		int middle = (end + begin) / 2;
		
		while(ar[middle].getAge() != searchFor && begin <= end)
		{
			middle = (end + begin) / 2;
			if(searchFor < ar[middle].getAge())
			{
				end = middle - 1;
			}
			else if(searchFor > ar[middle].getAge())
			{
				begin = middle + 1;
			}
		}
		if(ar[middle].getAge() == searchFor)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	static void mergeSort(Player[] ar, int begin, int end)
	{
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin + ((end - begin)/2);
			int begin2 = end1 + 1;
			int end2 = end;
			mergeSort(ar, begin1, end1);
			mergeSort(ar, begin2, end2);
			merge(ar, begin1, end1, begin2, end2);
		}
	}
	
	static void merge(Player[] ar, int begin1, int end1, int begin2, int end2)
	{
		Player[] temp = new Player[end2 - begin1 + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(ar[pos1].getAge() < ar[pos2].getAge())
				{
					temp[i] = ar[pos1];
					pos1++;
				}
				else
				{
					temp[i] = ar[pos2];
					pos2++;
				}
			}
			else
			{
				if(pos1 > end1)
				{
					temp[i] = ar[pos2];
					pos2++;
				}
				else
				{
					temp[i] = ar[pos1];
					pos1++;
				}
			}
		}
		int posInTemp = 0;
		for(int i = begin1; i <= end2; i++)
		{
			ar[i] = temp[posInTemp];
			posInTemp++;
		}
	}
	
	static void displayPlayerArray(Player[] ar)
	{
		for(int i = 0; i < ar.length; i++)
		{
			ar[i].display();
		}
	}
}