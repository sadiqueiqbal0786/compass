package com.epam.rd.autotasks;


import java.util.Optional;
import static java.lang.Math.abs;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        while(degrees >= 360) degrees = degrees - 360;
        while(degrees < 0) degrees = 360 + degrees;

        for( Direction dir : Direction.values()){
            if(dir.degrees == degrees) return dir;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        while(degrees >= 360) degrees = degrees - 360;
        while(degrees < 0) degrees = 360 + degrees;

        for( Direction dir : Direction.values()){
            if(dir.degrees -23 <= degrees && dir.degrees +22 >= degrees) return dir;
        }
        return null;
    }

    public Direction opposite() {
        int newDegrees = degrees + 180;
        return ofDegrees(newDegrees);
    }

    public int differenceDegreesTo(Direction direction) {
        int newDegrees = abs(degrees - direction.degrees);
        while(newDegrees > 180) newDegrees = abs(360 - newDegrees);
        return newDegrees;
    }

}
/*
* The Direction enum represents the eight possible compass directions: North (N), Northeast (NE), East (E),
*  Southeast (SE), South (S), Southwest (SW), West (W), and Northwest (NW). Each direction is defined by an
* integer value representing the number of degrees it represents, relative to North. For example, North is 0
*  degrees, East is 90 degrees, and so on.

The ofDegrees method returns the Direction that corresponds to the specified number of degrees.
* If the number of degrees is outside the range [0, 360), it is adjusted to be within this range.
*  The method then iterates through each value in the Direction enum and checks if the direction's
* number of degrees is equal to the input degrees. If it is, the direction is returned.
*  If no direction corresponds to the input degrees, null is returned.

The closestToDegrees method returns the Direction that is closest to the specified number of degrees.
* The input degrees are adjusted to be within the range [0, 360), as with ofDegrees.
* The method then iterates through each value in the Direction enum and checks if the direction's
*  number of degrees is within a range of 45 degrees centered on the input degrees.
*  If it is, the direction is returned. If no direction is within this range, null is returned.

The opposite method returns the Direction that is opposite to the current direction.
*  This is accomplished by adding 180 degrees to the number of degrees of the current
* direction and using ofDegrees to find the corresponding direction.

The differenceDegreesTo method returns the difference in degrees between the current
* direction and the specified direction. This is accomplished by subtracting the number of
* degrees of the specified direction from the number of degrees of the current direction,
* taking the absolute value of the result, and then adjusting the result to be within the range [0, 180).
* */