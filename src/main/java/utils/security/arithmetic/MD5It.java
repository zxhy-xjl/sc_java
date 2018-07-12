/**
 *  
 *  
 */
package utils.security.arithmetic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import utils.AssertUtil;
import utils.security.EncryptionHandle;
import utils.security.exception.EncryptException;

/**
 * 无密钥Md5实现
 * 
 * @author dawn
 * 
 */
public class MD5It implements EncryptionHandle {

	private String algorithm = System.getProperty("MD5.algorithm", "MD5");

	/** 日志对象 */
	private final static Logger log = Logger.getLogger(MD5It.class);

	/**
	 * 加密
	 */
	public byte[] encrypt(byte[] bInputArr) throws EncryptException {
		MessageDigest md = null;
		AssertUtil.isNotEmpty(bInputArr);
		try {
			md = MessageDigest.getInstance(algorithm);

		} catch (SecurityException se) {
			log.error(" Security failure. md5 encryption error", se);
			throw new EncryptException(se);
		} catch (NoSuchAlgorithmException ex) {
			log.error(" No Such Algorithm failure. md5 encryption error", ex);
			throw new EncryptException(ex);
		}

		md.update(bInputArr);
		byte bDigest[] = md.digest();

		return bDigest;

	}

	/**
	 * MD5 Arithmetic decrypt Unsupported operation
	 */
	public byte[] decrypt(byte[] bInputArr) throws EncryptException {
		throw new java.lang.UnsupportedOperationException(
				"MD5   decryption Unsupported operation  !");
	}

}
