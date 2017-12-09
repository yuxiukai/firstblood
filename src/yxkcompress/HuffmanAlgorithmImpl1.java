package yxkcompress;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.Set;  
  
/** 
 * �㷨ʵ�ֲο�����ý�弼���̡̳� 
 * @author yuncong 
 * 
 */  
public class HuffmanAlgorithmImpl1 extends HuffmanAlgorithmAbstract {  
      
    /* 
     * �������������� ��ʧ��letterList�е����ݣ����letterList����Ҫ���Ƶĵط� 
     */  
    @Override  
    protected Node createTree(ArrayList<Node> letterList) {  
        init(letterList);  
        while (letterList.size() != 1) {  
            int size = letterList.size();  
            // С�Ľڵ�����ұߣ��۾���������ߣ�  
            Node nodeLeft = letterList.get(size - 1);  
            Node nodeRight = letterList.get(size - 2);  
            Node nodeParent = new Node();  
            nodeParent.setLeftChild(nodeLeft);  
            nodeParent.setRightChild(nodeRight);  
            Data data = new Data();  
            data.setFrequency(nodeRight.getData().getFrequency()  
                    + nodeLeft.getData().getFrequency());  
            nodeParent.setData(data);  
            letterList.set(size - 2, nodeParent);  
            letterList.remove(size - 1);  
            sort(letterList);  
  
        }  
        Node rootNode = letterList.get(0);  
        return rootNode;  
    }  
      
    /** 
     * ��ʼ�� �ýڵ��б����� 
     */  
    private void init(ArrayList<Node> letterList) {  
        sort(letterList);  
    }  
  
    /** 
     * ð�����򣬰�С�ķ������ 
     */  
    private void sort(ArrayList<Node> letterList) {  
        int size = letterList.size();  
        // ����ֻ��һ��Ԫ�ص������Ҳ����˵������Ҫ����  
        if (size == 1) {  
            return;  
        }  
        for (int i = 0; i < size; i++) {  
            for (int j = 0; j < size - 1 - i; j++) {  
                if (letterList.get(j).getData().getFrequency() < letterList  
                        .get(j + 1).getData().getFrequency()) {  
                    Node tempNode = letterList.get(j);  
                    letterList.set(j, letterList.get(j + 1));  
                    letterList.set(j + 1, tempNode);  
  
                }  
            }  
        }  
    }  
  
}  