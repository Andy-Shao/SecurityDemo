package andy.shao.security;

import java.security.Provider;
import java.security.Security;
import java.util.Map;

import org.junit.Test;

public class SecurityTest {

	@Test
	public void print(){
		for(Provider p : Security.getProviders()){
			System.out.println(p);
			for(Map.Entry<Object, Object> entry : p.entrySet())
				System.out.println("\t" + entry.getKey());
		}
	}
}
