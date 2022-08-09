https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

import java.util.*;
public class Solution
{
public static int findMinimumCoins(int amount)
    {
        // Write your code here.
    
    int coins[] = {1000,500,100,50,20,10,5,2,1};
    ArrayList<Integer>res = new ArrayList<Integer>();
    for(int i =0; i<coins.length; i++)
    {
        while(coins[i] <= amount)
        {
            amount -= coins[i];
            res.add(coins[i]);
        }
    }
    
    return res.size();
    
    }
}

