package version1;
public class config {
	int _size;
	int _squared;
	int _rounds;
	int _infection_threshold;
	int _recovery_threshold;
	String _coordinates_string;

	public config(String[] args){
		try {
			_size = Integer.parseInt(args[0]);
			_squared = _size * _size;
			_rounds = Integer.parseInt(args[1]);
			_infection_threshold = Integer.parseInt(args[2]);
			_recovery_threshold = Integer.parseInt(args[3]);
		} catch (Exception e) {
			System.out.println("Configuration error: " + e);
			System.exit(1);
		}
		_coordinates_string = args[4];
	}
	
	public void parseCoordinates(int grid[]){
		for(int i = 0; i < _coordinates_string.length(); i++)
		{
			int start = _coordinates_string.indexOf('<', i);
			int end = _coordinates_string.indexOf('>', start);
			if (start < 0 || end < 0){
				break;
			}
			if (_coordinates_string.indexOf(',', end) != end + 1
				&& _coordinates_string.indexOf(']', end) != end + 1)
			{
				System.out.println("Configuration error: missing ',' between coordinates");
				System.exit(1);
			}
			String sub = _coordinates_string.substring(start + 1, end);
			String split[] = sub.split(",");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			grid[(y-1) * _size + (x -1)] = 1;
			i += end - start;
		}
	}
	// GETTERS
	public int getSize(){
		return _size;
	}
	public int getSquared(){
		return _squared;
	}
	public int getRounds(){
		return _rounds;
	}



	// DEBUG
	public void print(){
		System.out.println("size        : " + _size);
		System.out.println("squared     : " + _squared);
		System.out.println("rounds      : " + _rounds);
		System.out.println("infection   : " + _infection_threshold);
		System.out.println("recovery    : " + _recovery_threshold);
		System.out.println("coordinates : " + _coordinates_string);
	}
}
