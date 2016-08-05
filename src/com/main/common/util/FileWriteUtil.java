package com.main.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class FileWriteUtil {
	
	public static String SaveFileFromInputStream(InputStream stream,String path,String suffix) throws IOException   
    {   
    	String fileName = DateUtil.format(new Date(), "yyyyMMdd")+RandomStrUtil.getCharAndNumr(5)+"."+suffix;
        String savePath = path + File.separatorChar+ fileName;
    	FileOutputStream fs=new FileOutputStream(savePath);   
        byte[] buffer =new byte[1024*1024];   
        int bytesum = 0;   
        int byteread = 0;    
        while ((byteread=stream.read(buffer))!=-1)   
        {   
           bytesum+=byteread;   
           fs.write(buffer,0,byteread);   
           fs.flush();   
        }    
        fs.close();   
        stream.close();
		return savePath;         
   }         
}
