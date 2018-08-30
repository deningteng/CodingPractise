package test.toutiao2018;

/*
1. 一个球场C的球迷看台可容纳M*N个球迷。官方想统计一共有多少球迷群体，最大的球迷群体有多少人。
球迷选座特性：
1.同球迷群体会选择相邻座位，不同球迷群体选择不相邻的座位。（相邻包括前后相邻、左右相邻、斜对角相邻）；
2.给定一个M*N的二位球场，0代表该位置没人，1代表该位置有人，希望输出球队群体个数P,最大的球队群体人数Q。
输入：
第一行，2个数字，M  N，使用英文逗号隔开
接下来M行，每行N个数字，使用英文逗号隔开
10,10
0,0,0,0,0,0,0,0,0,0
0,0,0,1,1,0,1,0,0,0
0,1,0,0,0,0,0,1,0,1
1,0,0,0,0,0,0,0,1,1
0,0,0,1,1,1,0,0,0,1
0,0,0,0,0,0,1,0,1,1
0,1,1,0,0,0,0,0,0,0
0,0,0,1,0,1,0,0,0,0
0,0,1,0,0,1,0,0,0,0
0,1,0,0,0,0,0,0,0,0

输出：
一行 ，2数字，P   Q
*/
import java.util.Scanner;

public class Test01{
	private static int m;
	private static int n;
	private static int p = 0;
	private static int q = 0;
	private static int num = 0;
	private static boolean[][] flag;
	private static int[][] matrix;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String[] strArr = in.nextLine().split(",");
			m = Integer.parseInt(strArr[0]);
			n = Integer.parseInt(strArr[1]);
			matrix = new int[m][n];
			flag = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				String[] strLine = in.nextLine().split(",");
				for (int j = 0; j < n; j++ ) {
					matrix[i][j] = Integer.parseInt(strLine[j]);
				}
			}
			for (int i = 0; i < m; i++ ) {
				for (int j = 0; j < n; j++ ) {
					p += find(i,j);
					if (q < num) {
						q = num;
					}
					num = 0;
				}
			}
			System.out.println(p+","+q);
		}
	}

	private static int find(int i,int j){
		if (matrix[i][j] == 1 && !flag[i][j]) {
			num++;
			flag[i][j] = true;
			if (i < m - 1 && !flag[i+1][j] && matrix[i+1][j] == 1) {
				find(i+1,j);
			}
			else if (j < n -1 && !flag[i][j+1] && matrix[i][j+1] == 1) {
				find(i,j+1);
			}
			else if (i < m -1 && j < n - 1 && !flag[i+1][j+1] && matrix[i+1][j+1] == 1) {
				find(i+1,j+1);
			}
			else if (i > 0  && !flag[i-1][j] && matrix[i-1][j] == 1) {
				find(i-1,j);
			}
			else if(j > 0 && !flag[i][j-1] && matrix[i][j-1] == 1){
				find(i,j-1);
			}
			else if(i > 0 && j > 0 && !flag[i-1][j-1] && matrix[i-1][j-1] == 1){
				find(i-1,j-1);
			}
			else if(i > 0 && j < n -1 && !flag[i-1][j+1] && matrix[i-1][j+1] == 1){
				find(i-1,j+1);
			}
			else if (i < m -1 && j > 0 && !flag[i+1][j-1] && matrix[i+1][j-1] == 1) {
				find(i+1,j-1);
			}
			else{

			}

			return 1;
		}
		else{
			flag[i][j] = true;
			return 0;
		}
	}
}