package yxkcompress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DecodeFile {

	public static void main(String[] args) throws IOException {
		File zipFile = new File("E:\\比赛数据\\my-errors.zip.txt");
		File fileEncode = new File("E:\\比赛数据\\encodeFile.txt");
	    BufferedReader readerZipFile = null;
	    BufferedReader readerEncodeFile = null;
	    BufferedWriter writerFile = new BufferedWriter(new FileWriter("E:\\比赛数据\\my-errors.source.txt"));

	    Map<Integer,String> Count2Word = new HashMap<>();
		
	    readerEncodeFile = new BufferedReader(new FileReader(fileEncode));
	    String line = null;
	    int spaceCount = -1;
	    String lineBefor = null;
	    String lineEnd = null;
	    while ((line = readerEncodeFile.readLine()) != null) {
	    	spaceCount = line.lastIndexOf(" ");
	        lineBefor = line.substring(0, spaceCount);
	        lineEnd = line.substring(spaceCount+1,line.length());
	        Count2Word.put(Integer.valueOf(lineEnd), lineBefor);
	    }
	    readerEncodeFile.close();
	    
	    readerZipFile = new BufferedReader(new FileReader(zipFile));
	    StringBuffer newLine = new StringBuffer();
	    while ((line = readerZipFile.readLine()) != null) {
	        String[] lineWords = line.split(" ");
	        for(String word : lineWords){
	        	if(isNum(word)){
	        		if(Count2Word.containsKey(Integer.valueOf(word))){
		        		String wordValue = Count2Word.get(Integer.valueOf(word));
		        		newLine.append(wordValue+" ");
	        		}else{
	        			newLine.append(word+" ");
	        		}
	        	}else{
	        		newLine.append(word+" ");
	        	}
	        }
	        line = newLine.toString().substring(0,newLine.toString().length() -1 );
	        writerFile.write(line);
	        
	        newLine.setLength(0);
	        writerFile.newLine();
	        writerFile.flush();
	    }
	    readerZipFile.close();
	    writerFile.close();
	}
	
	public static boolean isNum(String num) {  
        try {
            new Integer(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
