package vooga.fighter.view;

import java.awt.Color;

/**
 * Sets the color of HUD Player Values
 * 
 * @author Bill Muensterman
 * 
 */
public class HUDPlayerValueColor extends HUDPlayerValue {

	public Color setValueColor(int maxValue, int currentValue,
			Color startColor, Color endColor) {

		int ratio = maxValueToRangeRatio(maxValue,
				currentValue);

		int[] RGB = setRGBValues(startColor, endColor, ratio);
		
		Color c = new Color(RGB[0], RGB[1], RGB[2]);
		return c;
	}

	public int maxValueToRangeRatio(int maxValue, int currentValue) {
		int ratio;
		if (maxValue == currentValue) {
			ratio = 1;
		} else {
			ratio = maxValue / (maxValue - currentValue);
		}
		return ratio;
	}

	public int[] setRGBValues(Color startColor, Color endColor,
			int maxValueToRangeRatio) {
		
		int[] RGB = new int[3];

		int differenceInRedValues = (startColor.getRed() - endColor.getRed())
				/ maxValueToRangeRatio;
		int differenceInGreenValues = (startColor.getGreen() - endColor.getGreen())
				/ maxValueToRangeRatio;
		int differenceInBlueValues = (startColor.getBlue() - endColor.getBlue())
				/ maxValueToRangeRatio;
		
		RGB[0] = startColor.getRed() - differenceInRedValues;
		RGB[1] = startColor.getGreen() - differenceInGreenValues;
		RGB[2] = startColor.getBlue() - differenceInBlueValues;

		return RGB;
	}

}