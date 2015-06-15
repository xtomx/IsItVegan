package Main;

import gui.MainGUI;

import java.util.Iterator;

import Data.Food;
import Data.FoodContainer;
import Data.IsVegan;

public class Main {

	public static void main(String[] args) {

		FoodContainer foodContainer = null;
		
		

		try {

			foodContainer = FoodContainer.instance();
			
			foodContainer.linkAlleFood(new Food("Schokolade","Valsoya", "Schokolade", 6756743,IsVegan.VEGETARIAN));
			foodContainer.linkAlleFood(new Food("Haselnuss","Seeberger", "Nüsse", 6756743,IsVegan.VEGAN));
			foodContainer.linkAlleFood(new Food("Zitronenkuchen","Glücks Bäck", "Kuchen", 6756743,IsVegan.NONVEGAN));
			
			Iterator<Food> iter = foodContainer.iterator();
			
			while(iter.hasNext()){
				
				System.out.println(iter.next());
				
			}
			

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		
		new MainGUI();
		

	}

}
