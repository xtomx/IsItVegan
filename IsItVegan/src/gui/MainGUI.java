package gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Data.Food;
import Data.FoodContainer;

public class MainGUI extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private List list;
	private FoodContainer foodContainer;
	private Button addButton, deleteButton, editButton, infoButton;

	public MainGUI() {

		super("IS IT VEGAN?");

		try {
			foodContainer = FoodContainer.instance();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		layoutMainGUI();

		update();

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}

		});

	}

	public void layoutMainGUI() {

		setLayout(new GridLayout(2, 1));

		list = new List(15);
		add(list);

		Panel unten = new Panel();

		addButton = new Button("Add");
		deleteButton = new Button("Delete");
		editButton = new Button("Edit");
		infoButton = new Button("Info");

		unten.add(addButton);
		unten.add(deleteButton);
		unten.add(editButton);
		unten.add(infoButton);

		addButton.addActionListener(this);
		deleteButton.addActionListener(this);
		editButton.addActionListener(this);
		infoButton.addActionListener(this);

		add(unten);

		pack();

		this.setSize(600, 600);

		windowPosition();

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add")) {

			new AddGUI(this, "ADD");
			update();

		}
		
		if(e.getActionCommand().equals("Edit")){
			
			int index = -1;
			
			index = list.getSelectedIndex();
			if(index > -1){
			new EditGUI(this, "EDIT", index);
			} else {
				System.out.println("Kein Element ausgewählt");
			}
			update();
			
		}
		if(e.getActionCommand().equals("Delete")){
			
			int index = -1;
			
			index = list.getSelectedIndex();
			
			if(index > -1){
			new YesNoDialog(this, "Wirklich löschen?", index);
			}else {
				System.out.println("Kein Element ausgewählt");
			}
			
			update();
			
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

	public void update() {

		list.removeAll();

		for (Food food : foodContainer) {

			list.add(food.toString());

		}

	}

}
