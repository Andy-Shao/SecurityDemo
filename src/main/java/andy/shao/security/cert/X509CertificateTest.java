package andy.shao.security.cert;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.junit.Ignore;
import org.junit.Test;

public class X509CertificateTest {

	@Test
	@Ignore
	public void test() throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException{
		FileInputStream is = new FileInputStream("D:\\x.keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(is, "password".toCharArray());
		is.close();
		
		X509Certificate x509Certificate = (X509Certificate) ks.getCertificate("alias");
		@SuppressWarnings("unused")
        Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
	}
}
