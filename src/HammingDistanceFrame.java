import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HammingDistanceFrame extends JFrame{
	
	private static final int FRAME_WIDTH = 100;
	private static final int FRAME_HEIGHT = 200;
	
	private JLabel enterHammingDist = new JLabel("Enter Hamming Dist:");
	private JTextField hammingDistanceInfo = new JTextField(5);
	private JSlider slider = new JSlider(1,4,1);
	private JButton showStation = new JButton("Show Station");
	private JTextArea stationList = new JTextArea();
	private JLabel compareWith = new JLabel("Compare with:");
	private JButton calculateHD = new JButton("Calculate HD");
	private JLabel distance0 = new JLabel("Distance 0");
	private JTextField text0 = new JTextField(5);
	private JLabel distance1 = new JLabel("Distance 1");
	private JTextField text1 = new JTextField(5);
	private JLabel distance2 = new JLabel("Distance 2");
	private JTextField text2 = new JTextField(5);
	private JLabel distance3 = new JLabel("Distance 3");
	private JTextField text3 = new JTextField(5);
	private JLabel distance4 = new JLabel("Distance 4");
	private JTextField text4 = new JTextField(5);
	private JButton addStation = new JButton("Add Button");
	private JTextField addInfo = new JTextField(5);
	
	public HammingDistanceFrame() throws IOException {
		super("HammingDistanceFrame");
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLayout(new GridLayout(0,2));
		
		JPanel leftPanel = new JPanel(new GridLayout(12,1)); // panel for all the important code for the project
		JPanel rightPanel = new JPanel(new GridLayout(1,1)); // panel for the extra part of the project
		
		calHammDist hamm = new calHammDist();
		JComboBox stationBox = new JComboBox(hamm.read("Mesonet.txt").toArray());
		
		JPanel panel0 = new JPanel(); // top left panel
		panel0.add(enterHammingDist);
		hammingDistanceInfo.setEditable(false);
		hammingDistanceInfo.setText("1");
		panel0.add(hammingDistanceInfo);
		leftPanel.add(panel0);
		
		JPanel panel1 = new JPanel();
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener((e) -> {
			String slideValue = "" + slider.getValue();
			hammingDistanceInfo.setText(slideValue);
			hammingDistanceInfo.repaint();
		});
		panel1.add(slider);
		leftPanel.add(panel1);
		
		JPanel panel2 = new JPanel();
		showStation.addActionListener((e) -> {
			ArrayList<String> hammingWords = hamm.showStationList((String)stationBox.getSelectedItem(),slider.getValue());
			
			if(hammingWords.size() == 0) {
				stationList.setText("");
				stationList.repaint();
			} else {
					stationList.setText(hammingWords.get(0) + "\n");
					for(int i = 1; i < hammingWords.size(); ++i) {
						stationList.append(hammingWords.get(i) + "\n");
					}
			}
		});
		panel2.add(showStation);
		leftPanel.add(panel2);
		
		JPanel panel3 = new JPanel();
		stationList.setPreferredSize(new Dimension(100, 300));
		stationList.setEditable(false);
		panel3.add(stationList);
		leftPanel.add(panel3);
		
		//need help on this part
		JPanel panel4 = new JPanel();
		panel4.add(compareWith);
		panel4.add(stationBox); 
		leftPanel.add(panel4);
		
		JPanel panel5 = new JPanel();
		calculateHD.addActionListener((e) -> {
			String selectedStation = (String) stationBox.getSelectedItem();
			int[] distance = hamm.distances(selectedStation);
			text0.setText(String.valueOf(distance[0]));
			text1.setText(String.valueOf(distance[1]));
			text2.setText(String.valueOf(distance[2]));
			text3.setText(String.valueOf(distance[3]));
			text4.setText(String.valueOf(distance[4]));
		});
		panel5.add(calculateHD);
		leftPanel.add(panel5);
		
		JPanel panel6 = new JPanel();
		panel6.add(distance0);
		text0.setEditable(false);
		panel6.add(text0);
		leftPanel.add(panel6);
		
		JPanel panel7 = new JPanel();
		panel7.add(distance1);
		text1.setEditable(false);
		panel7.add(text1);
		leftPanel.add(panel7);
		
		JPanel panel8 = new JPanel();
		panel8.add(distance2);
		text2.setEditable(false);
		panel8.add(text2);
		leftPanel.add(panel8);
		
		JPanel panel9 = new JPanel();
		panel9.add(distance3);
		text3.setEditable(false);
		panel9.add(text3);
		leftPanel.add(panel9);
		
		JPanel panel10 = new JPanel();
		panel10.add(distance4);
		text4.setEditable(false);
		panel10.add(text4);
		leftPanel.add(panel10);
		
		JPanel panel11 = new JPanel();
		addStation.addActionListener((e) -> {
			String newStation = addInfo.getText();
			stationBox.addItem((Object) newStation);
			stationBox.repaint();
			
		});
		panel11.add(addStation);
		panel11.add(addInfo);
		leftPanel.add(panel11);
		
		this.add(leftPanel);
		
		JButton reset = new JButton("RESET");
		reset.addActionListener((e) -> {
			stationList.setText("");
			stationList.repaint();
			text0.setText("0");
			text1.setText("0");
			text2.setText("0");
			text3.setText("0");
			text4.setText("0");
		});
		
		rightPanel.add(reset);
		this.add(rightPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	    this.setVisible(true);
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new HammingDistanceFrame();

	}

}
