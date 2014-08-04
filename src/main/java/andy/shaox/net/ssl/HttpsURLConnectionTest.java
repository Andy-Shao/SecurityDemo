package andy.shaox.net.ssl;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.net.ssl.HttpsURLConnection;

import org.junit.Test;

public class HttpsURLConnectionTest {

	@Test
	public void test() throws IOException {
		URL url = new URL("https://www.oracle.com/");
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.disconnect();
	}

	@Test
	public void tempTest() throws NoSuchAlgorithmException {
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(256);
		SecretKey secretKey = kg.generateKey();
		byte[] key = secretKey.getEncoded();
		System.out.println(recoverBytes(key));
	}

	static final char[] array = new char[] { 
			'0', '1', '2', '3',
			'4', '5', '6', '7',
			'8', '9', 'A', 'B',
			'C', 'D', 'E', 'F'
	};
	
	static String recoverBytes(byte[] keys){
		char[] cs = new char[keys.length << 1];
		for(int i=keys.length; i>=1;i--){
			int temp = i << 1;
			cs[--temp] = array[0x0F & keys[i-1]];
			cs[--temp] = array[(0xF0 & keys[i-1]) >> 4];
		}
		return new String(cs);
	}
}
