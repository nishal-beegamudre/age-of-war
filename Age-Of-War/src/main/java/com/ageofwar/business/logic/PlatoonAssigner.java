package com.ageofwar.business.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.ageofwar.entity.parent.Platoon;
import com.ageofwar.utility.Utility;

/**
 * This is the class which holds the business logic of assigning platoons.
 *
 * @author [Nishal Beegamudre]
 */
public class PlatoonAssigner {
	
	/**
	 * Assigns platoons as per own and opponent platoons.
	 * It involves extensive usage of data structures, object oriented programming, Stream API and functional style programming.
	 *
	 * @param opponentPlatoons String value of opponentPlatoons.
	 * @param ownPlatoons String value of ownPlatoons.
	 * @return Returns a string output.
	 */
	public String assignPlatoons(String ownPlatoons, String opponentPlatoons) {
		
		try {
		
		String[] ownPlatoonSegments = ownPlatoons.split(";");
		String[] opponentPlatoonSegments = opponentPlatoons.split(";");
		
		Map<String,Integer> ownPlatoonToQuantityMap = new LinkedHashMap<String,Integer>();
		Map<String,Integer> opponentPlatoonToQuantityMap = new LinkedHashMap<String,Integer>();
		
		// Converts the string input into a map of soldier type with its respective quantity using Stream API.
		
		Arrays.stream(ownPlatoonSegments).forEach(e->{
			String[] elements = e.split("#");
			ownPlatoonToQuantityMap.put(elements[0], Integer.valueOf(elements[1]));
		});
		
		Arrays.stream(opponentPlatoonSegments).forEach(e->{
			String[] elements = e.split("#");
			opponentPlatoonToQuantityMap.put(elements[0], Integer.valueOf(elements[1]));
		});
		
		
		Map<String,Integer> outputPlatoonToQuantityMap = platoonStrengthChecker
				(ownPlatoonToQuantityMap,opponentPlatoonToQuantityMap);
		
		if(outputPlatoonToQuantityMap==null) {
			return "There is no chance of winning";
		}else {
			
			// converts output map of soldier type to its quantity into a string
			
			StringBuilder outputPlatoonsBuilder = new StringBuilder();
			
			outputPlatoonToQuantityMap.keySet().stream().forEach(element->{
				outputPlatoonsBuilder.append(element+"#"+outputPlatoonToQuantityMap.get(element).toString()+";");
			});
			
			outputPlatoonsBuilder.deleteCharAt(outputPlatoonsBuilder.length()-1);
			return outputPlatoonsBuilder.toString();
			
		}
		
		}catch(NumberFormatException e) {
			System.out.println("Exception has been thrown due to incorrect input on number conversions "+e.getMessage());
		}catch(Exception e) {
			System.out.println("Exception has been thrown "+e.getMessage());
		}
		
		return null;
		
	}

	private Map<String, Integer> platoonStrengthChecker(Map<String, Integer> ownPlatoonToQuantityMap,
			Map<String, Integer> opponentPlatoonToQuantityMap) {
		
		try {
		
			
		// It takes each opponent soldier type with a list of own soldier types which can win against that soldier type.	
		Map<String,List<String>> opponentNameToOwnAcceptedPlatoonsMap = new LinkedHashMap<String,List<String>>();
		
		
		for(Map.Entry<String, Integer> opponentEntry: opponentPlatoonToQuantityMap.entrySet()) {
			
			List<String> acceptableOwnPlatoonsList = new ArrayList<String>();
			
			for(Map.Entry<String, Integer> ownEntry: ownPlatoonToQuantityMap.entrySet()) {
				
				// Returns the instance of opponent Platoon by taking its soldier type as input.
				Platoon opponentPlatoon = Utility.getInstanceByString(opponentEntry.getKey(), 
						ownPlatoonToQuantityMap.get(ownEntry.getKey()));
				
				// Returns the instance of own Platoon by taking its soldier type as input.
				Platoon ownPlatoon = Utility.getInstanceByString(ownEntry.getKey(), 
						opponentPlatoonToQuantityMap.get(opponentEntry.getKey()));

				/* Compares the strength factor of opponent & own soldiers along 
					with their numbers and provides a weight value of 1, 0, -1.
					1 means our team can win against opponents, 0 means equal & -1 means weak.*/
				int ownToOpponentStrength = Utility.
						calculateWeight(ownEntry.getValue(), 
								opponentEntry.getValue(), 
								opponentPlatoon.getStrengthFactor(ownEntry.getKey()),
								ownPlatoon.getStrengthFactor(opponentEntry.getKey()));
				
				// Only if value is 1 (win), it should be considered.
				if(ownToOpponentStrength==1) {
					acceptableOwnPlatoonsList.add(ownEntry.getKey());
				}
				
			}
			
			opponentNameToOwnAcceptedPlatoonsMap.put(opponentEntry.getKey(),acceptableOwnPlatoonsList);
			
			
		}

		return opponentToOwnPlatoonMapper(opponentNameToOwnAcceptedPlatoonsMap,ownPlatoonToQuantityMap);
		
		}catch(Exception e) {
			System.out.println("Exception has been thrown "+e.getMessage());
			return null;
		}
		
	}

