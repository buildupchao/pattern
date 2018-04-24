package com.pattern.codingthinking.adviceoof;

import java.awt.Point;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.pattern.common.utils.PrintlnUtils;


public class WhichOneIsBetter {

	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(1, 2), new Point(2, 3));
		
		forOne(points);
		String pointStr = points.stream().map(Point::getX).map(String::valueOf).collect(Collectors.joining(","));
		PrintlnUtils.println(pointStr);
	}
	
	private static void forEach(List<Point> points) {
		for (Point point : points) {
			point.translate(1, 1);
		}
	}
	
	private static void forOne(List<Point> points) {
		for (Iterator<Point> pointIter = points.iterator(); pointIter.hasNext(); ) {
			pointIter.next().translate(1, 1);
		}
	}
	
	private static void whichOne(List<Point> points) {
		Iterator<Point> iter = points.iterator();
		while (iter.hasNext()) {
			iter.next().translate(1, 1);
		}
	}
	
}
