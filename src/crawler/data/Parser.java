package crawler.data;

import crawler.model.Meal;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {
	private String htmlContent;
	private String preParsedHtml;

	public Parser(String content) {
		if (content != null)
			this.htmlContent = content;
		
		this.preParsedHtml = null;
	}
	
	public String getParsedHtml(){
		return this.preParsedHtml;
	}

	public void setHtmlContent(String content) {
		if (content != null)
			this.htmlContent = content;
	}

	public Meal[] parse(){
		Document doc = Jsoup.parse(this.htmlContent);
		
		/*
		 * meals[0,1,...,4] --> Almoço
		 * meals[5,6,...,9] --> Jantar
		 */
		Meal[] meals = new Meal[10];
		Elements items = doc.getElementsByTag("Map");
		this.preParsedHtml = items.toString();
		doc = Jsoup.parse(this.preParsedHtml);
		
		items = doc.getElementsByTag("td");
		
		for (int i = 0; i < 10; i++) {
			Document tmpDoc;
			Elements tmpElm;
			meals[i] = new Meal();
		
			//Data
			tmpDoc = Jsoup.parse(items.toString());
			tmpElm = tmpDoc.getElementsByTag("strong");
			
			if (i < 5) { // Almoço
				meals[i].setData(tmpElm.get(i+6).html());
			} else {	// Jantar
				meals[i].setData(tmpElm.get(i+43).html());
			}
			
			//Prato principal
			tmpDoc = Jsoup.parse(items.html());
			tmpElm = tmpDoc.getElementsByTag("p");
			
			if (i < 5) { // Almoço
				meals[i].setPrinc(tmpElm.get(i*11 + 1).html());
			} else {	// Jantar
				meals[i].setPrinc(tmpElm.get(i*11 + 37).html());
			}
			
			//Guarnição	
			if (i < 5) { // Almoço
				meals[i].setGuarn(tmpElm.get(i*11 + 4).html());
			} else {	// Jantar
				meals[i].setGuarn(tmpElm.get(i*11 + 40).html());
			}
						
			
			//Salada	
			if (i < 5) { // Almoço
				meals[i].setSalad(tmpElm.get(i*11 + 7).html());
			} else {	// Jantar
				meals[i].setSalad(tmpElm.get(i*11 + 43).html());
			}
			
			//Sobremesa	
			if (i < 5) { // Almoço
				meals[i].setSobrm(tmpElm.get(i*11 + 10).html());
			} else {	// Jantar
				meals[i].setSobrm(tmpElm.get(i*11 + 46).html());
			}
			
			//Prato principal vegetariano
			if (i < 5) { // Almoço
				meals[i].setVegPrinc(tmpElm.get(i*7 + 59).html());
			} else {	// Jantar
				meals[i].setVegPrinc(tmpElm.get(i*7 + 115).html());
			}
			
			//Guarnição vegetariano
			if (i < 5) { // Almoço
				meals[i].setVegGuarn(tmpElm.get(i*7 + 62).html());
			} else {	// Jantar
				meals[i].setVegGuarn(tmpElm.get(i*7 + 118).html());
			}
		}
		
		Meal[] orderedMeals = new Meal[10];
		int j = 0, k = 5;
		for (int i = 0; i < 10; i++){
			if (i % 2 == 0)
				orderedMeals[i] = meals[j++];
			else
				orderedMeals[i] = meals[k++];
		}

		
		return orderedMeals;		
	}
}
