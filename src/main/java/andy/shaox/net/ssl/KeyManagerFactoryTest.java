package andy.shaox.net.ssl;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;

import org.junit.Ignore;
import org.junit.Test;

public class KeyManagerFactoryTest {

	@Test
	@Ignore
	public void test() throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, UnrecoverableKeyException{
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		FileInputStream is = new FileInputStream("C:\\swc\\x.keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(is, "password".toCharArray());
		is.close();
		
		keyManagerFactory.init(ks, "password".toCharArray());
	}
}
