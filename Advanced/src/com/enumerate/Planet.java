package com.enumerate;

public class Planet {

	//The int enum pattern - severely deficient!
	public static final int APPLE_FUJI = 0;
	public static final int APPLE_PIPPIN = 1;
	
	public static final int ORRANGE_NAVEL = 0;
	public static final int ORRANGE_TEMPLE = 1;
	
	public enum Apple { FUJI, PIPPIN, GRANNY_SMITH };
	public enum Orange { NAVEL, TEMPLE, BLOOD };
	
	// Enum type with data and behavior
	public enum planet {
		MERCURY(3.302e+23, 2.439e6),
		VENUS  (4.869e+24, 6.052e6),
		EARTH  (5.975e+24, 6.378e6),
		MARS   (6.419e+23, 3.393e6),
		JUPITER(1.899e+27, 7.149e7),
		SATURN (5.685e+26, 6.027e7),
		URANUS (8.683e+25, 2.556e7),
		NEPTUNE(1.024e+26, 2.477e7);
		private final double mass;	// In kilograms
		private final double radius;	// In meters
		private final double surfaceGravity;	// In m / s^2
		
		// Universal gravitational constant in m^3 / kg s^2
		private static final double G = 6.67300E-11;
		
		// Constructor
		planet(double mass, double radius) {
			this.mass = mass;
			this.radius = radius;
			surfaceGravity = G * mass / (radius * radius);
		}
		
		public double mass() { return mass; }
		public double radius() { return radius; }
		public double surfaceGraviy() { return surfaceGravity; }
	
		public double surfaceWeight(double mass) {
			return mass * surfaceGravity; // F = ma
		}
	}
	
	public static void main(String[] args) {
		// Tasty citrus flavored applesauce!
//		int i = (APPLE_FUJI - ORRANGE_TEMPLE) / APPLE_PIPPIN;
//		System.out.println(i);
//		System.out.println(Apple.values());
//		System.out.println(6.67300E+3);
		for(int i=0; i<args.length; i++)
			System.out.println(args[i]);   
		if (args.length != 1) {
            System.err.println("Usage:  java Planet <earth_weight>");
            System.exit(-1);
        }
		double earthWeight = Double.parseDouble(args[0]);
//		double earthWeight = Double.parseDouble("134");
		double mass = earthWeight / planet.EARTH.surfaceGraviy();
		for (planet p : planet.values())
			System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
	}

}

