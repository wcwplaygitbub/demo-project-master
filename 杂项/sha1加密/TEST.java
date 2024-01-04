import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class TEST {


    /**
     * 计算包的hash 使用sha1
     * @param args
     */
    public static void main(String[] args) {
        String filename = "/Users/wangchuanwen01/Downloads/bvdclient-windows-1.3.3.4.zip"; // 替换成你要计算哈希值的文件路径
        try {
            byte[] buffer = new byte[8192];
            int count;
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            InputStream is = new FileInputStream(filename);
            while ((count = is.read(buffer)) > 0) {
                md.update(buffer, 0, count);
            }
            is.close();
            byte[] hash = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            System.out.println("SHA-1 checksum of file \"" + filename + "\":");
            System.out.println(hexString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
