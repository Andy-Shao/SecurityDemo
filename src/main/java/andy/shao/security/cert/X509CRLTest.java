package andy.shao.security.cert;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;

import org.junit.Ignore;
import org.junit.Test;

public class X509CRLTest {

	@Test
	@Ignore
	public void test() throws CertificateException, CRLException, IOException{
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("D:\\x.keystore");
		X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(in);
		X509CRL x509crl = (X509CRL) certificateFactory.generateCRL(in);
		@SuppressWarnings("unused")
        X509CRLEntry x509crlEntry = x509crl.getRevokedCertificate(certificate);
		in.close();
	}
}
