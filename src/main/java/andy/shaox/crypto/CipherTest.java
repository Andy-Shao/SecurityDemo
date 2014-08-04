package andy.shaox.crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.junit.Test;

public class CipherTest {

	@Test
	public void test() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException{
		//Instance
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		SecretKey secretKey = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("DES");
		
		//wrap
		cipher.init(Cipher.WRAP_MODE, secretKey);
		byte[] k = cipher.wrap(secretKey);
		
		//unwrap
		cipher.init(Cipher.UNWRAP_MODE, secretKey);
		@SuppressWarnings("unused")
        Key key = cipher.unwrap(k, "DES", Cipher.SECRET_KEY);
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
//		byte[] output = cipher.doFinal(input);
	}
}
