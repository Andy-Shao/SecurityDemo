package andy.shao.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

import org.junit.Ignore;
import org.junit.Test;

public class KeyStoreTest {

	@Ignore
	@Test
	public void test() throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, UnrecoverableEntryException {
		// load key store
		FileInputStream is = new FileInputStream("C:\\swc\\x.keystore");
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		ks.load(is, "password".toCharArray());
		is.close();

		// get private key
		@SuppressWarnings("unused")
		PrivateKey key = (PrivateKey) ks.getKey("alies", "password".toCharArray());
		KeyStore.PrivateKeyEntry pkEntry = (PrivateKeyEntry) ks.getEntry("alias", new ProtectionParameter() {
		});
		@SuppressWarnings("unused")
		PrivateKey privateKey = pkEntry.getPrivateKey();
	}

	@Test
	public void showInfomations() throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, UnrecoverableKeyException {
		try(FileInputStream is = new FileInputStream("C:\\swc\\x.keystore");){
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(is, "password".toCharArray());
			
			System.out.println(ks.size());
			for(Enumeration<String> enumeration = ks.aliases(); enumeration.hasMoreElements();){
				String aliase = enumeration.nextElement();
				System.out.println(aliase);
				Key key = ks.getKey(aliase, "password".toCharArray());
				System.out.println(key.getFormat());
			}
		}
	}
}
