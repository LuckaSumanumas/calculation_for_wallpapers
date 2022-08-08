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
		String[][] dimentionsStr = calculationHelper.retrieveDimentionsFromString(dimentionsList);

		int[][] dimentions = new int[dimentionsStr.length][3];

		calculationHelper.calculateTotalArea(dimentionsStr, dimentions);

		logger.info("Total area:" + calculationHelper.getTotalArea());
		logger.info("Cubic rooms:" + calculationHelper.getCubicRooms());
		logger.info("Repeating rooms:" + calculationHelper.getRepeatingRooms());
	}
}
