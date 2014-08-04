package bouncy.castle;

import org.bouncycastle.util.encoders.UrlBase64;
import org.junit.Test;

public class UrlBase64Test {

	@Test
	public void test(){
		String str = "url_base64";
		System.out.println(str);
		byte[] input = str.getBytes();
		byte[] data = UrlBase64.encode(input);
		System.out.println("After encode:" + new String(data));
		byte[] output = UrlBase64.decode(data);
		System.out.println("After decode:" + new String(output));
	}
}
