package com.encode.tools;

import java.security.GeneralSecurityException;

public interface TextCipher {

	/**
     * ��ʼ��
     * 
     * @param salt 
     */
    public void init (String salt);
    
    /**
     * ������Ϣ
     * 
     * @param value
     * @return 
     * @throws java.security.GeneralSecurityException 
     */
    public String encrypt(String value) throws GeneralSecurityException;
    
    /**
     * ������Ϣ
     * 
     * @param value
     * @return 
     * @throws java.security.GeneralSecurityException 
     */
    public String decrypt(String value) throws GeneralSecurityException;
}
