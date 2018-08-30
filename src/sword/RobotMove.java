/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
*/
package sword;
import java.util.Scanner;

public class RobotMove{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int m = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] matrix = new int[m][n];
			int num = move(0,0,m,n,matrix,k);
			System.out.println(num);
		
		}
	}
	private static int move(int i,int j,int m,int n,int[][] matrix,int k){
		if(i<0||j<0||i>=m||j>=n||matrix[i][j]==1||numSum(i)+numSum(j)>k) return 0;
		matrix[i][j] = 1;
		return 1+move(i+1,j,m,n,matrix,k)+move(i-1,j,m,n,matrix,k)
			+move(i,j+1,m,n,matrix,k)+move(i,j-1,m,n,matrix,k);
	}
	
	private static int numSum(int num){
		int sum = 0;
		while(num>0){
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
}