package com.mainul;

public class Problem14 {

	public long getCycle(long n)
	{
		long seq = 0;
		
		while(n>1)
		{
			n = (n%2==0)?(n/2):((3*n)+1);
			seq++;
		}
		
		return seq;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		long maxSeq = 0;
		Problem14 p14 = new Problem14();
		for (long i = 2; i < 1000000; i++)
		{
			long cycle = p14.getCycle(i);
			if (cycle > maxSeq)
			{
				maxSeq = cycle;
				System.out.println("Number :: "+i+" Cycle::"+cycle);
			}
		}

	}

}
