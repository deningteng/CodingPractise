package test.toutiao2018;
/*
两个长度为n的序列a，b。
问有多少个区间[l，r]满足max(a[l,r])<min(b[l,r])
即a区间的最大值小于b区间的最小值。
数据范围：n<1e5，a(i),b(i)<1e9

输入描述：
第一行一个整数n
第二行n个数，第i个为a(i)
第三行n个数，第i个为b(i)
0<1<=r<n
输出描述：
一行一个整数，表示答案

例1：输入
3
3 2 1
3 3 3
输出： 3
*/
import java.util.Scanner;

public class Test04{
	public static void main(String[] ars){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int num = in.nextInt();
			int[] a = new int[num];
			int[] b = new int[num];
			for (int i = 0; i < num*2; i++) {
				if(i < num)
					a[i] = in.nextInt();
				else
					b[i-num] = in.nextInt();
			}
			System.out.println(find(a,b,0,0,num));
		}
	}

	private static int find(int[] a, int[] b, int begin, int end, int num){
		if(begin > end || end >= num) return 0;
		int max = max(a,begin,end);
		int min = max(b,begin,end);
		if(max >= min) return find(a,b,begin+1,begin+1,num);
		return 1 + (end == num-1?find(a,b,begin+1,begin+1,num):find(a,b,begin,end+1,num,max,min));
	}

	private static int find(int[] a, int[] b, int begin, int end, int num,int max,int min){
		if(begin > end || end >= num) return 0;
		max = a[end]>max?a[end]:max;
		min = b[end]<min?b[end]:min;
		if(max >= min) return find(a,b,begin+1,begin+1,num);
		return 1 + (end == num-1?find(a,b,begin+1,begin+1,num):find(a,b,begin,end+1,num,max,min));
	}

	private static int max(int[] arr, int begin, int end){
		int max = Integer.MAX_VALUE;
		for(int i = begin; i < end; i++){
			max = max<arr[i]?arr[i]:max;
		}
		return max;
	}

	private static int min(int[] arr, int begin, int end){
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < end; i++) {
			min = min>arr[i]?arr[i]:min;
		}
		return min;
	}

}