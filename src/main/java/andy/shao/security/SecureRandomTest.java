package andy.shao.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.junit.Test;

public class SecureRandomTest {

	@Test
	public void test() throws NoSuchAlgorithmException{
		SecureRandom secureRandom = new SecureRandom();
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		kg.init(secureRandom);
		@SuppressWarnings("unused")
        SecretKey secretKey = kg.generateKey();
	}
}
