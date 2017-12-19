package com.dyi.leetcode;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author Stagebo
 *
 */
public class StringConvertToInteger {
	public static int myAtoi(String str) {
		return myAtoi(str, 10);
	}

	public static int myAtoi(String str, int base) {// 16���ƴ����
		str = str.toLowerCase()//ȫСд~
				.replace(':', '&').replace('a', ':')//����16����
				.replace(';', '&').replace('b', ';')
				.replace('<', '&').replace('c', '<')
				.replace('=', '&').replace('d', '=')
				.replace('>', '&').replace('e', '>')
				.replace('?', '&').replace('f', '?')
				.trim();//ȥ����β�ո�
		if (str.length() < 1)
			return 0;
		boolean isN = false;
		int index = 0;
		char k = str.charAt(0);
		/* �ж��������� */
		if ('+' == k) {
			isN = false;
			index = 1;
		} else if ('-' == k) {
			isN = true;
			index = 1;
		}
		long result = 0;
		for (; index < str.length(); index++) {
			char key = str.charAt(index);
			if (key < '0' || key - '0' > base-1) {//ʮ������Ҫ-1.���������۲�
				break;
			}
			int d = key - 0x30;
			result = result * base + d;
			if (result > Integer.MAX_VALUE && !isN) {// ��һ�����������ں����isN
				result = Integer.MAX_VALUE;
				break;
			}
			if (-result < Integer.MIN_VALUE) {// �ڶ�������������resultǰ���-
				result = Integer.MIN_VALUE;
				break;
			}
		}
		int re = (int) result;
		return isN ? -re : re;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("1004309", 2) + "aim");
		System.out.println(myAtoi(" -12:3123a"));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.parseInt("-214748364"));

	}
}
