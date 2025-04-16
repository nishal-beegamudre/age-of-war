package com.ageofwar.entity.child;

import java.util.HashMap;
import java.util.Map;

import com.ageofwar.entity.parent.Platoon;

/**
 * This is the class which holds CavalryArcher.
 *
 * @author [Nishal Beegamudre]
 */
public class CavalryArcher extends Platoon {
	
	private static Map<String,Integer> strengthFactorMap = new HashMap<String,Integer>();
	
	{
		strengthFactorMap.put("Militia", 1);
	    strengthFactorMap.put("Spearmen", 2);
	    strengthFactorMap.put("LightCavalry", 1);
	    strengthFactorMap.put("HeavyCavalry", 2);
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
	
	public CavalryArcher(int numberOfSoldiers) {
		this.setNumberOfSoldiers(numberOfSoldiers);
	}

}
