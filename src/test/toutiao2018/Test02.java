/*
题目描述：
    为了提高文章质量，每一篇文章（假设全部都是英文）都会有m名编辑审核，每个编辑独立工作，会把觉得有问题的句子通过下标记录下来，
    比如［1，10］，1表示病句的第一个字符，10表示病句的最后一个字符。也就是从1到10个字符组成的句子，是有问题的。
    现在需要把多名编辑有问题的句子合并起来，送给总编辑进行最终的审核。比如编辑a指出的病句是［1，10］，［32，45］；
    b编辑指出的病句是［5，16］，［78，94］，那么［1，10］和［5，16］是有交叉的，可以合并成［1，16］，［32，45］，78，94］
输入描述：
    编辑数量m，之后每行是每个编辑的标记的下标集合，第一个和最后一个下标用英文逗号分隔，每组下标之间用分号分隔
输出描述：
    合并后的下标集合，第一个和最后一个下标用英文逗号分隔，每组下标之间用分号分隔。返回结果是从小到大的递增排列。
输入：
 
3
1,10;32,45
78,94;5,16
80,100;200,220;16,32
    输出：
 
    1,45;78,100;200,220
*/
package test.toutiao2018;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Test02{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = Integer.parseInt(in.nextLine());
			List<Interval> intervalList = new ArrayList<Interval>();
			for (int i = 0; i < num; i++) {
				String[] pairArr = in.nextLine().split(";");
				for (int j = 0; j < pairArr.length; j++) {
					String[] strLine = pairArr[j].split(",");
					int begin = Integer.parseInt(strLine[0]);
					int end = Integer.parseInt(strLine[1]);
					Interval interval = new Interval(begin,end);
					intervalList.add(interval);
				}
			}
			Collections.sort(intervalList);
			Interval pre = null;
			List<Interval> result = new ArrayList<Interval>();

			for(Interval interval: intervalList){
				if(pre == null || pre.getEnd() < interval.getBegin()){
					result.add(interval);
					pre = interval;
				}
				else if(pre.getEnd() < interval.getEnd()){
					pre.setEnd(interval.getEnd());
				}
			}
			for(int i = 0; i < result.size(); i++){
				System.out.print(result.get(i).toString());
				if(i != result.size() - 1) 
					System.out.print(";");
			}
		}
	}
}

class Interval implements Comparable<Interval>{
	private int begin;
	private int end;
	public Interval(int begin, int end){
		this.begin = begin;
		this.end = end;
	}
	public void setBegin(int begin){
		this.begin = begin;
	}
	public void setEnd(int end){
		this.end = end;
	}
	public int getBegin(){
		return begin;
	}
	public int getEnd(){
		return end;
	}
	public void print(){
		System.out.print(begin+","+end);
	}

	@Override
	public int compareTo(Interval i1){
		
		return getBegin() - i1.getBegin();
	}

	public String toString(){
		return begin + "," + end;
	}

}