https://leetcode.com/problems/merge-sorted-array/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i =0;
        int j =0;
        int temp [] = new int[m+n];
        
        int k =0;
        
        while(i<m && j<n)
        {
            if(nums1[i]<=nums2[j])
            {
                temp[k] = nums1[i];
                i++;
                k++;
            }
            
            else
            {
                temp[k] = nums2[j];
                k++;
                j++;
            }
        }
        
        while(i<m)
        {
            temp[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j<n)
        {
            temp[k] = nums2[j];
            j++;
            k++;
        }
        
        for(int x =0; x<n+m; x++)
            nums1[x] = temp[x];
    }
  
  // second soln better tc and without using extra space
  
   int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i>=0 && j>=0)
        {
            if(nums1[i] >= nums2[j])
            {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
            
            else{
                nums1[k] = nums2[j];
                j--;
                k--;
                
            }
        }
        
        while(i>=0)
        {
            nums1[k] = nums1[i];
            k--;
            i--;
        }
        
        while(j>=0)
        {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
}
