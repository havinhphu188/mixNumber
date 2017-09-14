package main;

import model.AggregateMix;

public class Main {
	public static void main(String[] args) {
		AggregateMix agMix = new AggregateMix("{1,2,3,4};{5,6};{7,8}");
		System.out.println(agMix.getOutputString());
		
	}

}
