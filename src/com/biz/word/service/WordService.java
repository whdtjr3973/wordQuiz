package com.biz.word.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordService {

	Scanner scan ;
	List<String> words;
	String word;
	FileReader fileReader;
	BufferedReader buffer;
	
	public WordService(String fileName) throws FileNotFoundException {
		scan = new Scanner(System.in);
		words = new ArrayList<String>();
		word = new String();
		fileReader = new FileReader(fileName);
		buffer = new BufferedReader(fileReader);
		
	}
	
	public void readWordList() throws IOException  {
		// 리스트의 데이터만 지우는 메서드
		// remove() 1개씩 지우고자 할때
		// clear()는 내용물 전부다
		words.clear();
		String reader = "";
		while(true) {
		reader = buffer.readLine();
		if(reader==null) break;
		words.add(reader);
		}
	}

	public void inputWords() {
		words.clear();
		words.add("Happy");
		words.add("OMG");
		words.add("HelpMe");
		words.add("General");
		words.add("Queen");
		words.add("King");

	}
	public void makeQuiz() {
		Collections.shuffle(words);
		word = words.get(0);
		String[] arrWord = word.split("");
		List<String> alpha = new ArrayList<String>(Arrays.asList(arrWord));
		Collections.shuffle(alpha);
		
		System.out.println("=====================================");
		System.out.println(alpha);
		System.out.println("=====================================");
	}
	
	public boolean pickQuiz() {
		System.out.println("다음 예시의 알맞은 단어를 완성하시오");
		System.out.println("종료: --END");
		String strKeyInput = scan.nextLine();
		if(strKeyInput.equals("--END")) return true;
		if(word.equalsIgnoreCase(strKeyInput)) {
			System.out.println("정답입니다!!");
		} else {
			System.out.println("오답이에요! 다시한번 해보세요");
		}
		
		return false;
	}
}
