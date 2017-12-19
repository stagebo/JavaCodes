package com.dyi.test;

/**
 * �����ַ����ֱ������������������������ĳ˻�
 * 
 * @author WANYONGBO
 * @version 2017-8-9 15:39:47
 */
public class StringMultip {
	public static void main(String[] args) {
		long a = 54324342344234651L;
		int b = 52342234;
		System.out.println(a * b);
		System.out.println(multStrings(a + "", b));
		System.out.println(multipLargeNumber(a + "", b + ""));
	}

	/**
	 * ����������ĳ˻�
	 * 
	 * @param n1
	 *            String �������ֵ��ַ���
	 * @param n2
	 *            String �������ֵ��ַ���
	 * @return �������ĳ˻�
	 */
	public static String multipLargeNumber(String n1, String n2) {
		String result = "";
		for (int i = n2.length() - 1; i >= 0; i--) {
			int m = n2.charAt(i) - '0';
			String ret = multStrings(n1, m);
			for (int k = 0; k < n2.length() - 1 - i; k++)
				ret += "0";
			result = addStrings(result, ret);

		}

		return result;
	}

	/**
	 * ����ַ��������������һ��0-9��������˵Ľ��
	 * 
	 * @param s
	 *            String ����һ�������ַ���
	 * @param n
	 *            ���֣�0<=n<=9
	 * @return ����ַ���
	 */
	public static String multStrings(String s, int n) {
		int carry = 0;
		StringBuilder re = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int m = (s.charAt(s.length() - 1 - i) - '0') * n + carry;
			re.append(m % 10);
			carry = m / 10;
		}
		re.append(carry == 0 ? "" : carry + "");
		return re.reverse().toString();
	}

	/**
	 * ����������ӵĽ��
	 * 
	 * @param num1
	 *            String ����һ�������ַ���
	 * @param num2
	 *            String ����һ�������ַ���
	 * @return ��������˵Ľ��
	 */
	public static String addStrings(String num1, String num2) {
		StringBuilder re = new StringBuilder();
		int carry = 0;
		int i = 0;
		while (i < num1.length() && i < num2.length()) {
			int m = num1.charAt(num1.length() - i - 1) - '0' + num2.charAt(num2.length() - 1 - i) - '0' + carry;
			re.append(m % 10);
			carry = m / 10;
			i++;
		}
		while (i < num1.length()) {
			int m = num1.charAt(num1.length() - i - 1) - '0' + carry;
			re.append(m % 10);
			carry = m / 10;
			i++;
		}
		while (i < num2.length()) {
			int m = num2.charAt(num2.length() - i - 1) - '0' + carry;
			re.append(m % 10);
			carry = m / 10;
			i++;
		}
		re.append(carry == 1 ? "1" : "");
		return re.reverse().toString();
	}
}
