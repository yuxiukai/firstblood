package yxkcompress;

/** 
 * Data���ڴ洢һ���ַ�������ֵĴ��� 
 * @author yuncong 
 * 
 */  
public class Data implements Comparable<Data>{  
    // �ַ�  
    private char c = 0;  
    // �ַ����ֵĴ���  
    private int frequency = 0;  
      
    public char getC() {  
        return c;  
    }  
    public void setC(char c) {  
        this.c = c;  
    }  
    public int getFrequency() {  
        return frequency;  
    }  
    public void setFrequency(int frequency) {  
        this.frequency = frequency;  
    }  
      
    @Override  
    public String toString() {  
        return "Data [c=" + c + ", frequency=" + frequency + "]";  
    }  
    @Override  
    public int compareTo(Data o) {  
        if (this.frequency < o.getFrequency()) {  
            return -1;  
        } else if (this.frequency > o.getFrequency()) {  
            return 1;  
        } else {  
            return 0;  
        }  
    }  
} 