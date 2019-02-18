package com.longyg.sftp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.jcraft.jsch.ChannelSftp;

public class SFTPTest {

    public SFTPChannel getSFTPChannel() {
        return new SFTPChannel();
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SFTPTest test = new SFTPTest();

        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "192.83.186.127");
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "hyweb");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, "1q2w3e4r");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");
        
        String src = "/home/hyweb/will/20180124102801.log"; 
        String dest = "D:\\will\\maintenance\\期刊\\hyftdlog\\will\\20180124102801.log"; 
        
              
        SFTPChannel channel = test.getSFTPChannel();
        ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
        
        File file = new File(src);
        long fileSize = file.length();
        
        /**
         * 代码段1
        OutputStream out = chSftp.put(dst, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE); // 使用OVERWRITE模式
        byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
        int read;
        if (out != null) {
            System.out.println("Start to read input stream");
            InputStream is = new FileInputStream(src);
            do {
                read = is.read(buff, 0, buff.length);
                if (read > 0) {
                    out.write(buff, 0, read);
                }
                out.flush();
            } while (read >= 0);
            System.out.println("input stream read done.");
        }
        **/
        
        chSftp.get(src, dest, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE); // 代码段2
        
        // chSftp.put(new FileInputStream(src), dst, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE); // 代码段3
        
        chSftp.quit();
        channel.closeChannel();
    }
}
