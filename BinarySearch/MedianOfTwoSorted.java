https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result=0;
        
        int n1=nums1.length;
        int n2=nums2.length;
    
        
        int temp[]=new int [n1+n2];
        int templength=temp.length;
        int i=0, j=0, k=0;
        
        while(i<n1 && j<n2)
        {
            if(nums1[i]<=nums2[j])
            {
                temp[k]=nums1[i];
                i++;
                k++;
            }
            
            else if(nums1[i]>nums2[j])
            {
                temp[k]=nums2[j];
                j++;
                k++;
            }
            
          
        }
        
        while(i<n1)
        {
            temp[k]=nums1[i];
            i++;
            k++;
            
        }
        while(j<n2)
        {
            temp[k]=nums2[j];
            j++;
            k++;
            
        }
        
        if(temp.length % 2!=0)
           result = temp[templength/2];
        
        
       else{
           result=(temp[templength/2]+temp[templength/2-1]) /2.0 ;
       }
        
        return result;
        
    }
}
