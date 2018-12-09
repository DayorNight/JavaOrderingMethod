package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.chart.PieChart.Data;


/**
 * 	Method.java
 * 	�����˴����򷽷�
 */
public class Method {
	/**
	 * 1��ð������
	 * �Ƚ����ڵ�Ԫ�أ����ǰһ���Ⱥ�һ���󣬾Ͱ�������������λ�ö�ÿһ������Ԫ����ͬ���Ĺ�����
	 * �ӿ�ʼ��һ�Ե���β�����һ�ԡ��ⲽ���������Ԫ�ػ�����������������е�Ԫ���ظ����ϵĲ���
	 * �������һ��������ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
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
	 * 2��ѡ������
	 * ��ʼʱ���������ҵ���С����Ԫ�أ��ŵ����е���ʼλ����Ϊ����������
	 * Ȼ���ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ��
	 * �ŵ����������е�ĩβ���Դ����ƣ�ֱ������Ԫ�ؾ��������
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
	 * 3����������
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
	 * 4���鲢����
	 */
	public static void order4(int[] a) {
		syso(a, false);
		sort(a,0,a.length-1);
		syso(a, true);
	}
	public static void sort(int[] data,int left,int right) {
		if(left >= right) return;
		//�ҳ��м�����
		int center = (left + right)/2;
		//�����������еݹ�
		sort(data, left, center);
		//���ұ�������еݹ�
		sort(data, center+1, right);
		//�ϲ�
		merge(data,left,center,right);
	}
	public static void merge(int[] data,int left, int center,int right) {
		//��ʱ����
		int[] tmpArr = new int[data.length];
		//�������һ��Ԫ������
		int mid = center + 1;
		//third ��¼��ʱ���������
		int third = left;
		//�����������һ��Ԫ�ص�����
		int tmp = left;
		while (left <= center && mid <=right) {
			//������������ȡ����С�ķ�����ʱ����
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		//ʣ�ಿ�����η�����ʱ���飨ʵ��������whileֻ��ִ������һ����
		while(mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while(left <= center) {
			tmpArr[third++] = data[left++];
		}
		//����ʱ�����е����ݿ�����ԭ������
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	}
	
	/**
	 * 5����������
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
	 * 6��ϣ������
	 */
	public static void order6(int[] a) {
		syso(a, false);
		int len = a.length;//���������鳤���ó��������Ч�ʡ�
		while(len != 0) {
			len = len/2;
			for (int i = 0; i < len; i++) {//����
				for (int j = i + 1; j < a.length; j+=len) {//Ԫ�شӵڶ�����ʼ
					int k = j - len;//kΪ�����������һλ��λ��
					int temp = a[j];//Ҫ�����Ԫ��
					while (k >= 0 && temp < a[k]) {//�Ӻ���ǰ����
						a[k + len] = a[k];
						k -= len;//����ƶ�lenλ
					}
					a[k + len] = temp;
				}
			}
		}
		syso(a, true);
	}
	
	/**
	 * 7����������
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
	 * 8��������
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
		//��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
		for (int i = (lastIndex - 1)/2; i >= 0; i--) {
			//k���������жϵĽڵ�
			int k = i ;
			//�����ǰK�ڵ���ӽڵ����
			while(k * 2 + 1 <= lastIndex) {
				//k�ڵ�����ӽڵ������
				int biggerIndex = 2 * k +1;
				//���biggerIndexС��lastIndex,��biggerIndex +1�����K�ڵ�����ӽڵ����
				if(biggerIndex < lastIndex) {
					//������ӽڵ��ֵ�ϴ�
					if(data[biggerIndex] < data[biggerIndex + 1]) {
						biggerIndex++;
					}
				}
				//���K�ڵ��ֵС����ϴ���ӽڵ��ֵ
				if(data[k] < data[biggerIndex]) {
					//��������
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
	 * ��ʾ�����б�
	 * @param a
	 * @param isSort
	 */
	public static void syso(int[] a,boolean isSort) {
		if(isSort) {
			System.out.println("\n�����");
		}else {
			System.out.println("\n����ǰ");
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
