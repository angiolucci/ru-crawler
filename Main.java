import crawler.data.*;
import crawler.model.Meal;
import crawler.view.MealViewer;

public class Main {
	public static void main(String[] args) {
		DataRetriever dr = new DataRetriever("http://www.sorocaba.ufscar.br/ufscar/?cardapio");
		Parser parser = new Parser(dr.retrieve());
		Meal[] meals = parser.parse();
		MealViewer mv = new MealViewer(meals);
		mv.print();		
	}
}
