/**
 *  
 *  
 */
package utils.security;

import java.security.Key;

import utils.security.exception.EncryptException;


/**
 * 有密钥对称算法加密、解密
 * 
 * @author dawn
 * 
 */
public interface SymmericEncryptionHandle {

	/**
	 * 加密
	 * 
	 * @param bInputArr
	 *            明文
	 * @param symmetricKey
	 *            对称Key
	 * @return 密文
	 */
	byte[] encrypt(byte[] bInputArr, Key symmetricKey)throws EncryptException;

	/**
	 * 解密
	 * 
	 * @param bInputArr
	 *            密文
	 * @param symmeticKey
	 *            对称Key
	 * @return 明文
	 */
	byte[] decrypt(byte[] bInputArr, Key symmeticKey)throws EncryptException;

	/**
	 * 获取对称算法Key
	 * 
	 * @return 对称Key
	 */
	Key generateSymmetricKey()throws EncryptException;
}
