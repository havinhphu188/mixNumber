package model;

import java.util.ArrayList;
import java.util.Arrays;

public class SetOfIncredient {
	private ArrayList<String> incredients;


	public SetOfIncredient(String inputString) {
		// extract incredients from string
		inputString = inputString.substring(1, inputString.length() - 1);
		String[] s = inputString.split(",");
		incredients = new ArrayList<String>(Arrays.asList(s));
	}

	public static void main(String[] args) {
		SetOfIncredient set1 = new SetOfIncredient("{1,2,34,5,7}");
		System.out.println(set1.maxIndex());
			
		
	}

	public String getIncredient(int index){
		return incredients.get(index);
	}
	
	public int maxIndex(){
		return incredients.size()-1;
	}
}
