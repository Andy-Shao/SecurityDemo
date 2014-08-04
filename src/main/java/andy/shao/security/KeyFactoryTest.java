package andy.shao.security;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.junit.Test;

public class KeyFactoryTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeySpecException{
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		//the keyBytes could send to other people
		byte[] keyBytes = keyPair.getPrivate().getEncoded();
		
		//other people receive the keyBytes & try to get the private key object.
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		@SuppressWarnings("unused")
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
	}
}
