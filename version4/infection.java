import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class infection {
	public static final int HASH_SIZE = 4096;
	HashSet<point> grid = new HashSet<point>(HASH_SIZE);
	HashMap<point, Integer> counts = new HashMap<point, Integer>(HASH_SIZE);

	public void reset()
	{
		grid.clear();
		counts.clear();
	}

	void put (int x, int y)
	{
		set (new point(x, y));
	}

	
	Set<point> get ()
	{
		return grid;
	}

	void inc(point p)
	{
		Integer n = counts.get(p);
		if (n == null){
			counts.put(p, 1);
		}
		else{
			counts.put(p, n+1);
		}
	}

	void dec(point p)
	{
		Integer n = counts.get(p);
		if (n > 1){
			counts.put(p, n - 1);
		}
		else{
			grid.remove(p);
		}
	}
	void set(point p)
	{
		for(point tmp : p.neighbours()){
			inc (tmp);
		}
		grid.add(p);
	}
	void reset (point p)
	{
		for(point tmp : p.neighbours()){
			dec(tmp);
		}
		grid.remove(p);
	}
	public void step()
	{
		ArrayList<point> toReset = new ArrayList<point>();
		ArrayList<point> toSet = new ArrayList<point>();
		for (point p : grid){
			Integer n = counts.get(p);
			if (n == null || n < 2 || n > 3){
				toReset.add(p);
			}
		}
		for (point p : counts.keySet()){
			if (counts.get(p) == 3 && !grid.contains(p)){
				toSet.add(p);
			}
		}
		for(point p : toSet){
			set(p);
		}
		for (point p : toReset){
			reset (p);
		}
	}

	public void print()
	{
		for (point w : grid){
			System.out.println("value :" + counts.get(w));
		}



	}



}
