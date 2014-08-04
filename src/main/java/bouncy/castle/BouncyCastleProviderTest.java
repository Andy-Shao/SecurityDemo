package bouncy.castle;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

import org.junit.Test;

public class BouncyCastleProviderTest {

	@Test
	public void test(){
		Provider provider = Security.getProvider("BC");
		System.out.println(provider);
		for(Map.Entry<Object, Object> entry : provider.entrySet())
			System.out.println(entry.getKey() + "-" + entry.getValue());
	}
}
