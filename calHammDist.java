import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class calHammDist {
	
	private List<String> stations; // holds all the stations
	
	
	public List<String> read(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		stations = new ArrayList<>(); // creates an arraylist for the stations
		String station = br.readLine();
		while(station != null) { // keeps reading the file until there is nothing left
			stations.add(station.substring(0,4));
			station = br.readLine();
		}
		br.close();
		return stations;
	}
	
	public int[] distances(String stationID) {
		// variables to store the hammingdistances
		int d0 = 0;
		int d1 = 0;
		int d2 = 0;
		int d3 = 0;
		int d4 = 0;
		
		int distance = 0;
		int arrayIndex;
		int stringIndex = 0;
		
		for(arrayIndex = 0; arrayIndex < stations.size(); ++arrayIndex) {
			if(stationID != stations.get(arrayIndex)) {
				while(stringIndex < stationID.length()) {
					if(stationID.charAt(stringIndex) != stations.get(arrayIndex).charAt(stringIndex)) {
						++distance;
					}
					++stringIndex;
				}
				
				if(distance == 1) { /*  if hammingdistance is 1 then add 1 to d1 which means that is the number of stations that
					 is a hamming distance 1 away from the station, the same for the other else statements with their
					 respective number */
					++d1;
				} else if(distance == 2) {
					++d2;
				} else if(distance == 3) {
					++d3;
				} else if (distance == 4) {
					++d4;
				} else {
					++d0;
				}
				
				distance = 0;
				stringIndex = 0; 
			}
		}
		
		int[] distances = {d0, d1, d2, d3, d4};		
		return distances;
	}
	
	public ArrayList<String> showStationList(String stationID, int hammingDistance){
		
		// arraylist of stations that are a certain hammingdistance from the inputed station
		ArrayList<String> showList = new ArrayList<>(); 
		
		for(int arrayIndex = 0; arrayIndex < stations.size(); ++arrayIndex) {
			int hamming = 0;
			
			for(int stringIndex = 0; stringIndex < stationID.length(); ++stringIndex) {
				
				if(stationID.charAt(stringIndex) != stations.get(arrayIndex).charAt(stringIndex)) {
					++hamming;
				}
			}
			
			if(hamming == hammingDistance) {
				showList.add(stations.get(arrayIndex));
			}
		}
		return showList;
	}
}
