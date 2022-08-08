package com.gscf.wallpapers.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationHelper {

	private Integer totalArea = 0;
	private List<Integer> cubicRooms = new ArrayList<>();
	private List<Integer> repeatingRooms = new ArrayList<>();

	public String[][] retrieveDimentionsFromString(List<String> dimentionsStr) {

		String sides[][] = new String[dimentionsStr.size()][3];

		for (int i = 0; i <= dimentionsStr.size() - 1; i++) {
			sides[i] = dimentionsStr.get(i).split("x");
		}

		return sides;

	}

	public void calculateTotalArea(String[][] dimentionsStr, int[][] dimentions) {

		for (int i = 0; i <= dimentionsStr.length - 1; i++) {

			int l = Integer.parseInt(dimentionsStr[i][0]);
			int w = Integer.parseInt(dimentionsStr[i][1]);
			int h = Integer.parseInt(dimentionsStr[i][2]);

			dimentions[i][0] = l;
			dimentions[i][1] = w;
			dimentions[i][2] = h;

			int surfaceArea = calculateSurfaceArea(l, w, h);

			totalArea += surfaceArea;

			if (isCubic(l, w, h)) {
				cubicRooms.add(surfaceArea);
			}

			if (checkForDuplicates(dimentions)) {
				repeatingRooms.add(surfaceArea);
			}
		}
	}

	private boolean isCubic(int l, int w, int h) {
		return l == w ? w == h ? true : false : false;
	}

	private int calculateSurfaceArea(int l, int w, int h) {
		int sides[] = new int[] { l * w, w * h, h * l };

		Arrays.sort(sides);

		int surfaceArea = 2 * sides[0] + 2 * sides[1] + 2 * sides[2];
		int extra = sides[0];

		return surfaceArea + extra;
	}

	private boolean checkForDuplicates(int[][] dimentions) {
		for (int i = 0; i < dimentions.length; i++) {
			for (int j = i + 1; j < dimentions.length; j++) {
				if (dimentions[i][0] == dimentions[j][0] && dimentions[i][1] == dimentions[j][1]
						&& dimentions[i][2] == dimentions[j][2]) {
					return true;
				}
			}
		}

		return false;
	}

	public List<Integer> getCubicRooms() {
		return cubicRooms.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}

	public List<Integer> getRepeatingRooms() {
		return repeatingRooms;
	}

	public Integer getTotalArea() {
		return totalArea;
	}

}
