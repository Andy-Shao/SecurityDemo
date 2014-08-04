package bouncy.castle;

import org.junit.Test;
import org.bouncycastle.util.encoders.*;

public class Base64Test {

	@Test
	public void test(){
		String str = "base63";
		System.out.println("\t" + str);
		byte[] input = str.getBytes();
		byte[] data = Base64.encode(input);
		System.out.println("after encode: " + new String(data));
		byte[] output = Base64.decode(data);
		System.out.println("after decode: " + new String(output));
	}
}
