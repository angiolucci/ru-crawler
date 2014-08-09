import crawler.data.DataRetriever;
import crawler.model.Meal;
import crawler.view.MealViewer;

public class Main {
	public static void main(String[] args) {
		DataRetriever dr = new DataRetriever(
				"http://www.sorocaba.ufscar.br/ufscar/?cardapio");
		Meal[] meals = dr.retrieve();
		MealViewer mv = new MealViewer(meals);
		mv.print();
	}
}
