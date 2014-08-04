package andy.shao.util.zip;

import java.util.zip.CRC32;

import org.junit.Test;

public class CRC32Test {

	@Test
	public void testCRC32(){
		String str = "testCRC-32";
		CRC32 crc32 = new CRC32();
		crc32.update(str.getBytes());
		String hex = Long.toHexString(crc32.getValue());
		System.out.println(hex);
	}
}
