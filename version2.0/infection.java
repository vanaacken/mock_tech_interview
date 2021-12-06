public class infection {
	static int _size;
	static int _squared;
	static int _infected_neighbours;
	static int grid[][];
	config conf;
	public infection(int g[][], config c){
		grid = g;
		conf = c;
		_size = conf.getSize();
		_squared = conf.getSquared();
	}

	public void loop()
	{
		cleanUp();
		infectLoop(conf);
	}

	public void cleanUp(){
		for(int y = 0; y < _size; y++){
			for (int x = 0; x < _size; x++){
				if (grid[y][x] == 2){
					grid[y][x] = 1;
				}
				else if (grid[y][x] == 3){
					grid[y][x] = 0;
				}
			}
		}
	}
	
	public static void infectLoop(config conf){
		for(int y = 0; y < _size; y++){
			for(int x = 0; x < _size; x++){
				checkNeighbours(x, y);
				newStatus(x, y, conf);
			}
		}
	}

	public static void checkNeighbours(int x, int y){
		_infected_neighbours = 0;
		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1 ; j++){
				if (y + i < 0
				|| y + i >= _size
				|| x + j < 0
				|| x + j >= _size
				|| (i == 0 && j == 0)){
					continue;
				}
				else if (grid[y + i][x + j] == 1){
					_infected_neighbours++;
				}
			}
		}
	}

	public static void newStatus(int x, int y, config conf){
		if (grid[y][x] == 0 && _infected_neighbours > conf._infection_threshold){
			grid[y][x] = 2;
		}
		else if(grid[y][x] == 1 && _infected_neighbours > conf._recovery_threshold){
			grid[y][x] = 3;
		}
	}
}
