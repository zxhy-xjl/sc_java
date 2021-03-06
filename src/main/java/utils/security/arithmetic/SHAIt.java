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
 * 无密钥SHA实现类
 * 
 * @author dawn
 * 
 */
public class SHAIt implements EncryptionHandle {

	private String algorithm = System.getProperty("SHA.algorithm", "SHA");

	/** 日志对象 */
	private final static Logger log = Logger.getLogger(SHAIt.class);

	/**
	 * 加密����
	 */
	public byte[] encrypt(byte[] bInputArr) throws EncryptException {
		MessageDigest sha = null;
		AssertUtil.isNotEmpty(bInputArr);
		try {
			sha = MessageDigest.getInstance(algorithm);
		} catch (SecurityException se) {
			log.error(" Security failure. SHA encryption error", se);
			throw new EncryptException(se);
		} catch (NoSuchAlgorithmException ex) {
			log.error(" No Such Algorithm failure. SHA encryption error", ex);
			throw new EncryptException(ex);
		}
		sha.update(bInputArr);

		return sha.digest();

	}

	/**
	 * SHA arithmetic decrypt not UnsupportedOperationException !
	 */
	public byte[] decrypt(byte[] sInput) {
		// TODO Auto-generated method stub
		throw new java.lang.UnsupportedOperationException(
				"SHA arithmetic decrypt not UnsupportedOperationException !");
	}
}
