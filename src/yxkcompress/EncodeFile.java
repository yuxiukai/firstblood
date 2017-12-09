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
		File sourceFile = new File("E:\\比赛数据\\my-errors.2017-10-23-1");
		File encodeFile = new File("E:\\比赛数据\\encodeFile.txt");
	    BufferedReader readerSourceFile = null;
	    BufferedReader readerEncodeFile = null;
	    BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\比赛数据\\my-errors.zip.txt"));
	    Map<String,Integer> word2Count = new HashMap<>();
	    
	    //加载编码文件
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
	    
	    //加载原始文件
	    readerSourceFile = new BufferedReader(new FileReader(sourceFile));
	    String[] lineWords = null;
	    StringBuffer newLine = new StringBuffer();
	    int wordValue = -1;
	    while ((line = readerSourceFile.readLine()) != null) {
	    	lineWords =  line.split(" ");
	        for(String word : lineWords){
	        	//在编码文件中的字符 转换为编码
	        	if(word2Count.containsKey(word)){
	        		wordValue = word2Count.get(word);
	        		newLine.append(wordValue+" ");
	        	//未在编码文件中的字符 原文输出
	        	}else{
	        		newLine.append(word +" ");
	        	}
	        }
	        //除去最后一个空格
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
