package javaCode;




class MaxAndMinIntegerInString {
    public static String highAndLow(String numbers) {
        
        String[] nums = numbers.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int [] intNumbers = new int [nums.length];
        for(int i=0; i<intNumbers.length; i++) {
        	intNumbers[i] = Integer.parseInt(nums[i]);
        }
        
        
        for(int i=0; i<intNumbers.length; i++)
        {
        	if(intNumbers[i]>max)
        	{
        		max=intNumbers[i];
        	}
        	if(intNumbers[i]<min)
        	{
        		min=intNumbers[i];
        	}
        }
        
        String output = String.valueOf(max)+" "+ String.valueOf(min);
        		
        return output;
    }
    
    public static void main(String arg[])
    {
    	String maxAndMin = highAndLow("3 7 -4 2 0");
    	System.out.println("maxAndMin " + maxAndMin);
    }
}

