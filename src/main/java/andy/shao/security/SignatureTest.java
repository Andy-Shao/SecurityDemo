package andy.shao.security;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

import org.junit.Test;

public class SignatureTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException{
		byte[] data = "Data Signature".getBytes();
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		Signature signature = Signature.getInstance(keyPairGen.getAlgorithm());
		signature.initSign(keyPair.getPrivate());
		signature.update(data);
        byte[] sign = signature.sign();
		
		signature.initVerify(keyPair.getPublic());
		signature.update(data);
		@SuppressWarnings("unused")
        boolean status = signature.verify(sign);
	}
}
