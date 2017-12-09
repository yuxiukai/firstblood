package yxkcompress;

public class HuffmanAlgorithmImpl1Test {  
  
	public static void main(String[] args) {
		
		HuffmanAlgorithmImpl1 huffmanImpl1 = new HuffmanAlgorithmImpl1();  
        EncodeResult result = huffmanImpl1.encode("	at com.sf.sgs.delivery.server.rpc.DeliveryKafkaGatewayService.deliveryChangeOmsMsgProcess(DeliveryKafkaGatewayService.java:114) [delivery-server-2.3.2.jar:?]");  
       // System.out.println(result.getEncode());
        
        
        result = huffmanImpl1.encode("abcdda");  
        String decode = huffmanImpl1.decode(result);  
        //System.out.println(decode); 
	}
	 
}  