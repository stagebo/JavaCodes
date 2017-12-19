package com.dyi.leetcode;

/**
 * ͳ��һ�������Ķ��������а���1�ĸ���
 * 
 * @author WANYONGBO
 *
 */
public class OneCount {
	public static int oneCount(int n) {
		int re = 0;
		n *= n < 0 ? -1 : 1;
		while (n != 0) {
			int t = ((n >> 1) << 1) - n;
			re += t == 0 ? 0 : 1;
			n = n >> 1;
		}
		return re;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 200; i++) {
			System.out.println(Integer.toBinaryString(i) + ":" + oneCount(i));
		}
	}
}
