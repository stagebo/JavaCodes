package com.dyi.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTest {
	public static void main(String[] args) {
		
		//构造List
		List<Info> list = new ArrayList<Info>();
		initList(list);
		
		//构造结果Map，并遍历List得出结果
		Map<String,Integer> groupList = new HashMap<String,Integer>();
		for(Info info:list){
			String key = info.date;
			if(!groupList.containsKey(key)){
				groupList.put(key, 0);
			}
			groupList.put(key, groupList.get(key)+1);
		}
		
		//打印结果
		for(String key:groupList.keySet()){
			System.out.println("key:"+key+",value:"+groupList.get(key));
		}
		
	}
	public static void initList(List<Info> list){
		list.add(new Info("2017-12-20"));
		list.add(new Info("2017-12-20"));
		
		list.add(new Info("2017-12-21"));
		list.add(new Info("2017-12-21"));
		list.add(new Info("2017-12-21"));
		
		list.add(new Info("2017-12-22"));
		list.add(new Info("2017-12-22"));
		list.add(new Info("2017-12-22"));
		list.add(new Info("2017-12-22"));		
		list.add(new Info("2017-12-22"));
		
		list.add(new Info("2017-12-23"));
		list.add(new Info("2017-12-23"));
		list.add(new Info("2017-12-23"));
		
		list.add(new Info("2017-12-24"));
		
		list.add(new Info("2017-12-25"));
	}
}
class Info{
	public String date;
	public String name;
	public String info;
	public Info(String date){
		this.date = date;
	}
}