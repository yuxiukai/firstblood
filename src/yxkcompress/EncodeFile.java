package yxkcompress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EncodeFile {

	public static void main(String[] args) throws IOException {
		File sourceFile = new File("E:\\��������\\my-errors.2017-10-23-1");
		File encodeFile = new File("E:\\��������\\encodeFile.txt");
	    BufferedReader readerSourceFile = null;
	    BufferedReader readerEncodeFile = null;
	    BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\��������\\my-errors.zip.txt"));
	    Map<String,Integer> word2Count = new HashMap<>();
	    
	    //���ر����ļ�
	    readerEncodeFile = new BufferedReader(new FileReader(encodeFile));
	    String line = null;
	    int spaceCount = -1;
	    String lineBefor = null;
	    String lineEnd = null;
	    while ((line = readerEncodeFile.readLine()) != null) {
	    	spaceCount = line.lastIndexOf(" ");
	        lineBefor = line.substring(0, spaceCount);
	        lineEnd = line.substring(spaceCount+1,line.length());
	        word2Count.put(lineBefor, Integer.valueOf(lineEnd));
	    }
	    readerEncodeFile.close();
	    
	    //����ԭʼ�ļ�
	    readerSourceFile = new BufferedReader(new FileReader(sourceFile));
	    String[] lineWords = null;
	    StringBuffer newLine = new StringBuffer();
	    int wordValue = -1;
	    while ((line = readerSourceFile.readLine()) != null) {
	    	lineWords =  line.split(" ");
	        for(String word : lineWords){
	        	//�ڱ����ļ��е��ַ� ת��Ϊ����
	        	if(word2Count.containsKey(word)){
	        		wordValue = word2Count.get(word);
	        		newLine.append(wordValue+" ");
	        	//δ�ڱ����ļ��е��ַ� ԭ�����
	        	}else{
	        		newLine.append(word +" ");
	        	}
	        }
	        //��ȥ���һ���ո�
	        line = newLine.toString().substring(0,newLine.toString().length() -1);
	        writer.write(line);	  
	        newLine.setLength(0);
	        writer.newLine();
	        writer.flush();
	    }
	    readerSourceFile.close();
	    writer.close();
	    
	}
}
