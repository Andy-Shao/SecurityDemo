package andy.shaox.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.junit.Test;

public class SecretKeyFactoryTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException{
		//get key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] key = secretKey.getEncoded();
		
		//reduction key
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		@SuppressWarnings("unused")
        SecretKey secretKey2 = keyFactory.generateSecret(dks);
	}
}
