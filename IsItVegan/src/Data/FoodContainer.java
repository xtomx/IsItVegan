package Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodContainer implements Iterable<Food>{

	private static FoodContainer unique = null;
	private List<Food> alleFood;

	private FoodContainer() {

		alleFood = new ArrayList<Food>();

	}

	public static FoodContainer instance() throws Exception {

		if (unique != null)
			return unique;
		if (unique == null) {
			unique = new FoodContainer();
			return unique;
		}

		throw new Exception("Fehler beim erstellen des FoodContainers!");

	}

	public void linkAlleFood(Food food) throws Exception{
		
		if(!alleFood.add(food))
			throw new Exception("Hinzufügen fehlgeschlagen!");
		
	}
	
	public void unlinkAlleFood(Food food) throws Exception{
		
		if(!alleFood.remove(food))
			throw new Exception("Löschen fehlgeschlagen!");
		
	}
	
	public Iterator<Food> iterator(){
		
		return alleFood.iterator();
		
	}
}
