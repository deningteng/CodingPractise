/*
今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，
但是如果一个运算加了括号，那么它的优先级是最高的。例如：
1
2
3
4
1+2*3=7
1*(2+3)=5
1*2*3=6
(1+2)*3=9
现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
*/
package test.wangyi2018;
import java.util.Scanner;

public class Test05{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int max = Math.max(a+b*c,a*(b+c));
			max = Math.max(max,a*b*c);
			max = Math.max(max,(a+b)*c);
			System.out.println(max);
		}
	}
}