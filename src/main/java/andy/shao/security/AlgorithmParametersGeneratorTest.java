package andy.shao.security;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;

import org.junit.Ignore;
import org.junit.Test;

public class AlgorithmParametersGeneratorTest {

	@Ignore
	@Test
	public void test() throws NoSuchAlgorithmException, IOException{
		AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("DES");
		apg.init(56);
		AlgorithmParameters ap = apg.generateParameters();
		byte[] b = ap.getEncoded();
		System.out.println(new BigInteger(b).toString());
	}
}
