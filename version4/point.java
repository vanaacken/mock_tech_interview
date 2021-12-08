public class point {
	public final int x, y;

	public point(int x, int y){
		this.x = x;
		this.y = y;
	}

	public final int hashCode()
	{
		return x * 6521 + y * 7757;
	}

	public String toString()
	{
		return "(" + x + "," + y  + ")";
	}

	public point[] neighbours()
	{
		return new point[]{
			new point(x-1, y-1),
			new point(x-1, y),
			new point(x-1, y+1),
			new point(x, y-1),
			new point(x, y+1),
			new point(x+1, y-1),
			new point(x+1, y),
			new point(x+1, y+1),
		};
	}
	
}
