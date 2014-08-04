package template.core.java;

import java.util.Map;

import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RSACoderTest {

	private byte[] publicKey;
	private byte[] privateKey;
	
	@Before
	public void initKey() throws Exception{
		Map<String, Object> keyMap = RSACoder.initKey();
		this.publicKey = RSACoder.getPublicKey(keyMap);
		this.privateKey = RSACoder.getPrivateKey(keyMap);
		
		System.out.println("public key: \n" + Base64.toBase64String(this.publicKey));
		System.out.println("private key: \n" + Base64.toBase64String(this.privateKey));
	}
	
	@Ignore
	@Test
	public void testSign() throws Exception{
		String inputStr = "RSA sign";
		byte[] data = inputStr.getBytes();
		byte[] sign = RSACoder.sign(data, this.privateKey);
		System.out.println("sign:\n" + Hex.toHexString(sign));
		
		boolean status = RSACoder.verify(data, this.publicKey, sign);
		System.out.println("status:\n" + status);
		
//		Assert.assertTrue(status);
	}
}
