package andy.shaox.crypto;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;

import org.junit.Test;

public class KeyAgreementTest {

	@SuppressWarnings("unused")
    @Test
	public void test() throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
		KeyPair kp1 = kpg.genKeyPair();
		KeyPair kp2 = kpg.genKeyPair();
		KeyAgreement keyAgree = KeyAgreement.getInstance(kpg.getAlgorithm());
		keyAgree.init(kp2.getPrivate());
		keyAgree.doPhase(kp1.getPublic(), true);
		SecretKey secretKey = keyAgree.generateSecret("DES");
	}
}
