package andy.shao.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class DigestInputStreamTest {

	@Test
	public void test() throws IOException, NoSuchAlgorithmException{
		byte[] input = "md5".getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		DigestInputStream dis = new DigestInputStream(new ByteArrayInputStream(input), md);
		dis.read(input, 0, input.length);
		@SuppressWarnings("unused")
        byte[] output = dis.getMessageDigest().digest();
		dis.close();
	}
}
