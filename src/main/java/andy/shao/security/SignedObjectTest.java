package andy.shao.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.SignedObject;

import org.junit.Test;

public class SignedObjectTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException{
		byte[] data = "Data Signature".getBytes();
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		Signature signature = Signature.getInstance(keyPairGen.getAlgorithm());
		
		SignedObject s = new SignedObject(data, keyPair.getPrivate(), signature);
		@SuppressWarnings("unused")
        byte[] sign = s.getSignature();
		@SuppressWarnings("unused")
        boolean status = s.verify(keyPair.getPublic(), signature);
	}
}
