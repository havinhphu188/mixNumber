package model;

import java.util.ArrayList;
import java.util.Arrays;

public class AggregateMix {
	private ArrayList<SetOfIncredient> aggregate;
	private int[] loopEndPattern;
	private int[] currentLoop;
	private ArrayList<ArrayList<String>> results ;

	public AggregateMix(String inputString) {
		aggregate = new ArrayList<>();
		results = new  ArrayList<ArrayList<String>>();
		String[] listOfSet = inputString.split(";");
		for (String s : listOfSet) {
			SetOfIncredient set = new SetOfIncredient(s);
			aggregate.add(set);
		}
	}

	private void generateResult() {
		initLoopEnd();
		initCurrentLoop();
		do {
			ArrayList<String> result = new ArrayList<String>();
			for (int i = 0; i < aggregate.size(); i++) {
				result.add(aggregate.get(i).getIncredient(currentLoop[i]));
			}
			results.add(result);
		} while (increaseCurrentLoop());
	}

	private void initLoopEnd() {
		loopEndPattern = new int[aggregate.size()];
		for (int i = 0; i < aggregate.size(); i++) {
			loopEndPattern[i] = aggregate.get(i).maxIndex();
		}
	}

	private void initCurrentLoop() {
		currentLoop = new int[aggregate.size()];
		for (int i = 0; i < aggregate.size(); i++) {
			currentLoop[i] = 0;
		}
	}

	private boolean increaseCurrentLoop() {
		int i = aggregate.size()-1;
		
		while ((currentLoop[i] == loopEndPattern[i])) {
			i--;
			if (i < 0)
				return false;
		}
		
		currentLoop[i]++;
		for (int j = i + 1; j < aggregate.size(); j++) {
			currentLoop[j] = 0;
		}
		return true;
	}
	
	public String getOutputString(){
		generateResult();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<results.size();i++){
			ArrayList<String> result = results.get(i);
			sb.append("{");
			for (int j = 0; j < result.size(); j++){
				sb.append(result.get(j));
				sb.append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("};");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
