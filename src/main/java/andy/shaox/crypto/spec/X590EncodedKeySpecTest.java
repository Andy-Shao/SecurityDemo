package andy.shaox.crypto.spec;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import org.junit.Test;

public class X590EncodedKeySpecTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeySpecException{
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
		keygen.initialize(1024);
		KeyPair keys = keygen.genKeyPair();
		byte[] publicKeyBytes = keys.getPublic().getEncoded();

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("DSA");
		@SuppressWarnings("unused")
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
	}
}
