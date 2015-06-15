package gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Data.IsVegan;

public abstract class AbstraktGUI extends Dialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TextField produktText, herstellerText, barcodeText, typeText;
	private Label produktLabel, herstellerLabel, barcodeLabel, typeLabel;
	private Button ok, cancel;
	private Checkbox veganBox, vegetarianBox;

	public AbstraktGUI(MainGUI mainGUI, String title) {

		super(mainGUI, title, true);

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});

	}

	public void layoutAbstraktGUI() {

		setLayout(new GridLayout(2, 1));

		Panel one = new Panel(new GridLayout(4, 2));

		produktLabel = new Label("Produkt Name:");
		produktText = new TextField(20);

		one.add(produktLabel);
		one.add(produktText);

		herstellerLabel = new Label("Hersteller:        ");
		herstellerText = new TextField(20);

		one.add(herstellerLabel);
		one.add(herstellerText);

		typeLabel = new Label("Produktkategorie:");
		typeText = new TextField(20);

		one.add(typeLabel);
		one.add(typeText);

		barcodeLabel = new Label("Barcode:");
		barcodeText = new TextField(20);

		one.add(barcodeLabel);
		one.add(barcodeText);

		add(one);

		Panel two = new Panel(new GridLayout(2, 1));

		Panel two1 = new Panel();

		veganBox = new Checkbox("Vegan", false);
		vegetarianBox = new Checkbox("Vegetarian", false);

		two1.add(veganBox);
		two1.add(vegetarianBox);

		Panel two2 = new Panel();

		ok = new Button("OK");
		cancel = new Button("CANCEL");

		two2.add(ok);
		two2.add(cancel);

		two.add(two1);
		two.add(two2);

		add(two);

		ok.addActionListener(this);
		cancel.addActionListener(this);

		pack();

		windowPosition();

		
	}

	private void windowPosition() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getWidth() / 2;
		int h = this.getHeight() / 2;
		int x = (dim.width / 2) - w;
		int y = (dim.height / 2) - h;

		setLocation(x, y);

	}

	public String getProduktText() {

		return produktText.getText();

	}
	
	public void setProduktText(String t){
		
		produktText.setText(t);
		
	}

	public String getHerstellerText() {

		return herstellerText.getText();

	}
	
	public void setHerstellerText(String t){
		
		herstellerText.setText(t);
		
	}

	public long getBarcodeText() {

		return Long.parseLong(barcodeText.getText());

	}
	
	public void setBarcodeText(long l){
		
		barcodeText.setText(new Long(l).toString());
		
	}

	public String getTypeText() {

		return typeText.getText();

	}
	
	public void setTypeText(String t){
		
		typeText.setText(t);
		
	}

	public IsVegan getVeganBox() throws Exception {

		if (veganBox.getState() && !vegetarianBox.getState()) {
			return IsVegan.VEGAN;
		} else if (!veganBox.getState() && vegetarianBox.getState()) {
			return IsVegan.VEGETARIAN;
		} else if (!veganBox.getState() && !vegetarianBox.getState()) {
			return IsVegan.NONVEGAN;
		} else {
			throw new Exception("Fehler bei getVeganBox");
		}

	}
	
	public void setVegan(IsVegan isVegan){
		
		if(isVegan.equals(IsVegan.VEGAN)){
			
			veganBox.setState(true);
			
		}else if(isVegan.equals(IsVegan.VEGETARIAN)){
			
			vegetarianBox.setState(true);
			
		}
		
	}

}
