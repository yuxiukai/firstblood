package yxkcompress;

public interface HuffmanAlgorithm {  
    /** 
     * �����ַ����� 
     * @param str ָ������Ҫ������ַ��� 
     * @return ������ 
     */  
    public EncodeResult encode(String str);  
    /** 
     * ���ݱ���������ԭ�����ַ����� 
     * @param decodeResult ԭ���ַ����ı������� 
     * @return ����������ַ����� 
     */  
    public String decode(EncodeResult encodeResult);  
} 