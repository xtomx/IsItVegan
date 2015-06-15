package gui;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Data.Food;
import Data.FoodContainer;

public class YesNoDialog extends Dialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int index;
	FoodContainer foodContainer;

	public YesNoDialog(MainGUI mainGUI, String arg1, int index) {
		super(mainGUI, "", true);

		this.index = index;

		layoutYesNoDialog(arg1);
	}

	public void layoutYesNoDialog(String a) {

		setLayout(new GridLayout(2, 1));

		Panel oben = new Panel();

		Label label = new Label(a);
		oben.add(label);
		add(oben);

		Panel unten = new Panel(new GridLayout(1, 2));

		Button yes = new Button("YES");
		Button no = new Button("NO");

		unten.add(yes);
		unten.add(no);

		add(unten);

		yes.addActionListener(this);
		no.addActionListener(this);

		pack();

		windowPosition();

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("YES")) {

			delete();
			dispose();

		}
		if (e.getActionCommand().equals("NO")) {

			dispose();

		}

	}

	private void windowPosition() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getWidth() / 2;
		int h = this.getHeight() / 2;
		int x = (dim.width / 2) - w;
		int y = (dim.height / 2) - h;

		setLocation(x, y);

	}

	public void delete() {

		try {
			foodContainer = FoodContainer.instance();

			List<Food> list = new ArrayList<Food>();

			for (Food food : foodContainer) {

				list.add(food);
			}

			foodContainer.unlinkAlleFood(list.get(index));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
