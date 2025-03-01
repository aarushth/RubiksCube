package RubiksCube;
public class Vector {
	private int X;
	private int Y;
	private int Z;
	
	public Vector(int x, int y, int z) {
		X = x;
		Y = y;
		Z = z;
	}

	public Vector crossProduct(Vector tempVect) {
		return new Vector((Y*tempVect.Z - Z*tempVect.Y), (Z*tempVect.X - X*tempVect.Z), (X*tempVect.Y - Y*tempVect.X));
	}
	public Vector subtract(Vector tempVect) {
		return new Vector(X-tempVect.X, Y-tempVect.Y, Z-tempVect.Z);
	}
	public float dotProduct(Vector tempVect) {
		return ((tempVect.X*X)+(tempVect.Y*Y)+(tempVect.Z*Z));
	}
	public boolean equals(Vector tempVect) {
		if(tempVect.X == X && tempVect.Y == Y && tempVect.Z == Z) {
			return true;
		}else {
			return false;
		}
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	public int getZ() {
		return Z;
	}
	
	@Override
	public int hashCode() {
		
		return (Integer.toString(X) + Integer.toString(Y)+Integer.toString(Z)).hashCode();
	
	}
	
	@Override
	  public boolean equals(Object obj) {
		if (this == obj)
		      return true;
		if (obj == null)
		      return false;
		if (getClass() != obj.getClass())
		      return false;
		Vector tempVect = (Vector) obj;
		if(tempVect.X == X && tempVect.Y == Y && tempVect.Z == Z) {
			return true;
		}
		return false;
	}

}