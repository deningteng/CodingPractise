package test.toutiao2018;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/*
小明在抖音里关注了N个主播，每个主播每天的开播时间是固定的，分别在S时刻开始开播，t时间结束。
小明无法同时观看两个主播的直播。一天被分成了M个时间单位。请问小明每天最多能完整观看多少场直播？
输入描述：
第一行一个整数，代表N
第二行一个整数，代表M
第三行空格间隔的N*2个整数，代表s，t
输出描述：
一行一个整数，表示答案
例1：输入
3
10
0 3 3 7 7 0
输出：3
例2： 输入
3
10
0 5 2 7 6 9
输出：2
备注：数据范围1<=N<=10^5
2<=M<=10^6
0<=s(i),t(i)<M (s(i)!=t(i))
s(i)>t(i)代表时间跨天，但直播时长不会超过一天
*/
public class Test05{
	public static void main(){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int n = in.nextInt();
			int m = in.nextInt();
			List<Intervals> intervalArr = new ArrayList<Intervals>();

			for (int i = 0; i < n*2; i++) {
				intervalArr.add(new Intervals(in.nextInt(),in.nextInt()));
			}
			Collections.sort(intervalArr);
			Intervals pre = null;
		}
	}
}
class Intervals implements Comparable<Intervals>{

	private int begin;
	private int end;

	public Intervals(int begin,int end){
		this.begin = begin;
		this.end = end;
	}

	@Override
	public int compareTo(Intervals i1){
		return begin - i1.end;
	}

}




