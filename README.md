# project5

For this project I created 2 classes, HammingDistanceFrame() and calHammingDistance(). HammingDistanceFrame() is the class that creates 
the GUI.

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
  
Above are all the private member variables of HammingDistanceFrame(). FRAME_WIDTH and FRAME_HEIGHT are used to set the frame's size in the
constructor. enterHammingDist is the JLabel next to the JTextField hammingDistanceInfo which used to show the value of the JSlider slider.
showStation is the button when clicked it displays all the staions that are (value of the JSlide) hamming distance away for the station
that is in the JComboBox stationBox that I called inside of the constructor. All of the stations are stored inside of the staionList 
JTextField. calculateHD is the JButton that when pressed will calculate the hammingdistance of the selected station that is in the 
JComboBox and display the number of stations that are a certain distance away in their respective JTextField, text0, text1, text2, text3,
and text4 which display a hamming distance of 0, 1, 2, 3, and 4 respectively. The addStation button is a JButton that adds a button that
the user inputs inside of the JTextField next to the button.

Inside of the Constructor off HammingDistanceFrame I create all of the panels to create the layout that is required for this project and 
I add all the slider, buttons, textfields, and textarea to their respective position. The action listeners for the buttons and slider
do what I described above for its respective button. For the free zone I just created a reset button because I could not think of 
anything super creative. It just clears the textarea and the textfield that displays the stations that are a hammingdistance away equal
to the value of the JSlider. The other method in the HammingDistanceFrame is main which just calls new HammingDistanceFrame().

The second class that I created was calHammingDist(). 

private List<String> stations;

There was only 1 private member variable, stations, which is the list of the stations that are read in from the text "Mesonet.txt".
I didn't create a default constructor because it wouldn't do anything. i created a read method that takes a string parameter
that is the filename that holds that stations in it and it returns a list that holds all of those stations. It uses a BufferedReader
to read every line of the textfile and stores it inside of an ArrayList that is called inside of the method.This method is called in
the HammningDistanceFrame constructor to be put inside of the JComboBox so that it can display all of these stations. The second
method from this class was a method called distances that takes a parameter string that is the staion id that is being compared to the
other stations and returns a int array that has the value of stations that are a particular distance away from the station. The third
and final method created was a method called showStationList which takes in 2 parameters, a string station id and an int hamming 
distance which is the value of the JSlider and returns and arraylist of all the stations that are that hamming distance away from the
station id.












