package andy.shaox.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import org.junit.Test;

public class MacTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeyException{
		byte[] input = "MAC".getBytes();
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		@SuppressWarnings("unused")
        byte[] output = mac.doFinal(input);
	}
}
