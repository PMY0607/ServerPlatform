package com.pmy.platform.utils;

import cn.hutool.crypto.digest.DigestUtil;

public class MD5Util {
    
	/**
	 * @param text 明文
	 * @return 密文
	 */
	// 带秘钥加密
	public static String md5(String text) {
		// 加密后的字符串
		String md5str = DigestUtil.md5Hex(text);
		return md5str;
	}

}