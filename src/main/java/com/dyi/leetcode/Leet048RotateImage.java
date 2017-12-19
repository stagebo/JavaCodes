package com.dyi.leetcode;

/**
 * 48.You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author WANYONGBO 2017��7��19��15:47:42
 *
 */
public class Leet048RotateImage {
	/**
	 * ˳ʱ����ת�����������Խ��߷��ۣ�����������Գ��ᷭ�ۼ��ɡ� ��ʱ����ת�����������Խ��߷��ۣ������ź���Գ��ᷭ�ۼ��ɡ�
	 * 2017��7��19��15:47:37
	 * 
	 * @param m
	 */
	public static void rotate(int[][] m) {
		int n = m.length;
		if (n < 2)
			return;
		int temp;
		/*���Խ���*/
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i >= j)
					continue;
				temp = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = temp;
			}
		/*����Գ���*/
		int mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= mid; j++) {
				temp = m[i][j];
				m[i][j] = m[i][n - 1 - j];
				m[i][n - j - 1] = temp;
			}
		}
	}

	public static void printImage(int[][] a) {
		System.out.println("*************************************************");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + "#");
			System.out.println();

		}

	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 2 }, { 3, 4 } };
		printImage(a);
		rotate(a);
		printImage(a);
		
		a = new int[][] { { 1, 2 ,3}, { 4,5,6 }, { 7,8,9 } };
		printImage(a);
		rotate(a);
		printImage(a);
	}
}
