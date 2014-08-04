package andy.shaox.crypto;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import org.junit.Test;

public class SealedObjectTest {

	@Test
	public void test() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, IOException{
		String input = "SealedObject";
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		SecretKey key = kg.generateKey();
		Cipher cipher1 = Cipher.getInstance(key.getAlgorithm());
		cipher1.init(Cipher.ENCRYPT_MODE, key);
		SealedObject sealedObject = new SealedObject(input, cipher1);
		Cipher cipher2 = Cipher.getInstance(key.getAlgorithm());
		cipher2.init(Cipher.DECRYPT_MODE, key);
		@SuppressWarnings("unused")
        String output = (String) sealedObject.getObject(cipher2);
	}
}
