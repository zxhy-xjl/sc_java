/**
 *  
 *  
 */
package utils.security.arithmetic;

import utils.AssertUtil;
import utils.security.EncryptionHandle;
import utils.security.exception.EncryptException;


/**
 * 无密钥Base64实现类ܡ�������
 * 
 * @author dawn
 * 
 */
public final class Base64It implements EncryptionHandle {

	/**
	 * 解密方法
	 */
	public byte[] decrypt(byte[] bInputArr) throws EncryptException {
		AssertUtil.isNotEmpty(bInputArr);

		char[] cInputArr = new char[bInputArr.length];
		for (int loop = 0; loop < bInputArr.length; loop++) {
			cInputArr[loop] = (char) bInputArr[loop];
		}

		return Base64.decode(cInputArr);

	}

	/**
	 * 加密方法
	 */
	public byte[] encrypt(byte[] bInputArr) throws EncryptException {
		
		AssertUtil.isNotEmpty(bInputArr);
		char[] cOutputArr = Base64.encode(bInputArr);

		String temp = new String(cOutputArr);

		return temp.getBytes();

	}

}
