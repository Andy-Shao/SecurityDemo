package andy.shaox.crypto.spec;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class SecretKeySpecTest {

	@Test
	public void test() throws NoSuchAlgorithmException{
		KeyGenerator kg = KeyGenerator.getInstance("RC2");
		SecretKey secretKey = kg.generateKey();
		byte[] key = secretKey.getEncoded();
		
		@SuppressWarnings("unused")
        SecretKey secretKey2 = new SecretKeySpec(key, "RC2");
	}
}
