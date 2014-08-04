package andy.shaox.net.ssl;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.TrustManagerFactory;

import org.junit.Ignore;
import org.junit.Test;

public class TrustManagerFactoryTest {

	@Ignore
	@Test
	public void test() throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException{
		FileInputStream is = new FileInputStream("D:\\x.keystore");
		TrustManagerFactory trustedCertificateEntry = TrustManagerFactory.getInstance("SunX509");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(is , "password".toCharArray());
		is.close();
		
		trustedCertificateEntry.init(ks);
	}
}
