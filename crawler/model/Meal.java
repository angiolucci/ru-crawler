package crawler.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import crawler.data.StringHandler;

public class Meal {
	private Date data;
	
	private String princ;
	private String guarn;
	private String salad;
	private String sobrm;
	
	private String vegPrinc;
	private String vegGuarn;
	
	private SimpleDateFormat dateFormatter;
	
	public Meal(){
		this.data = new Date();
		
		this.princ = new String();
		this.guarn = new String();
		this.salad = new String();
		this.sobrm = new String();
		
		this.vegPrinc = new String();
		this.vegGuarn = new String();
		
		this.dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		if (data != null)
			this.data = data;
	}

	public String getPrinc() {
		return princ;
	}

	public void setPrinc(String princ) {
		if (princ != null)
			this.princ = StringHandler.convertHtmlPattern(princ);
	}

	public String getGuarn() {
		return guarn;
	}

	public void setGuarn(String guarn) {
		if (guarn != null)
			this.guarn = StringHandler.convertHtmlPattern(guarn);
	}

	public String getSalad() {
		return salad;
	}

	public void setSalad(String salad) {
		if (salad != null)
			this.salad = StringHandler.convertHtmlPattern(salad);
	}

	public String getSobrm() {
		return sobrm;
	}

	public void setSobrm(String sobrm) {
		if (sobrm != null)
			this.sobrm = StringHandler.convertHtmlPattern(sobrm);
	}

	public String getVegPrinc() {
		return vegPrinc;
	}

	public void setVegPrinc(String vegPrinc) {
		if (vegPrinc != null)
			this.vegPrinc = StringHandler.convertHtmlPattern(vegPrinc);
	}

	public String getVegGuarn() {
		return vegGuarn;
	}

	public void setVegGuarn(String vegGuarn) {
		if (vegGuarn != null)
			this.vegGuarn = StringHandler.convertHtmlPattern(vegGuarn);
	}
	
	public String getStrData(){
		return dateFormatter.format(this.data);
	}
	
	public String getDayOfWeek(){
		SimpleDateFormat formatter = new SimpleDateFormat("E");
		return formatter.format(this.data);		
	}
	
	public void setData(String strDate){
		try {
			this.data = this.dateFormatter.parse(strDate);
		} catch (ParseException e) {
			System.out.println("WARNING: Erro na conversão de data");
		}	
	}
}