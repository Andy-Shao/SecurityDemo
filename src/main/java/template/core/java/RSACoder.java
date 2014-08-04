package template.core.java;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSACoder {

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	public static final String PUBLIC_KEY = "RSAPublicKey";
	public static final String PRIVATE_KEY = "RSAPrivateKey";
	public static final int KEY_SIZE = 512;
	
	public static byte[] sign(byte[] data, byte[] privateKey) throws Exception{
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		return signature.sign();
	}
	
	public static boolean verify(byte[] data, byte[] publicKey, byte[] sign) throws Exception{
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey pubKey = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);
		return signature.verify(sign);
	}
	
	public static byte[] getPublicKey(Map<String, Object> keyMap) throws Exception{
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return key.getEncoded();
	}
	
	public static byte[] getPrivateKey(Map<String, Object> keyMap) throws Exception{
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return key.getEncoded();
	}
	
	public static Map<String, Object> initKey() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(KEY_SIZE);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}
}
