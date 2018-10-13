package CodeJamPractice;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;

public class SaveWorld {
    
    static int noc,Q,S;
    static String[] searchEngines,queries;
    
    
    public static int noOfSwitch(String[] paramServer, String[] paramQueries) {
       
         searchEngines = paramServer;
            queries = paramQueries;
            S = searchEngines.length;
            Q = queries.length;
            
            int res = 0;
            int j;
            j = 0;
            while (j < Q) {
                int currEngine = getFinalQuery(j);
                while (j < Q && queries[j].compareTo(searchEngines[currEngine])!=0) j++;
                if (j < Q) res++;
            }
          
          return res;
    }
    
     public static int getFinalQuery(int x) 
     {
            boolean[] engines = new boolean[S];
            int last = x, i, ind,k;
            for (i = x; i < Q; i++) 
            {
                for(k=0;k<S;k++)
                {
                    if(searchEngines[k].equalsIgnoreCase(queries[i]))
                        break;
                }
                
                if (!engines[k]) 
                {
                    engines[k] = true;
                    last = k;
                }
            }
            for (i = 0; i < S; i++) 
	    {
		if (!engines[i]) 
			return i;
            }
            return last;
        }
    
    public static void main(String[] args) throws Exception
   {
    	File inputFile = new File("C:\\Users\\antany\\Downloads\\A-small-practice.in");
		BufferedReader inputs = new BufferedReader(new FileReader(inputFile));
        noc=Integer.parseInt(inputs.readLine());
        for(int i=0;i<noc;i++)
        {
            
            S=Integer.parseInt(inputs.readLine());
            searchEngines=new String[S];
            for(int j=0;j<S;j++)
                           searchEngines[j]=inputs.readLine();
                      
            Q=Integer.parseInt(inputs.readLine());
            queries=new String[Q];
            for(int j=0;j<Q;j++)
                            queries[j]=inputs.readLine();
            
            System.out.println("Case #" + (i+1) + ": " + noOfSwitch(searchEngines, queries));
        }
        
        
        
    }
    
}

