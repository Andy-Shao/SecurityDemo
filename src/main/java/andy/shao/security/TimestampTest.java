package andy.shao.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

public class TimestampTest {

	@Ignore
	@Test
	public void test() throws CertificateException, FileNotFoundException{
		CertificateFactory cf = CertificateFactory.getInstance("x509");
		CertPath cp = cf.generateCertPath(new FileInputStream("D:\\x.cer"));
		@SuppressWarnings("unused")
        Timestamp t = new Timestamp(new Date(), cp);
	}
}
