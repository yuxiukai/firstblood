package yxkcompress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatchString {
	 		
	static BufferedWriter writerFile = null;
	static final int LOOKBEFORELENGTH = 256;
	static final int LOOKBUFFERLENGTH = 1024;
	
	public static void main(String[] args) throws IOException {
		writerFile = new BufferedWriter(new FileWriter("E:\\比赛数据\\my-errors.zip.enconde.txt"));
		File sourceFile = new File("E:\\比赛数据\\my-errors.2017-10-23-1");
	    BufferedReader readerSourceFile =new BufferedReader(new FileReader(sourceFile));

		StringBuffer lookbefore = new StringBuffer();
		StringBuffer lookbuffer = new  StringBuffer();
        StringBuffer lineStringBuffer = new StringBuffer();
        char[] cbuf = new char[LOOKBEFORELENGTH];
        int off = 0;
        int len = LOOKBEFORELENGTH;
        boolean flag = false;
        int count = 0;
        while ((readerSourceFile.read(cbuf, off, len)) != -1  ) {        	
        	
        	if(flag == false){
        		lineStringBuffer.append(new String(cbuf).substring(0, LOOKBEFORELENGTH));
        		
        		lookbefore.append(lineStringBuffer.substring(0,LOOKBEFORELENGTH));
        		len = SubStr(lookbefore.toString(),lookbuffer.toString());
        		flag = true;
        		cbuf = new char[len];
        		continue;
        	}

        	lineStringBuffer.append(cbuf);
        	     	
        	if(lookbuffer.length() < LOOKBUFFERLENGTH){
        		lookbuffer.append(lineStringBuffer.substring(0, len));
        		lookbefore.setLength(0);
        		lookbefore.append(lineStringBuffer.substring(len, LOOKBEFORELENGTH+len));
//            	System.out.println("lookbuffer:"+lookbuffer);
//            	System.out.println("lookbefore:"+lookbefore);
            	lineStringBuffer.delete(0, len);
            	len = SubStr(lookbefore.toString(),lookbuffer.toString());
            	cbuf = new char[len];
        	}else{
        		lookbefore.setLength(0);
            	lookbuffer.delete(0, len);
//            	System.out.println("lineStringBuffer:" +lineStringBuffer);
            	lookbuffer.append(lineStringBuffer.substring(0, len));
            	lookbefore.append(lineStringBuffer.substring(len,LOOKBEFORELENGTH+len));
//            	System.out.println("lookbuffer:"+lookbuffer);
//            	System.out.println("lookbefore:"+lookbefore);
            	lineStringBuffer.delete(0, len);
            	len = SubStr(lookbefore.toString(),lookbuffer.toString());
            	cbuf = new char[len];
        	}
        	
        	
        	
//        	
//        
//        	if(count < 192 ){
//        		lookbefore.append(lineStringBuffer.substring(len+count,64+len+count));
//        		count++;
//        		lookbuffer.append(lineStringBuffer.substring(0,count));
//        	}else{
//        		lineStringBuffer.delete(0,len);
//        		System.out.println(lineStringBuffer);
//        		lookbefore.append(lineStringBuffer.substring(192,256));
//        		lookbuffer.append(lineStringBuffer.substring(0,192));
//        	}
        	
        	
//        	System.out.println(lookbefore);
//        	System.out.println(lookbuffer);
        	

	        
        	
        }
        readerSourceFile.close();
		
	}


	public static  int SubStr(String lookbefore, String lookbuffer) throws IOException {
		
		int end = 3;
		int postion = 0;
		
		
		if(lookbuffer == null || lookbuffer.length() == 0){
			writerFile.write("0 0 "+lookbefore.substring(0,1)+"|");
			writerFile.flush();
			
//			System.out.println(0);
//			System.out.println(0);
//			System.out.println(lookbefore.substring(0,1));
			return 1;
		}
		
		if(lookbefore.length() <= end){
			
			if(lookbefore.length() <= 1){
				writerFile.write("0 0 "+lookbefore.substring(0,1)+"|");
				writerFile.flush();
//				System.out.println(0);
//				System.out.println(0);
//				System.out.println(lookbefore.substring(0,1));
				return 1;
			}
			writerFile.write("0 0 "+lookbefore.substring(0,1)+"|");
			writerFile.flush();
//			System.out.println(0);
//			System.out.println(0);
//			System.out.println(lookbefore.substring(0,1));
			return 1;
		}
		
		String sublookbefore = lookbefore.substring(0,end);
		if(lookbuffer.indexOf(sublookbefore) == -1){
			writerFile.write("0 0 "+lookbefore.substring(0,1)+"|");
			writerFile.flush();
//			System.out.println(0);
//			System.out.println(0);
//			System.out.println(lookbefore.substring(0,1));
			return 1;
		}
		
		
		while(lookbuffer.indexOf(sublookbefore) != -1){
			postion = lookbuffer.indexOf(sublookbefore);
			end++;
			if(lookbefore.length() < end){
				break;
			}
			sublookbefore = lookbefore.substring(0,end);
		}
		sublookbefore = lookbefore.substring(0,end-1);
		
		int length = lookbuffer.length();
		
//		System.out.println(length - postion);
//		System.out.println(sublookbefore.length());
//		System.out.println(sublookbefore);
		writerFile.write(length - postion +" " +sublookbefore.length() +" "+sublookbefore+"|");
		writerFile.flush();
		return  sublookbefore.length();
	}
}
