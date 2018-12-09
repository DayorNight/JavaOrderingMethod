package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.chart.PieChart.Data;


/**
 * 	Method.java
 * 	常见八大排序方法
 */
public class Method {
	/**
	 * 1、冒泡排序
	 * 比较相邻的元素，如果前一个比后一个大，就把他们两个调换位置对每一对相邻元素作同样的工作，
	 * 从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。针对所有的元素重复以上的步骤
	 * 除了最后一个。持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 */
	public static void order1(int[] a) {
		syso(a, false);
		for(int x=0;x<a.length-1;x++) {
			for (int y = 0; y < a.length-1-x; y++) {
				if(a[y]>a[y+1]) {
					int t = a[y];
					a[y] = a[y+1];
					a[y+1] = t;
				}
			}
		}
		syso(a, true);
	}
	
	/**
	 * 2、选择排序
	 * 初始时在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列
	 * 然后，再从剩余未排序元素中继续寻找最小（大）元素
	 * 放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
	 */
	public static void order2(int[] a) {
		syso(a, false);
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		syso(a, true);
	}
	
	/**
	 * 3、插入排序
	 */
	public static void order3(int[] a) {
		syso(a, false);
		for (int i = 1; i < a.length; i++) {
			int get = a[i];
			int j = i-1;
			while (j >= 0 && a[j] > get) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = get;
		}
		syso(a, true);
	}
	
	/**
	 * 4、归并排序
	 */
	public static void order4(int[] a) {
		syso(a, false);
		sort(a,0,a.length-1);
		syso(a, true);
	}
	public static void sort(int[] data,int left,int right) {
		if(left >= right) return;
		//找出中间索引
		int center = (left + right)/2;
		//对左边数组进行递归
		sort(data, left, center);
		//对右边数组进行递归
		sort(data, center+1, right);
		//合并
		merge(data,left,center,right);
	}
	public static void merge(int[] data,int left, int center,int right) {
		//临时数组
		int[] tmpArr = new int[data.length];
		//右数组第一个元素索引
		int mid = center + 1;
		//third 记录临时数组的索引
		int third = left;
		//缓存左数组第一个元素的索引
		int tmp = left;
		while (left <= center && mid <=right) {
			//从两个数组中取出最小的放入临时数组
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		//剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
		while(mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while(left <= center) {
			tmpArr[third++] = data[left++];
		}
		//将临时数组中的内容拷贝回原数组中
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	}
	
	/**
	 * 5、快速排序
	 */
	public static void order5(int[] a) {
		syso(a, false);
		quickSort(a,0,a.length-1);
		syso(a, true);
	}
	private static void quickSort(int[] a, int left, int right) {
		if(left < right) {
			int i = getMiddle(a,left,right);
			quickSort(a, left, i - 1);
			quickSort(a, i + 1,right);
		}
	}
	private static int getMiddle(int[] a, int low, int high) {
		int pivot = a[low];
		int i = low;
		int j = high;
		while(i < j) {
			while(pivot <= a[j] && i < j) j--;
			while(pivot >= a[i] && i < j) i++;
			if(i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		a[low] = a[i];
		a[i] = pivot;
		return i;
	}

	/**
	 * 6、希尔排序
	 */
	public static void order6(int[] a) {
		syso(a, false);
		int len = a.length;//单独把数组长度拿出来，提高效率。
		while(len != 0) {
			len = len/2;
			for (int i = 0; i < len; i++) {//分组
				for (int j = i + 1; j < a.length; j+=len) {//元素从第二个开始
					int k = j - len;//k为有序序列最后一位的位数
					int temp = a[j];//要插入的元素
					while (k >= 0 && temp < a[k]) {//从后往前遍历
						a[k + len] = a[k];
						k -= len;//向后移动len位
					}
					a[k + len] = temp;
				}
			}
		}
		syso(a, true);
	}
	
	/**
	 * 7、基数排序
	 */
	public static void order7(int[] a) {
		syso(a, false);
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		int time = 0;
		while (max > 0) {
			max /= 10;
			time++;
		}
		List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		for (int i = 0; i < time; i++) {
			for (int j = 0; j < a.length; j++) {
				int x = a[j] % (int) Math.pow(10, i+1)/(int)Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(a[j]);
				queue.set(x, queue2);
			}
			int count = 0;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size()>0) {
					ArrayList<Integer> queue3 = queue.get(k);
					a[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
		syso(a, true);
	}
	
	/**
	 * 8、堆排序
	 */
	public static void order8(int[] a) {
		syso(a, false);
		int len = a.length;
		for (int i = 0; i < len - 1; i++) {
			buildMaxHeap(a,len - 1 - i);
			swap(a,0,len - 1 - i);
		}
		syso(a, true);
	}
	private static void buildMaxHeap(int[] data, int lastIndex) {
		//从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1)/2; i >= 0; i--) {
			//k保存正在判断的节点
			int k = i ;
			//如果当前K节点的子节点存在
			while(k * 2 + 1 <= lastIndex) {
				//k节点的左子节点的索引
				int biggerIndex = 2 * k +1;
				//如果biggerIndex小于lastIndex,即biggerIndex +1代表的K节点的右子节点存在
				if(biggerIndex < lastIndex) {
					//如果右子节点的值较大
					if(data[biggerIndex] < data[biggerIndex + 1]) {
						biggerIndex++;
					}
				}
				//如果K节点的值小于其较大的子节点的值
				if(data[k] < data[biggerIndex]) {
					//交换他们
					swap(data, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	/**
	 * 显示数组列表
	 * @param a
	 * @param isSort
	 */
	public static void syso(int[] a,boolean isSort) {
		if(isSort) {
			System.out.println("\n排序后");
		}else {
			System.out.println("\n排序前");
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
