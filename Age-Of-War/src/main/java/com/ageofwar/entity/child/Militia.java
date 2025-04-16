package com.ageofwar.entity.child;

import java.util.HashMap;
import java.util.Map;

import com.ageofwar.entity.parent.Platoon;

/**
 * This is the class which holds Militia.
 *
 * @author [Nishal Beegamudre]
 */
public class Militia extends Platoon{
	
	private static Map<String,Integer> strengthFactorMap = new HashMap<String,Integer>();
	
	{
		strengthFactorMap.put("Militia", 1);
	    strengthFactorMap.put("Spearmen", 2);
	    strengthFactorMap.put("LightCavalry", 2);
	    strengthFactorMap.put("HeavyCavalry", 1);
	    strengthFactorMap.put("FootArcher", 1);
	    strengthFactorMap.put("CavalryArcher", 1);
	}

	/**
	 * Get the strength factor.
	 *
	 * @param platoonInput soldier type.
	 * @return Returns weight value.
	 */
	@Override
	public Integer getStrengthFactor(String platoonInput) {
		
		return (strengthFactorMap.get(platoonInput)!=null) ? strengthFactorMap.get(platoonInput) : 0;
		
	}
	
	public Militia(int numberOfSoldiers) {
		this.setNumberOfSoldiers(numberOfSoldiers);
	}
	
}
