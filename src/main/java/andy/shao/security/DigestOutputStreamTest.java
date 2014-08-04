package andy.shao.security;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class DigestOutputStreamTest {

	@Test
	public void test() throws IOException, NoSuchAlgorithmException{
		byte[] input = "md5".getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		DigestOutputStream dos = new DigestOutputStream(new ByteArrayOutputStream(), md);
		dos.write(input , 0 , input.length);
		@SuppressWarnings("unused")
        byte[] output = dos.getMessageDigest().digest();
		dos.flush();
		dos.close();
	}
}
