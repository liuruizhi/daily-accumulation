package com.tcp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liuruizhi
 * @since 2019/5/29
 */
public class ClientTcp {

    public static void main(java.lang.String[] args) {

        try {
            Socket client = new Socket("localhost", 6066);
            //获取输出流对象
            OutputStream os = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(os);

            //byte[] bt = str.getBytes();
            out.writeUTF("sfds");
            System.out.println("------------");
            //获取输入流对象
            InputStream is = client.getInputStream();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte[] bytes = new byte[1024];
            int count = 0;
            while ((count = is.read(bytes)) >= 0) {
                bos.write(bytes, 0, count);
            }
            bytes = bos.toByteArray();

            //释放资源
            //os.close();
            client.close();
            System.out.println(new java.lang.String(bytes, "utf-8"));

        } catch (Exception e) {

        }
    }
}
