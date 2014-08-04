package andy.shao.security.cert;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import org.junit.Ignore;
import org.junit.Test;

public class CRLTest {

	@Test
	@Ignore
	public void test() throws IOException, CertificateException, CRLException{
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("D:\\x.keystore");
		@SuppressWarnings("unused")
        CRL crl = certificateFactory.generateCRL(in);
		in.close();
	}
}
