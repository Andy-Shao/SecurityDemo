package andy.shaox.crypto.spec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class AlgorithmParametersTest {

	@Test
	public void test() throws NoSuchAlgorithmException, IOException{
		AlgorithmParameters ap = AlgorithmParameters.getInstance("DES");
		ap.init(new BigInteger("19050619766489163472469").toByteArray());
		byte[] b = ap.getEncoded();
		System.out.println(new BigInteger(b).toString());
	}
}
