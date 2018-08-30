/*
小a和小b玩一个游戏，有n张卡牌，每张上面有两个正整数x，y。
取一张牌时，个人积分增加x，团队积分增加y。
求小a，小b各取若干张牌，使得他们的个人积分相等，且团队积分最大。

输入描述：
第一行n
接下来n行，每行两个正整数x，y
输出描述：
一行一个整数
表示小a的积分和小b的积分相等时，团队积分的最大值
例：输入
4
3 1
2 2
1 4
1 4
输出：10
说明：当a抽取（2,2），b抽取（1,4），（1,4）时，两人个人积分都是2，团队积分最大，为10分

*/
package test.toutiao2018;
import java.util.Scanner;

public class Test03{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int num = in.nextInt();
			int[] key = new int[num];
			int[] value = new int[num];
			int max = 0;
			for (int i = 0; i < num ; i++ ) {
				key[i] = in.nextInt();
				value[i] = in.nextInt();
				max = key[i]>max?key[i]:max;
			}
			int[][] matrix = new int[num+1][max+1];
			matrix[1][key[0]] = value[0];
			for(int i = 2; i < num+1; i++){
				for(int j = 0; j < max+1; j++){
					int t1 = 0;
					int t2 = 0;
					if(j - key[i-1] >= 0) t1 = matrix[i-1][j-key[i-1]] + value[i-1];
					if(j + key[i-1] <= max) t2 = matrix[i-1][j+key[i-1]] + value[i-1];
					matrix[i][j] = Math.max(Math.max(t1,t2),matrix[i-1][j]);
				}
			}
			System.out.println(matrix[num][0]);
		}
	}
}