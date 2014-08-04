package andy.shao.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MessageDigestTest {

	@Test
	public void test() throws NoSuchAlgorithmException{
		byte[] input = "sha".getBytes();
		MessageDigest sha = MessageDigest.getInstance("SHA");
		sha.update(input);
		@SuppressWarnings("unused")
        byte [] output = sha.digest();
	}
}
