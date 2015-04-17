package main;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Document {
	int[] wordIdArray;
	int[] wordFreArray;
	int wordNum = 0;
	
	public Document(String text, HashMap<String, Integer> wordToIdMap) 
	{
		int V = wordToIdMap.size();
		HashMap<Integer, Integer> wordFreMap = new HashMap<Integer, Integer>(); 
		StringTokenizer st = new StringTokenizer(text);
		String token;
		int tokenId;
		
		while(st.hasMoreTokens()){
			token = st.nextToken();
			if (!wordToIdMap.containsKey(token)) {
				tokenId = V++;
				wordToIdMap.put(token, tokenId);
			} else {
				tokenId = wordToIdMap.get(token);
			}
			
			if (!wordFreMap.containsKey(tokenId)){
				wordFreMap.put(tokenId, 1);
			}else{
				wordFreMap.put(tokenId, wordFreMap.get(tokenId) + 1);
			}
		}
		
		this.wordNum = wordFreMap.size();
		this.wordIdArray = new int[this.wordNum];
		this.wordFreArray = new int[this.wordNum];
		int w = 0;
		for(Map.Entry<Integer, Integer> word: wordFreMap.entrySet()){
			this.wordIdArray[w] = word.getKey();
			this.wordFreArray[w] = word.getValue();
			w++;
		}
	}
}
