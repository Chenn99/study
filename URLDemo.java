package com.louis.communication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL 统一资源定位符
 */
public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://user0514.cdnw.net/shared/img/thumb/nekocyanPAKE4522-436_TP_V.jpg");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("c:\\yali.jpg"));
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = in.read(bytes))!=-1){
                out.write(bytes,0,length);
                out.flush();
            }
            in.close();
            out.close();
            System.out.println("下载成功");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
