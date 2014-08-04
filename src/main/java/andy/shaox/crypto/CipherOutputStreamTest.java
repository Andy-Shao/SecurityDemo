package andy.shaox.crypto;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.junit.Ignore;
import org.junit.Test;

public class CipherOutputStreamTest {

	@Test
	@Ignore
	public void test() throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		SecretKey secretKey = kg.generateKey();
		Cipher cipher = Cipher.getInstance("DES");
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		String input = "1234567890";
		CipherOutputStream cos = new CipherOutputStream(new FileOutputStream("secret"), cipher);
		DataOutputStream dos = new DataOutputStream(cos);
		dos.writeUTF(input);
		dos.flush();
		dos.close();
	}
}
