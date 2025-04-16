package com.ageofwar.entity.child;

import java.util.HashMap;
import java.util.Map;

import com.ageofwar.entity.parent.Platoon;

/**
 * This is the class which holds FootArcher.
 *
 * @author [Nishal Beegamudre]
 */
public class FootArcher extends Platoon {
	
	private static Map<String,Integer> strengthFactorMap = new HashMap<String,Integer>();
	
	{
		strengthFactorMap.put("Militia", 2);
	    strengthFactorMap.put("Spearmen", 1);
	    strengthFactorMap.put("LightCavalry", 1);
	    strengthFactorMap.put("HeavyCavalry", 1);
	    strengthFactorMap.put("FootArcher", 1);
	    strengthFactorMap.put("CavalryArcher", 2);
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
	
	public FootArcher(int numberOfSoldiers) {
		this.setNumberOfSoldiers(numberOfSoldiers);
	}
	

}
