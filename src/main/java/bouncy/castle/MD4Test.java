package bouncy.castle;

import java.security.MessageDigest;
import java.util.Arrays;

import org.junit.Test;

public class MD4Test {

	public static byte[] encodeMD4(byte[] data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD4");
		md.update(data);
		return md.digest();
	}
	
	@Test
	public void basicTest() throws Exception{
		System.out.println(Arrays.toString(encodeMD4("Andy.Shao".getBytes())));
	}
}
