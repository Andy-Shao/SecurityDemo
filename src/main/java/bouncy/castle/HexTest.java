package bouncy.castle;

import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

public class HexTest {

	@Test
	public void test(){
		String str = "Hex code";
		System.out.println("Before encode:" + str);
		byte[] input = str.getBytes();
		byte[] data = Hex.encode(input);
		System.out.println("After encode:" + new String(data));
		byte[] output = Hex.decode(data);
		System.out.println("After decode:" + new String(output));
	}
}
