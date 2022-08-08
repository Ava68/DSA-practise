https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

// Intutuion is clear
// sort acc to val/weight ration and start picking the element and put it into knapsack
// the moment current weight of obj is greater than the weight of knapsack 
// then we take the whatever we can take to knapsack(V * W/w1) and then break


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}


class ItemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a,Item b)
    {
        double r1 = (double)a.value / (double)a.weight;
        double r2 = (double)b.value / (double)b.weight;
        
        if(r1 < r2)
            return 1;
        else if(r1 > r2)
            return -1;
        else
            return 0;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        
        Arrays.sort(arr,new ItemComparator());
        
        double maxProfit = 0.0;
        
        for(int i =0; i<n; i++)
        {
            if(W >= arr[i].weight)
            {
                maxProfit += arr[i].value;
                W = W - arr[i].weight;
            }
            else 
            {
                maxProfit += arr[i].value * (double)W/ (double)arr[i].weight;
                break;
            }
        }
        
        return maxProfit;
    }
}
