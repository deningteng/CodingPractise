/*
小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。

现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。
注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。

输入描述:
第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。


输出描述:
第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。

输入例子1:
3 2
5 8 5

输出例子1:
0 2
2 1
2 3
*/
package test.wangyi2018;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class Test06{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];

			for(int i=0; i<n; i++){
				arr[i] = in.nextInt();
			}
			ArrayList<Integer> x = new ArrayList<Integer>();
			ArrayList<Integer> y = new ArrayList<Integer>();
			HashMap<String,Integer> map = findMaxMin(arr);

			for (int i=0; i<k; i++) {
				
				int maxIndex = map.get("maxIndex");
				int minIndex = map.get("minIndex");
				if (arr[maxIndex]-arr[minIndex]>1) {
					arr[maxIndex] -= 1;
					arr[minIndex] += 1;
					x.add(maxIndex);
					y.add(minIndex);	
				}
				if(arr[maxIndex]-arr[minIndex]<=1||i==k-1){
					System.out.println(arr[maxIndex]-arr[minIndex]+" "+(i+1));
					break;
				}
			}
			for (int i=0; i<x.size(); i++) {
					System.out.println(x.get(i)+" "+y.get(i));
			}

		}
	}
	private static HashMap<String,Integer> findMaxMin(int[] arr){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxIndex = -1;
		int minIndex = -1;

		for (int i=0; i<arr.length; i++){
			if (max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
			if(min > arr[i]){
				min = arr[i];
				minIndex = i;
			}
		}

		map.put("maxIndex",maxIndex);
		map.put("minIndex",minIndex);

		return map;
	}
}