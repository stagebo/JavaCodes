package com.dyi.string;

/**
 * author:wyb
 * 创建时间：2017-12-21 10:57:50
 * To：十进制转k进制
 */
public class KBaseNumber {
	public static void main(String[] args) {
		for (int i = -100; i < 100; i++) {
			System.out.print("" + i + "__十进制: "
					+ parseKBase(i, "123456789".split("")));
			System.out.print(",   " + "八进制: "
					+ parseKBase(i, "1234567".split("")));
			System.out.print(",   " + "16进制: "
					+ parseKBase(i, "123456789ABCDEF".split("")));
			System.out.print(",   " + "A-Z进制: " + parseKBase(i));
			System.out.println(",   " + "二进制: " + parseKBase(i, "1".split("")));
		}
	}

	public static String parseKBase(int num) {
		String[] base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		return parseKBase(num, base);
	}

	public static String parseKBase(int num, String[] base) {
		if (num == 0) {
			return "0";
		}

		int k = base.length;
		String sign = num >= 0 ? "" : "-";
		num = num >= 0 ? num : -num;
		StringBuilder result = new StringBuilder();

		while (num > 0) {
			int idx = num % k;
			num = num / k;
			if (idx == 0) {
				result.append("0");
			} else {
				result.append(base[idx]);
			}
		}
		result.append(sign);
		return result.reverse().toString();
	}
}
