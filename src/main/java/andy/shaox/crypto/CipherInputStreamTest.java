package andy.shaox.crypto;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.junit.Ignore;
import org.junit.Test;

public class CipherInputStreamTest {

	@Test
	@Ignore
	public void test() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException{
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		SecretKey secretKey = kg.generateKey();
		Cipher cipher = Cipher.getInstance("DES");
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		CipherInputStream cis = new CipherInputStream(new FileInputStream(new File("secret")), cipher);
		DataInputStream dis = new DataInputStream(cis);
		@SuppressWarnings("unused")
        String output = dis.readUTF();
		dis.close();
	}
}