	private Map<String, Integer> opponentToOwnPlatoonMapper(
			Map<String, List<String>> opponentNameToOwnAcceptedPlatoonsMap,
			Map<String, Integer> ownPlatoonToQuantityMap) {
		
		try {
		
		List<String> ownPlatoonsList = ownPlatoonToQuantityMap.keySet().stream()
				.collect(Collectors.toList());
		
		// To get the list of soldier types in the same insertion order, we have used a LinkedHashMap.
		List<String> opponentInsertionList = opponentNameToOwnAcceptedPlatoonsMap.keySet().stream()
				.collect(Collectors.toList());
		
		// Map which holds the data of respective opponent's soldier type against our soldier type.
		Map<String,String> opponentToOwn = new HashMap<String,String>();
		int winCounter = 0;
		int loseOrDrawCounter = 0;
		Set<String> usedPlatoons = new HashSet<String>();
		Map<String, Integer> outputPlatoonMapper = new LinkedHashMap<String, Integer>();
		
		/* flag values to control data flow inside the while -> iterator.
		 * It is required as we should take those combinations first which have only one instance, 
		 * then we should take the ones with zero instances & then the ones with more instances.
		 */
		boolean flag2=false;
		
		while(opponentNameToOwnAcceptedPlatoonsMap.size()>0) {
			
			/* flag values to control data flow inside the iterator.*/
			boolean flag1=false;
			
			// We need to remove the map entry while it is under iterator. Hence, iterator is used in place of for loop.
			Iterator<Map.Entry<String, List<String>>> iterator = opponentNameToOwnAcceptedPlatoonsMap.entrySet()
					.iterator();
			
			while (iterator.hasNext()) {
			
				Map.Entry<String, List<String>> entry = iterator.next();
				
				// It removes already used soldier types from all the entries dynamically.
				List<String> platoonsSet = entry.getValue();
				platoonsSet.removeAll(usedPlatoons);
				opponentNameToOwnAcceptedPlatoonsMap.replace(entry.getKey(), platoonsSet);
				
				// Always give more priority to combinations with exactly one soldier type which can win over opponents.
				if((!entry.getValue().isEmpty())&&(entry.getValue().size()==1)){
					String value = entry.getValue().get(0);
					opponentToOwn.put(entry.getKey(), value);
					winCounter++;
					iterator.remove();
					usedPlatoons.add(value);
					ownPlatoonsList.remove(value);
					flag1 = true;
				}

				// 2nd priority would be for those which cannot win against the opponents.
				if(entry.getValue().isEmpty()) {
					opponentToOwn.put(entry.getKey(), "No Entry");
					loseOrDrawCounter++;
					iterator.remove();
					flag1 = true;
				}

				// Give 3rd priority to entries with more than 1 winning combinations. Just remove one by one & allocate them effectively.
				if((flag2)) {

					String value = entry.getValue().get(0);
					opponentToOwn.put(entry.getKey(), value);
					winCounter++;
					iterator.remove();
					usedPlatoons.add(value);
					ownPlatoonsList.remove(value);
					flag1 = true;
					flag2 = false;

				}

			}
			
			if(!flag1) {
				flag2 = true;
			}else {
				flag2 = false;
			}
			
		}

		// Only if win counter is 3 or more than 3, return the values.
		if(winCounter>=3) {
			
			// Allocate values according to the opponents' insertion order. If it cannot be defeated, then select any unused value of own soldier type.
			for(String entry: opponentInsertionList) {
				
				String ownPlatoon;
				if(opponentToOwn.get(entry).equals("No Entry")) {
					ownPlatoon = ownPlatoonsList.get(0);
				}else {
					ownPlatoon = opponentToOwn.get(entry);	
				}
				outputPlatoonMapper.put(ownPlatoon, ownPlatoonToQuantityMap.get(ownPlatoon));
				
			}

			return outputPlatoonMapper;
			
		}else {
			return null;
		}
		
		}catch(Exception e) {
			System.out.println("Exception has been thrown "+e.getMessage());
			return null;
		}

	}

}
