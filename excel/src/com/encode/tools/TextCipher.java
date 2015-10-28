package com.encode.tools;

import java.security.GeneralSecurityException;

public interface TextCipher {

	/**
     * 初始化
     * 
     * @param salt 
     */
    public void init (String salt);
    
    /**
     * 加密信息
     * 
     * @param value
     * @return 
     * @throws java.security.GeneralSecurityException 
     */
    public String encrypt(String value) throws GeneralSecurityException;
    
    /**
     * 解密信息
     * 
     * @param value
     * @return 
     * @throws java.security.GeneralSecurityException 
     */
    public String decrypt(String value) throws GeneralSecurityException;
}
