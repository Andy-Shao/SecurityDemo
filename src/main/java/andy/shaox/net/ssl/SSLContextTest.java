package andy.shaox.net.ssl;

import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import org.junit.Test;

public class SSLContextTest {

	@Test
	public void test() throws Exception{
		getSslSocketFactory("password", "C:\\swc\\x.keystore", "C:\\swc\\x.trustkeystore");
	}
	
	static KeyStore getKeyStore(String keyStorePath, String password) throws Exception{
		try(FileInputStream is = new FileInputStream(keyStorePath);){
			KeyStore ks = KeyStore.getInstance("JKS");
			ks.load(is, password.toCharArray());
			return ks;
		}
	}
	
	static SSLSocketFactory getSslSocketFactory(String password, String keyStorePath, String trustKeyStorePath) throws Exception{
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		KeyStore keyStore = getKeyStore(keyStorePath, password);
		keyManagerFactory.init(keyStore, password.toCharArray());
		
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
		KeyStore ks = getKeyStore(trustKeyStorePath, password);
		trustManagerFactory.init(ks);
		
		SSLContext ctx = SSLContext.getInstance("SSL");
		ctx.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
		SSLSocketFactory sf = ctx.getSocketFactory();
		return sf;
	}
}
