package com.mainul;

import java.io.FileReader;
import java.util.LinkedList;

public class Problem22 {

	private LinkedList <NameList>nameList;
	
	public Problem22()
	{
		nameList = new LinkedList<NameList>();
	}
	
	public void addName(NameList name)
	{
		NameList firstName, lastName;
		int size = 0;
		
		try
		{
			size = nameList.size();
		}
		catch(NullPointerException npe)
		{
			
		}
		if (size == 0)
		{
			nameList.add(name);
			return;
		}
		
		firstName = nameList.getFirst();
		lastName = nameList.getLast();
		
		
		if (firstName.name.compareTo(name.name)> 0)
			nameList.addFirst(name);
		else if (name.name.compareTo(lastName.name) > 0)
			nameList.addLast(name);
		else
		{
			for (int i=1; i < size-1; i++)
			{
				if ((name.name.compareTo(nameList.get(i).name) > 0) && 
						(nameList.get(i+1).name.compareTo(name.name) > 0))
				{
					nameList.add(i+1, name);
					break;
				}
				else if(name.name.compareTo(nameList.get(i).name) == 0)
				{
					nameList.add(i+1, name);
					break;
				}
				
			}
			
		}
		
	}
	
	public void printList()
	{
		int size = nameList.size();
		long sum = 0;
		
		for (int i=0; i < size; i++)
		{
			System.out.println(nameList.get(i).name + " "+nameList.get(i).nameVal+" "+i);
			sum = sum + nameList.get(i).nameVal * (i+1);
		}
		
		System.out.println(sum);
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Problem22 p22 = new Problem22();
		FileReader inputStream = null;
		try
		{
			inputStream = new FileReader("D:\\Projects\\p022_names.txt");
			int c;
			StringBuffer sb = new StringBuffer("");
			while ((c = inputStream.read()) != -1)
			{
				if ((char)c != '"' && (char)c!=',')
				{
					sb.append((char)c);
					
				}
				else if((char)c == ',')
				{
					NameList n = new NameList();
					n.name = sb.toString();
					n.setNameval();
					p22.addName(n);
					sb = new StringBuffer("");
					//System.out.println(n.name);
				
				}
			}
			
			NameList n = new NameList();
			n.name = sb.toString();
			n.setNameval();
			p22.addName(n);
			
			inputStream.close();
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();;
		}
		
		p22.printList();
		

	}

}
