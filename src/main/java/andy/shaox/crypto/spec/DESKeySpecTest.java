package andy.shaox.crypto.spec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class DESKeySpecTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException{
		{
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			SecretKey secretKey = kg.generateKey();
			byte[] key = secretKey.getEncoded();
			
			secretKey = new SecretKeySpec(key, "DES");
			
			DESKeySpec dks = new DESKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			secretKey = keyFactory.generateSecret(dks);
		}
		
		KeyGenerator kg = KeyGenerator.getInstance("DESede");
		SecretKey secretKey = kg.generateKey();
		byte[] key = secretKey.getEncoded();
		
		DESedeKeySpec dks = new DESedeKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		secretKey = keyFactory.generateSecret(dks);
	}
}
