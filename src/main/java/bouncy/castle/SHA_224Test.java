package bouncy.castle;

import java.security.MessageDigest;
import java.util.Arrays;

import org.junit.Test;

public class SHA_224Test {

	public static byte[] encodeSHA224(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-224");
		md.update(data);
		return md.digest();
	}
	
	@Test
	public void basicTest() throws Exception{
		System.out.println(Arrays.toString(encodeSHA224("Andy.Shao".getBytes())));
	}
}
