import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;


public class Download {

    public void download(String link) {
    	
    	try {
    		URL url = new URL(link);
            InputStream inputStream = url.openStream();
    		FileOutputStream fileOutputStream = new FileOutputStream("tabela/tabela.csv");
    		byte[] bytes = new byte[1024];
    		int len;
    		while ((len = inputStream.read(bytes)) != -1) {
    			fileOutputStream.write(bytes, 0, len);
    		}
    		fileOutputStream.close();
    		inputStream.close();
    		System.out.println("Download completo");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	

 }
}
