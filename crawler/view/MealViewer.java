package crawler.view;

import crawler.model.Meal;

public class MealViewer {
	private Meal[] meals = null;

	public MealViewer(Meal[] meals) {
		if (meals != null && meals.length == 10)
			this.meals = meals;
	}

	public void print() {
		if (this.meals != null)
			for (int i = 0; i < this.meals.length; i++) {
				if (i % 2 == 0)
					System.out
							.println("=================== ALMOÇO ===================");
				else
					System.out
							.println("=================== JANTAR ===================");

				System.out.println("Data: " + meals[i].getDayOfWeek() + ", "
						+ meals[i].getStrData());

				if (meals[i].getPrinc()
						.equalsIgnoreCase(meals[i].getVegPrinc()))
					System.out.println("Principal: " + meals[i].getPrinc());
				else
					System.out.println("Principal: " + meals[i].getPrinc()
							+ " / " + meals[i].getVegPrinc());
				if (meals[i].getGuarn()
						.equalsIgnoreCase(meals[i].getVegGuarn()))
					System.out.println("Guarnição: " + meals[i].getGuarn());
				else
					System.out.println("Guarnição: " + meals[i].getGuarn()
							+ " / " + meals[i].getVegGuarn());
				
				System.out.println("Salada: " + meals[i].getSalad());
				System.out.println("Sobremesa: " + meals[i].getSobrm());
				System.out.println("\n");
			}
	}
}
