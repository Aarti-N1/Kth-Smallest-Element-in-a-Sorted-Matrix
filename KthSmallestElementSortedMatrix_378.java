package medium;

public class KthSmallestElementSortedMatrix_378 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{ 1,  5,  9},
		        { 10, 11, 13},
		        { 12, 13, 15}
		        };
		int k = 8;
		int res = kthSmallest(matrix, k);
		
	}
	    public static int kthSmallest(int[][] matrix, int k) {
	        int i=0, res= -1;
	        while(i<k){
	            res = matrix[0][0]; //extract min
	            //System.out.println(res);
	            matrix[0][0] = Integer.MAX_VALUE;
	            heapify(matrix,0,0);
	            i++;
	        }
	        return res;
	    }
	    public static void heapify(int[][] matrix, int row, int col){
	        if(row+1> matrix.length || col+1> matrix.length)
	            return;
	        if(row+1 < matrix.length && 
	           col+1 < matrix.length && 
	           matrix[row][col]<= matrix[row+1][col] && matrix[row][col]<= matrix[row][col+1])
	            return;
	        if(row+1 < matrix.length && 
	           col+1 < matrix.length &&
	           matrix[row][col]> matrix[row+1][col] && matrix[row][col]> matrix[row][col+1]){
	            if(matrix[row+1][col] <= matrix[row][col+1]){
	                int temp = matrix[row][col];
	                matrix[row][col] = matrix[row+1][col];
	                matrix[row+1][col] = temp;
	                heapify(matrix,row+1,col);
	            }else{
	                int temp = matrix[row][col];
	                matrix[row][col] = matrix[row][col+1];
	                matrix[row][col+1] = temp;
	                heapify(matrix,row,col+1);
	            }
	            
	        }else if(row+1 < matrix.length && matrix[row][col]>matrix[row+1][col]){
	            int temp = matrix[row][col];
	            matrix[row][col] = matrix[row+1][col];
	            matrix[row+1][col] = temp;
	            heapify(matrix,row+1,col);
	        }else  if(col+1 < matrix.length) {
	            int temp = matrix[row][col];
	            matrix[row][col] = matrix[row][col+1];
	            matrix[row][col+1] = temp;
	            heapify(matrix,row,col+1);
	        }
	    }
	
}
