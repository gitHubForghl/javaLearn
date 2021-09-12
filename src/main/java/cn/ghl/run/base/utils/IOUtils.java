package cn.ghl.run.base.utils;

import java.io.*;

/**
 * @author tui
 */
public class IOUtils {
    private IOUtils(){}

    public static void copyFile(String src,String target){
        try (
                InputStream is=new FileInputStream(src);
                OutputStream os=new FileOutputStream(target);
                BufferedInputStream bis=new BufferedInputStream(is);
                BufferedOutputStream bos=new BufferedOutputStream(os);){
            int temp=0;
            while ((temp=bis.read())!=-1){
                bos.write(temp);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copyFile("D:\\MyApp\\temp\\b.txt","D:/MyApp/temp/c.txt");
    }
}
