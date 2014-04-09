package crawler.model;

public class CacheFile {
	private String data;
	private String htmlContent;
	
	private String dateFormatter;
	
	public CacheFile(String data, String htmlContent){
		this.data = data;
		this.htmlContent = htmlContent;
	}
}
