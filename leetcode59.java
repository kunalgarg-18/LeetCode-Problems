// Problem: Spiral Matrix II
// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n-1, up = 0, down = n-1;

        int count = 1;
        
        while(count <= n*n){
            //for left to right in up row
            for(int i = left; i <= right && count <= n*n; i++){
                matrix[up][i] = count++;
            }
            //for up to down in right col
            for(int i = up+1; i <= down - 1 && count <= n*n; i++){
                matrix[i][right] = count++;
            }
            //for right to left in down row
            for(int i = right; i >= left && count <= n*n; i--){
                matrix[down][i] = count++;
            }
            //for down to up in left col
            for(int i = down - 1; i >= up+1 && count <= n*n; i--){
                matrix[i][left] = count++;
            }
            left++; right--; down--; up++;
        }
        return matrix;
    }
}
