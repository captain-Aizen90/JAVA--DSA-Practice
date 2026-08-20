public class MergeSort {
    public static void conquer(int[] arr, int si,int mid, int ei) {
        int[] merged = new int[ei-si+1];
        int idx1 = si;//left part starting index
        int idx2 = mid+1;//right part starting index
        int x = 0;//merged array index


        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<=arr[idx2]){
                merged[x++] = arr[idx1++];
            }
            else{
                merged[x++] = arr[idx2++];
            }
            //now if any elements remaining from both the arrays
            while(idx1<=mid){
                merged[x++] = arr[idx1++];
            }
            while(idx2<=ei){
                merged[x++] = arr[idx2++];
            }
            for(int i=0,j=si;i<merged.length;i++,j++){ //for copying elements from the merged array to the original array
                arr[j] = merged[i];
            }
            }
        }
    
    public static void divide(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }
        public static void main(String[] args) {
            int[] arr = { 6,3,9,5,2,8};
            int n = arr.length;
            divide(arr,0,n-1);
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
}
