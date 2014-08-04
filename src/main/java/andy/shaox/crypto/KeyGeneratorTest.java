package andy.shaox.crypto;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.junit.Test;

public class KeyGeneratorTest {

	@Test
	public void test() throws NoSuchAlgorithmException{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		@SuppressWarnings("unused")
        SecretKey secretKey = keyGenerator.generateKey();
	}
}
