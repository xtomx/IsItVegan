package gui;

import java.awt.event.ActionEvent;

import Data.Food;
import Data.FoodContainer;

public class AddGUI extends AbstraktGUI {

	private static final long serialVersionUID = 1L;

	private FoodContainer foodContainer;

	public AddGUI(MainGUI mainGUI, String title) {
		super(mainGUI, title);

		super.layoutAbstraktGUI();
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("CANCEL")) {
			dispose();
		}

		if (e.getActionCommand().equals("OK")) {
			add();
			dispose();

		}
	}

	public void add() {
		
		try {
			foodContainer = FoodContainer.instance();
			
			foodContainer.linkAlleFood(new Food(super.getProduktText(), super
					.getHerstellerText(), super.getTypeText(), super
					.getBarcodeText(), super.getVeganBox()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
