package com.ageofwar.entity.parent;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the parent class of Platoon used in the form of factory design pattern, 
 * except that a parent class is used instead of an interface.
 *
 * @author [Nishal Beegamudre]
 */
public class Platoon {
	
	private int numberOfSoldiers;
	
	private Map<String,Integer> strengthFactorMap = new HashMap<String,Integer>();

	/**
	 * Get the strength factor.
	 *
	 * @param platoonInput soldier type.
	 * @return Returns weight value.
	 */
    public Integer getStrengthFactor(String platoonInput) {
		
		return (strengthFactorMap.get(platoonInput)!=null) ? strengthFactorMap.get(platoonInput) : 0;
		
	}

	public int getNumberOfSoldiers() {
		return numberOfSoldiers;
	}

	public void setNumberOfSoldiers(int numberOfSoldiers) {
		this.numberOfSoldiers = numberOfSoldiers;
	}
	
	

}
