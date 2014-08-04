package andy.shao.security.cert;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import org.junit.Ignore;
import org.junit.Test;

public class CertificateFactoryTest {

	@Test
	@Ignore
	public void test() throws CertificateException, IOException{
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("D:\\x.keystore");
		@SuppressWarnings("unused")
        Certificate certificate = certificateFactory.generateCertificate(in);
		in.close();
	}
}
