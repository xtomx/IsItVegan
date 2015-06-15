package gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import Data.Food;
import Data.FoodContainer;

public class EditGUI extends AbstraktGUI{
	
	
	private static final long serialVersionUID = 1L;
	
	

	private FoodContainer foodContainer;
	
	private Food food;
	
	public EditGUI(MainGUI mainGUI, String title, int index){
		
		super(mainGUI, title);
		
		try {
			foodContainer = FoodContainer.instance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		super.layoutAbstraktGUI();
		
		load(index);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CANCEL")) {
			dispose();
		}

		if (e.getActionCommand().equals("OK")) {
			edit();
			dispose();

		}
		
	}
	
	public void load(int index){
		
		List<Food> list = new ArrayList<Food>();
		
		for(Food food : foodContainer){
			
			list.add(food);
			
		}
		
		food = list.get(index);
		
		super.setProduktText(food.getProduktName());
		super.setHerstellerText(food.getHerstellerName());
		super.setTypeText(food.getType());
		super.setBarcodeText(food.getBarcode());
		super.setVegan(food.getVegan());
		
		
	}
	
	public void edit(){
		
		
		
	}

}
