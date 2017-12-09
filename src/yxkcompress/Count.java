package yxkcompress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Count {

	public static void main(String[] args) throws IOException {
		File sourceFile = new File("E:\\比赛数据\\my-errors.2017-10-23-1");
	    BufferedReader readerSourceFile = null;
	    BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\比赛数据\\encodeFile.txt"));
	    Map<String,Integer> word2Count = new HashMap<>();
	    
    	readerSourceFile = new BufferedReader(new FileReader(sourceFile));
        String line = null;
        //控制使用多少文件长度用于编码
        Long rowCount =1L;
        while ((line = readerSourceFile.readLine()) != null) {
        	if(rowCount > 10000){break;}
        	rowCount++;
            String[] words = line.split(" ");
            for(String word : words){
            	if(word2Count.containsKey(word)){
            		word2Count.put(word, word2Count.get(word)+1);
            	}else{
            		word2Count.put(word, 1);
            	}
            }
        }
        readerSourceFile.close();
	   
	    //排序按照单词出现频率 从打往小排序
	    List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(word2Count.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o2.getValue() - (o1.getValue());
            }
        });
	    
        int encode = 0;
        for(Map.Entry<String,Integer> result : list){ 
        	writer.write(result.getKey() + " " + encode);
        	encode++;
	    	writer.newLine();
       } 
	   writer.close(); 
	}
}

