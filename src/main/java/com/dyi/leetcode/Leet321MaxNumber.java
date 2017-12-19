package com.dyi.leetcode;

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
 *
 */
public class Leet321MaxNumber {
	/**
	 * 2017��8��2��10:35:21:˼·����ȷ������
	 * @param n1
	 * @param n2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] n1, int[] n2, int k) {
		int[] maxIndex=new int[k];
		int[] merge=new int[n1.length+n2.length];
		int i=0,j=0,index=0;
		while(i<n1.length&&j<n2.length){
			if(n1[i]>n2[j]){
				merge[index++]=n1[i++];
			}else if(n1[i]<n2[j]){
				merge[index++]=n2[j++];
			}else{
				/*���*/
				if(greatOrEquals(n1, n2, i, j)){
					merge[index++]=n1[i++];
				}else{
					merge[index++]=n2[j++];
				}
			}
		}
		while(i<n1.length){
			merge[index++]=n1[i++];
		}
		while(j<n2.length){
			merge[index++]=n2[j++];
		}
		System.out.println(Arrays.toString(merge));
		
		for(int m=0;m<maxIndex.length;m++){
			maxIndex[m]=m;
		}
		System.out.println(Arrays.toString(maxIndex));
		
		for(int d=maxIndex.length;d<merge.length;d++){//�ҳ�����k��			
			for(int x=0;x<maxIndex.length;x++)
				if(merge[d]>merge[maxIndex[x]]){
					maxIndex[x]=d;
					break;
				}
		}
		System.out.println(Arrays.toString(maxIndex));
		
		for(int d=0;d<maxIndex.length;d++)
			for(int x=d+1;x<maxIndex.length;x++)
				if(maxIndex[d]>maxIndex[x]){
					int temp=maxIndex[d];
					maxIndex[d]=maxIndex[x];
					maxIndex[x]=temp;
				}
		System.out.println(Arrays.toString(maxIndex));
		
		for(int d=0;d<maxIndex.length;d++)
			maxIndex[d]=merge[maxIndex[d]];
		System.out.println(Arrays.toString(maxIndex));
		
		return maxIndex;

	}
	public boolean greatOrEquals(int[] a,int[] b,int i,int j){
		for(;i<a.length&&j<b.length;i++,j++){
			if(a[i]>b[j])return true;
			else if(a[i]<b[j])return false;  
		}

		if(i==a.length)return false;
		return true;
	}
	public static void main(String[] args) {
		int[] a={3,9},
				b={8,9};
		Leet321MaxNumber m=new Leet321MaxNumber();
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(new Leet321MaxNumber().maxNumber(a, b, 3)));
	}
}
