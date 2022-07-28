package javaCode;

import java.util.*;


public class CollectionSort {

    /*
     * Complete the 'getResult' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY employees as parameter.
     */
	
	public static void main(String arg[])
	{
		List<String> testData = new ArrayList<String>();
		testData.add("test,indore,job");
		getResult(testData);
	}

    public static int getResult(List<String> employees) {
      int count = 0;
      for(int i=1;i<employees.size();i++)
      {
          String[] numbrOfCommas = employees.get(i).split(",");
          if(numbrOfCommas.length!=2)
          {
        	  System.out.println("invalid format of string");
           //   break;

          }
          
      }
      String operation =  employees.get(0);
      if(operation.equals("1,"))
      {
          List<Integer> result = new ArrayList<Integer>();
          for(int i=1;i<employees.size();i++)
          {
              result.add(Integer.parseInt(employees.get(i).substring(employees.lastIndexOf(","))));
          }
          Collections.sort(result);
          count = result.get(result.size()-1);
      }
      else if(operation.contains("2,") || operation.contains("3,"))
      {
          String item =  operation.substring(operation.lastIndexOf(",")+1);
          for(int i=1;i<employees.size();i++)
          {
            if(employees.get(i).contains(item))
            {
                count=count+1;
            }
          }
      }
      return count;
    }

}

