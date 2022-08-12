https://leetcode.com/problems/permutation-sequence/submissions/

class Solution {
    public String getPermutation(int n, int k) {
        
        String s = "";
        int c = 1;
        for(int i =0; i<n; i++)
        {
            s += c;
            c++;       
        }           
    boolean flag[] = new boolean[n];
    Arrays.fill(flag,false);
        
    int [] z = new int[1]; 
    ArrayList<Character>res = new ArrayList<Character>();
    
    getPermutationHelper(s,flag,new ArrayList<Character>(),res,k,z);
        
        String ans = "";      
        for(int i =0; i<res.size(); i++)
        {
            ans+= res.get(i);
        }
    return ans;
    
    }
    
public void getPermutationHelper(String s,boolean[] flag,ArrayList<Character>ds,ArrayList<Character> res,int k,int z[])
    {
        if(ds.size() == s.length())
        {      
            z[0]++;   
            if(z[0] == k)
            {
                
                for(int i =0; i<ds.size(); i++)
                    res.add(ds.get(i));
                          
            }
            return;        
        }  
        for(int i =0; i<s.length(); i++)
        {
            if(flag[i] == true)
                continue;
            else
            {
                flag[i] = true;
                ds.add(s.charAt(i));
                getPermutationHelper(s,flag,ds,res,k,z);
                ds.remove(ds.size() - 1);
                flag[i] = false;
            }
        }
    }
}
