package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 321.Given two arrays of length m and n with digits 0-9 representing two
 * numbers. Create the maximum number of length k <= m + n from digits of the
 * two. The relative order of the digits from the same array must be preserved.
 * Return an array of the k digits. You should try to optimize your time and
 * space complexity.
 * 
 * Example 1: nums1 = [3, 4, 6, 5] nums2 = [9, 1, 2, 5, 8, 3] k = 5 return [9,
 * 8, 6, 5, 3]
 * 
 * Example 2: nums1 = [6, 7] nums2 = [6, 0, 4] k = 5 return [6, 7, 6, 0, 4]
 * 
 * Example 3: nums1 = [3, 9] nums2 = [8, 9] k = 3 return [9, 8, 9]
 * 
 * @author WANYONGBO
 * @version 1.0 2017��8��8��08:18:52
 */
public class Leet321MaxNumber_03 {
	private int[] n1;
	private int[] n2;
	private int[][] nsum;
	private int k;
	private int[] result;
	private int sumLen;
	private int maxResult;

	/**
	 * 2017��8��7��10:54:38--���û��ݷ�����Ϸ�ȫ�⣬ȡ���ֵ
	 * 
	 * @param n1
	 * @param n2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] n1, int[] n2, int k) {
		/* ��ʼ�� */
		result = new int[k];
		this.n1 = n1;
		this.n2 = n2;
		this.k = k;
		this.sumLen = n1.length + n2.length;
		copyArrays();
		maxResult = 0;
		/* ��ȫ�� */
		solution(0);
		/* ȡ��ֵ */
		int max = maxResult;
		int[] re = new int[result.length];
		int in = re.length - 1;
		while (max > 0) {
			re[in--] = max % 10;
			max /= 10;
		}
		return re;
	}

	/**
	 * �������������ӵ�һ������������
	 * 
	 */
	private void copyArrays() {
		// TODO Auto-generated method stub
		nsum = new int[2][n1.length + n2.length];
		int index = 0;
		for (int i = 0; i < n1.length; i++) {
			nsum[0][index] = n1[i];
			nsum[1][index] = 0;
			index++;
		}
		for (int j = 0; j < n2.length; j++) {
			nsum[0][index] = n2[j];
			nsum[1][index] = 0;
			index++;
		}
	}

	/**
	 * ���ݷ�����
	 * 
	 * @param n
	 */
	public void solution(int n) {
		System.out.println(n + ":" + Arrays.toString(result));// ��¼���ݹ���
		if (n == k) {
			if (isLegal()) {
				int[] tre = new int[result.length];
				for (int i = 0; i < tre.length; i++) {
					tre[i] = nsum[0][result[i]];
				}
				String str = Arrays.toString(tre).replace(",", "").replace(" ", "").replace("[", "").replace("]", "");
				int strInt = Integer.parseInt(str);
				maxResult = maxResult > strInt ? maxResult : strInt;
				return;
			}
		}
		int[] maxTemp = getSortArray();
		for (int max : maxTemp) {
			if (yetLegal(max, n)) {
				result[n] = max;
				nsum[1][max] = 1;
				solution(n + 1);
				nsum[1][max] = 0;
				result[n] = 0;
			}
		}

	}

	/**
	 * ��ȡ����������δʹ�ù�����ֵ�±꣬�����ս�������
	 * 
	 * @return
	 */
	private int[] getSortArray() {
		// TODO Auto-generated method stub
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < nsum[0].length; i++) {
			if (nsum[1][i] == 0)
				l.add(i);
		}

		int[] re = new int[l.size()];
		for (int i = 0; i < re.length; i++)
			re[i] = l.get(i);
		for (int i = 0; i < re.length; i++)
			for (int j = 0; j < re.length; j++) {
				if (nsum[0][re[i]] < nsum[0][re[j]]) {
					int temp = re[i];
					re[i] = re[j];
					re[j] = temp;
				}
			}

		return re;
	}

	/**
	 * �жϵ�ĿǰΪֹ�Ƿ�Ϸ�
	 * 
	 * @param max
	 * @param n
	 * @return
	 */
	private boolean yetLegal(int max, int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (result[i] >= n1.length)
				l2.add(result[i]);
			else
				l1.add(result[i]);
		}
		if (max > 0) {
			if (max >= n1.length)
				l2.add(max);
			else
				l1.add(max);
		}
		for (int i = 0; i < l1.size() - 1; i++) {
			if (l1.get(i) > l1.get(i + 1))
				return false;
		}
		for (int i = 0; i < l2.size() - 1; i++) {
			if (l2.get(i) > l2.get(i + 1))
				return false;
		}
		return true;
	}

	/**
	 * �ж�����ֵ�Ƿ�Ϸ�
	 * 
	 * @return
	 */
	public boolean isLegal() {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			if (result[i] >= n1.length)
				l2.add(result[i]);
			else
				l1.add(result[i]);
		}

		for (int i = 0; i < l1.size() - 1; i++) {
			if (l1.get(i) > l1.get(i + 1))
				return false;
		}
		for (int i = 0; i < l2.size() - 1; i++) {
			if (l2.get(i) > l2.get(i + 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = { 3, 9 }, b = { 8, 9 };
		Leet321MaxNumber_03 m = new Leet321MaxNumber_03();
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		int[] re = new Leet321MaxNumber_03().maxNumber(a, b, 3);

		System.out.println("result:" + Arrays.toString(re));
	}
}
