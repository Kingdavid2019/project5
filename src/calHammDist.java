import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class calHammDist {
	
	private String stationID;
	private List<String> stations;
	
	
	public List<String> read(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		stations = new ArrayList<>(); // creates an arraylist for the stations
		String station = br.readLine();
		while(station != null) {
			stations.add(station.substring(0,4));
			station = br.readLine();
		}
		br.close();
		return stations;
	}
	
	public int[] distances(String stationID) {
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
				
				if(distance == 1) {
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
