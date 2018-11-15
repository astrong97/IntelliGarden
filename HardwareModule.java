package intelliGreen;

import java.util.ArrayList;

public class HardwareModule {

	/*
	 * This class simulates hardware systems that adjust the greenhouse environment
	 * to user selected values.
	 * 
	 */

	private ArrayList<Integer> current = new ArrayList<>();
	private ArrayList<Integer> desired = new ArrayList<>();

	private boolean airOn;
	private boolean humidifierOn;
	private boolean lightsOn;
	private boolean ventOn;
	private boolean irrigationOn;
	private boolean CO2releaseOn;
	

	private enum AirCond {
		HEATING, COOLING, OFF
	};

	private AirCond cond;

	public HardwareModule() {

	}

	public HardwareModule(ArrayList<Integer> current, ArrayList<Integer> desired) {
		this.setCurrent(current);
		this.setDesired(desired);
	}
	
	/**
	 * This method decided if the air conditioner will be set to heat,
	 * cool, or off depending on the value of the current and desired
	 * temperature.
	 * 
	 * @param currentTemp This is the current temperature in the room.
	 * 
	 * @param desiredTemp This is the desired temperature of the room.
	 * 					  The current temperature will be updated to
	 * 					  the desired temperature if not already equal.
	 */

	public void checkAir(int currentTemp, int desiredTemp) {
		if (currentTemp < desiredTemp) {
			setCond(AirCond.HEATING);
			setAirOn(true);
		} else if (currentTemp > desiredTemp) {
			setCond(AirCond.COOLING);
			setAirOn(true);
		} else {
			setCond(AirCond.OFF);
			setAirOn(false);
		}
		// TODO: should this method return an int value for the incremented/decremented
		// temperature?
	}

	/**
	 * This method will decide if the humidifier and/or vent will be
	 * set to on or off depending on the value of the current and
	 * desired humidity.
	 * 
	 * @param currentHumid This is the current humidity in the room.
	 * 
	 * @param desiredHumid This is the desired humidity of the room.
	 * 					   The current humidity will be updated to the
	 * 					   desired humidity if not already equal.
	 */
	public void checkHumidity(int currentHumid, int desiredHumid) {
		if (currentHumid < desiredHumid) {
			setHumidifierOn(true);
		} else if (currentHumid >= desiredHumid) {
			setVentOn(true);
			setHumidifierOn(false);
		} else {
			setVentOn(false);
			setHumidifierOn(false);
		}

	}
	
/**
 * This method checks if the humidifier is on or off.
 */
	public boolean isHumidifierOn() {
		return humidifierOn;
	}

	public void setHumidifierOn(boolean humidifierOn) {
		this.humidifierOn = humidifierOn;
	}

	//TODO: track hours
	public void checkLightsOn(int hour) {
		if (hour >= 8 && hour <= 18) {
			setLightsOn(true);
		}
		else {
		setLightsOn(false);
		}
	}
	
	public boolean isLightsOn() {
		return lightsOn;
	}

	public void setLightsOn(boolean lightsOn) {
		this.lightsOn = lightsOn;
	}

	public boolean isVentOn() {
		return ventOn;
	}

	public void setVentOn(boolean ventOn) {
		this.ventOn = ventOn;
	}

	public void checkMoisture(int currentMoisture, int desiredMoisture) {
		if (currentMoisture < desiredMoisture) {
			setIrrigationOn(true);
		} else {
			setIrrigationOn(false);
		}
	}

	public boolean isIrrigationOn() {
		return irrigationOn;
	}

	public void setIrrigationOn(boolean irrigationOn) {
		this.irrigationOn = irrigationOn;
	}
	
	public void checkCO2(int currentCO2, int desiredCO2) {
		if (currentCO2 < desiredCO2) {
			setCO2releaseOn(true);
		} else if (currentCO2 >= desiredCO2) {
			setVentOn(true);
			setCO2releaseOn(false);
		}else {
			setCO2releaseOn(false);
			setVentOn(false);
		}
	}

	public boolean isCO2releaseOn() {
		return CO2releaseOn;
	}

	public void setCO2releaseOn(boolean cO2releaseOn) {
		CO2releaseOn = cO2releaseOn;
	}

	public AirCond getCond() {
		return cond;
	}

	public void setCond(AirCond cond) {
		this.cond = cond;
	}

	public boolean isAirOn() {
		return airOn;
	}

	public void setAirOn(boolean airOn) {
		this.airOn = airOn;
	}

	public ArrayList<Integer> getCurrent() {
		return current;
	}

	public void setCurrent(ArrayList<Integer> current) {
		this.current = current;
	}

	public ArrayList<Integer> getDesired() {
		return desired;
	}

	public void setDesired(ArrayList<Integer> desired) {
		this.desired = desired;
	}

}