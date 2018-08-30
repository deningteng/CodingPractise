package test.toutiao2018;
import java.util.Scanner;

public class Test01V2{

	private static int m;
	private static int n;
	private static int[][] matrix;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String[] strLine = in.nextLine().split(",");
			int m = Integer.parseInt(strLine[0]);
			int n = Integer.parseInt(strLine[1]);
			matrix = new int[m][n];
			for (int i = 0; i<m; i++ ) {
				String[] strArr = in.nextLine().split(",");				
				for (int j = 0; j < n; j++ ) {
					matrix[i][j] = Integer.parseInt(strArr[j]);
				}
			}
			resolve();

		}
	}

	private static void resolve(){
		int p = 0;
		int q = 0;
		for (int i = 0; i<m; i++ ) {		
			for (int j = 0; j < n; j++ ) {
				if(matrix[i][j] == 0) continue;
				int temp = find(i,j);
				p++;
				if (q < temp) q = temp;
			}
		}
		System.out.println(p+","+q);
	}

	private static int find(int i, int j){
		if(i < 0 || j < 0 || i >= m || j >= n) return 0;
		if(matrix[i][j] == 0) return 0;
		matrix[i][j] = 0;
		return 1 + find(i-1,j-1) + find(i-1,j) + find(i-1,j+1) 
		+ find(i,j-1) + find(i,j+1) + find(i+1,j-1) + find(i+1,j) + find(i+1,j+1);
	}
}