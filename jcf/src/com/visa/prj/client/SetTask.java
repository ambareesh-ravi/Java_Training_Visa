package com.visa.prj.client;

import java.util.HashSet;
import java.util.Set;

public class SetTask {

	public static void main(String[] args) {
		
		Set<String> unique = new HashSet<>(args.length);
		Set<String> duplicate = new HashSet<>(args.length);
		
		for(String s : args)
		{
			if(!unique.add(s))
				duplicate.add(s);
		}
		unique.removeAll(duplicate);
		System.out.println(unique);
		System.out.println(duplicate);

	}

}
