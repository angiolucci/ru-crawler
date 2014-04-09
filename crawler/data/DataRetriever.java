package crawler.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class DataRetriever {
	private String dataSource;

	public DataRetriever(String url) {
		this.dataSource = url;
	}

	public String retrieve() {
		BufferedReader reader = null;
		String output = new String();
		
		try {
			URL url = new URL(this.dataSource);
			reader = new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-1"));
		    for (String line; (line = reader.readLine()) != null;)
		        output = output + "\n" + line;
		        
		} catch (MalformedURLException e) {
			System.out.println("URL inválida.");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Codificação inválida");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Erro de IO");
			System.exit(-1);
		} finally {
			if (reader != null) try { reader.close(); } catch (IOException ignore) {}
		}
		
		return output;
	}

}
