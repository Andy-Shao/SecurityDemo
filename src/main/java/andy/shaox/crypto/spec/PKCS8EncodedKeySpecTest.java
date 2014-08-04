package andy.shaox.crypto.spec;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.junit.Test;

public class PKCS8EncodedKeySpecTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeySpecException{
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
		keygen.initialize(1024);
		KeyPair keys = keygen.genKeyPair();
		byte[] privateKeyBytes = keys.getPrivate().getEncoded();
		
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("DSA");
		@SuppressWarnings("unused")
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
	}
}
