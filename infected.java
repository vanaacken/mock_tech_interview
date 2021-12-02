public class infected {
	int _size;
	int _squared;
	public infected(int grid[], config conf){
		_size = conf.getSize();
		_squared = conf.getSquared();
		// set newly infected & recovered to normal infected and unifected
		for(int i = 0; i < _squared; i++){
			if (grid[i] == 2){
				grid[i] = 1;
			}
			else if (grid[i] == 3){
				grid[i] = 0;
			}
		}
		// count neighbours and give newly affected or recovered status
		for(int i = 0; i < _squared; i++){
			if (grid[i] == 0 && top(grid, i) + side(grid, i) + bot(grid, i) > conf._infection_threshold){
				grid[i] = 2;
			}
			else if(grid[i] == 1 && top(grid, i) + side(grid, i) + bot(grid, i) > conf._recovery_threshold){
				grid[i] = 3;
			}
		}
	}
	public int top(int grid[], int i){
		int infected_neighbours = 0;
		if (i < _size){
			return (0);
		}
		if (i % _size > 0 && grid[i - (_size + 1)] == 1){
			infected_neighbours++;
		}
		if (i % _size < 9 && grid[i - (_size - 1)] == 1){
			infected_neighbours++;
		}
		if (grid[i - _size] == 1){
			infected_neighbours++;
		}
		return (infected_neighbours);
	}

	public int side(int grid[], int i){
		int infected_neighbours = 0;
		if (i % _size > 0 && grid[i - 1] == 1)
		{
			infected_neighbours++;
		}
		if (i % _size < 9 && grid[i + 1] == 1)
		{
			infected_neighbours++;
		}
		return (infected_neighbours);
	}

	public int bot(int grid[], int i){
		int infected_neighbours = 0;
		if (i >= _squared - _size){
			return (0);
		}
		if (i % _size > 0 && grid[i + (_size - 1)] == 1){
			infected_neighbours++;
		}
		if (i % _size < 9 && grid[i + (_size + 1)] == 1){
			infected_neighbours++;
		}
		infected_neighbours += grid[i + _size];
		return (infected_neighbours);
	}
}
