/**
 *  
 *  
 */
package utils.security;

import utils.security.exception.EncryptException;



/**
 * 无密钥算法加密、解密

 * 
 * @author dawn
 * 
 */
public interface EncryptionHandle {

	/**
	 * 加密
	 * 
	 * @param bInputArr
	 *            明文
	 * @return 密文
	 */
	byte[] encrypt(byte[] bInputArr)throws EncryptException;

	/**
	 * 解密
	 * 
	 * @param sInput
	 *            密文
	 * @return 明文
	 */
	byte[] decrypt(byte[] bInputArr)throws EncryptException;

}
