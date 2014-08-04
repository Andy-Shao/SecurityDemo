package andy.shao.security.cert;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import org.junit.Ignore;
import org.junit.Test;

public class CertPathTest {

	@SuppressWarnings("unused")
    @Test
    @Ignore
	public void test() throws IOException, CertificateException{
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("D:\\x.keystore");
		CertPath certPath = certificateFactory.generateCertPath(in);
		in.close();
	}
}
