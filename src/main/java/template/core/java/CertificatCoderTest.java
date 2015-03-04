package template.core.java;

import org.junit.Ignore;
import org.junit.Test;

public class CertificatCoderTest {

	private String password = "123456";
	private String alias = "www.zlex.org";
	private String certificatePath = "d:/zlex.cer";
	private String keyStorePath = "d:/zlex.keystore";

	/**
	 * public key encrypt, private key decrypt.
	 * @throws Exception if any of mistake
	 */
	@Ignore
	@Test
	public void test1() throws Exception{
		String inputStr = "digit certificate";
		byte[] data = inputStr.getBytes();
		byte[] encrypt = CertificateCoder.encryptByPublicKey(data, certificatePath);
		byte[] decrypt = CertificateCoder.decryptByPrivateKey(encrypt, keyStorePath, alias, password);
		String outpuStr = new String(decrypt);
		
		System.out.println("Before encrypt:\n" + inputStr);
		System.out.println("After decrypt:\n" + outpuStr);
	}
	
	/**
	 * public key decrypt, private key encrypt.
	 * @throws Exception if any of mistake
	 */
	@Ignore
	@Test
	public void test2() throws Exception{
		String inputStr = "digit sign";
		byte[] data = inputStr.getBytes();
		byte[] encodedData = CertificateCoder.encryByPrivateKey(data, keyStorePath, alias, password);
		byte[] decodeData = CertificateCoder.decryptByPublicKey(encodedData, certificatePath);
		String outputStr = new String(decodeData);
		
		System.out.println("Before encrypt:\n" + inputStr);
		System.out.println("After decrypth:\n" + outputStr);
	}
}
