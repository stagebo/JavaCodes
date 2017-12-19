package com.dyi.leetcode;

public class TwoNums {
	public static void main(String[] args) {
		int[] a={2,3,4,6};
		int[] b=solution(a,6);//[1,2]
		System.out.println(b);
	}
	/**
	 * 
	 * @param args
	 *            Given an array of integers, return indices of the two numbers
	 *            such that they add up to a specific target.
	 * 
	 *            You may assume that each input would have exactly one
	 *            solution, and you may not use the same element twice.
	 * 
	 *            Example: Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 *            Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 */
	public static int[] solution(int[] nums,int target){
		for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return null;  
	}

}