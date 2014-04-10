package crawler.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CacheFile implements Serializable{
	private String htmlUrl;
	private Date dateVal;
	private String htmlContent;

	//private SimpleDateFormat dateFormatter;

	public CacheFile() {
		this.htmlUrl = new String();
		dateVal = new Date(0); // A very old cache, zero time at 'the epoch'
		htmlContent = new String();
		//this.dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public Date getDateVal() {
		return dateVal;
	}

	public void setDateVal(Date dateVal) {
		this.dateVal = dateVal;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.dateVal + "\n");
		sb.append(this.htmlUrl + "\n");
		sb.append(this.htmlContent);

		return sb.toString();
	}
}
