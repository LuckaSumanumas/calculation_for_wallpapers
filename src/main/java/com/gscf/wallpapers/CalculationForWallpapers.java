package com.gscf.wallpapers;

import java.util.List;
import java.util.logging.Logger;

import com.gscf.wallpapers.helpers.CalculationHelper;
import com.gscf.wallpapers.helpers.InputReader;

public class CalculationForWallpapers {

	public static void main(String... args) {
		Logger logger = Logger.getLogger(CalculationForWallpapers.class.getName());

		CalculationHelper calculationHelper = new CalculationHelper();
		InputReader inputReader = new InputReader();

		List<String> dimentionsList = inputReader.readFromInput();
		calculationHelper.retrieveDimentionsFromString(dimentionsList);
		calculationHelper.calculateSurfaceAreas();
		calculationHelper.checkForSameRooms();
		
		logger.info("Total area in square feet: " + calculationHelper.getTotalArea());
		logger.info("Cubic rooms in square feet: " + calculationHelper.getCubicRooms());
		logger.info("Same rooms in square feet: " + calculationHelper.getSameRooms());
	}
}
