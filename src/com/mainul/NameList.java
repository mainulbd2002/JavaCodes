package com.mainul;

public class NameList 
{
	public String name;
	public int nameVal;
	
	public void setNameval()
	{
		nameVal = 0;
		int nameLen = name.length();
		
		for (int i=0; i< nameLen; i++)
		{
			nameVal = nameVal + (name.charAt(i) - 'A' + 1);
		}
	}

}
