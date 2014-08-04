package andy.shao.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class KeyPairGeneratorTest {

	@Test
	public void test() throws NoSuchAlgorithmException{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
		kpg.initialize(1024);
		@SuppressWarnings("unused")
        KeyPair keys = kpg.genKeyPair();
	}
}
