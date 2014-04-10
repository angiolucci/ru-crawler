package crawler.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import crawler.model.CacheFile;
import crawler.model.Meal;

public class DataRetriever {
	private String dataSource;

	public DataRetriever(String url) {
		this.dataSource = url;
	}

	public Meal[] retrieve() {
		String fullHtml = null;
		Meal[] meals = null;

		fullHtml = checkCache();
		if (fullHtml == null)
			fullHtml = checkNet();

		Parser parser = new Parser(fullHtml);
		try {
			meals = parser.parse();
		} catch (Exception ex){
			System.out.println("FATAL: Falha ao realizar parsing:");
			ex.printStackTrace();
			System.exit(-1);
		}

		writeCache(fullHtml, meals[meals.length - 1].getData());

		return meals;
	}

	private String checkNet() {
		BufferedReader reader = null;
		String output = new String();

		try {
			URL url = new URL(this.dataSource);
			reader = new BufferedReader(new InputStreamReader(url.openStream(),
					"ISO-8859-1"));
			for (String line; (line = reader.readLine()) != null;)
				output = output + "\n" + line;

		} catch (MalformedURLException e) {
			System.out.println("URL inválida.");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Codificação inválida.");
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Erro de E/S, impossível obter dados.");
			System.exit(-1);
		} catch (Exception e) {
			System.out.println("FATAL: Exception desconhecida: ");
			e.printStackTrace();
			System.exit(-1);
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException ignore) {
				}
		}

		return output;
	}

	private String checkCache() {
		Date currentDate = new Date();
		CacheFile readenCache = null;
		String strTmp = null;

		try {

			FileInputStream fin = new FileInputStream("cache.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);
			readenCache = (CacheFile) ois.readObject();
			ois.close();

		} catch (Exception ex) {
			readenCache = null;
		}

		if (readenCache == null)
			strTmp = null;
		else {
			if (readenCache.getDateVal().before(currentDate)) {
				System.out.println("WARNING: Cache expirado.");
				strTmp = null;
			} else {
				if (this.dataSource.equals(readenCache.getHtmlUrl()))
					strTmp = readenCache.getHtmlContent();
				else
					strTmp = null;
			}
		}

		return strTmp;

	}

	private boolean writeCache(String htmlContent, Date valDate) {
		CacheFile cf = new CacheFile();
		cf.setHtmlUrl(this.dataSource);
		cf.setHtmlContent(htmlContent);
		cf.setDateVal(valDate);

		try {

			FileOutputStream fout = new FileOutputStream("cache.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(cf);
			oos.close();

		} catch (Exception ex) {
			System.out.println("WARNING: Falhou ao escrever cache:");
			System.out.println(ex.getMessage());
		}

		return false;
	}

}
