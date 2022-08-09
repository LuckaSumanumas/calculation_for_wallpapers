package com.gscf.wallpapers.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationHelper {

	private Integer totalArea = 0;
	private List<List<Integer>> roomsSides = new ArrayList<>();
	private List<Integer> cubicRooms = new ArrayList<>();
	private List<Integer> sameRooms = new ArrayList<>();
	private HashMap<Integer, Integer> surfaceAreas = new HashMap<>();

	public void retrieveDimentionsFromString(List<String> dimentionsStr) {

		dimentionsStr.stream().forEach((dimentionStr) -> {
			String roomDimentions[] = dimentionStr.split("x");

			Integer l = Integer.parseInt(roomDimentions[0]);
			Integer w = Integer.parseInt(roomDimentions[1]);
			Integer h = Integer.parseInt(roomDimentions[2]);

			roomsSides.add(Arrays.asList(l, w, h));
		});
	}

	public void calculateSurfaceAreas() {

		for (int i = 0; i < roomsSides.size(); i++) {
			Integer l = roomsSides.get(i).get(0);
			Integer w = roomsSides.get(i).get(1);
			Integer h = roomsSides.get(i).get(2);
			
			int surfaceArea = calculateSurfaceArea(l, w, h);
			
			surfaceAreas.put(i, surfaceArea);
			
			totalArea += surfaceArea;

			if (isCubic(l, w, h)) {
				cubicRooms.add(surfaceArea);
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

	public void checkForSameRooms() {
		for (int i = 0; i < roomsSides.size(); i++) {
			for (int j = i + 1; j < roomsSides.size(); j++) {
				if (isSameRooms(roomsSides.get(i), roomsSides.get(j))) {
					sameRooms.add(surfaceAreas.get(i));
				}
			}
		}
	}

	private boolean isSameRooms(List<Integer> room1, List<Integer> room2) {
		return room1.get(0) == room2.get(0) && room1.get(1) == room2.get(1) && room1.get(2) == room2.get(2);
	}

	public List<Integer> getCubicRooms() {
		return cubicRooms.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}

	public List<Integer> getSameRooms() {
		return sameRooms;
	}

	public Integer getTotalArea() {
		return totalArea;
	}

}
