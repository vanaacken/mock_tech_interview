public class infected {
	int _size;
	int _squared;
	int _infected_neighbours;

	public infected(int grid[][], config conf){
		_size = conf.getSize();
		_squared = conf.getSquared();
		// set newly infected & recovered to normal infected and unifected
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
		// count neighbours and give newly affected or recovered status
		for(int y = 0; y < _size; y++){
			for(int x = 0; x < _size; x++){
				_infected_neighbours = 0;
				
				System.out.println("\nCOORDINATES:");
				System.out.println("x: " + x);
				System.out.println("y: " + y);
				System.out.println("Neighbours:");
				int count = 0;
				for(int i = -1; i <= 1; i++){
					for(int j = -1; j <= 1 ; j++){
						if (y + i < 0
							|| y + i >= _size
							|| x + j < 0
							|| x + j >= _size
							|| (i == 0 && j == 0)){
								System.out.println("INVALID");
								
								// System.out.println("x: " + (x + j));
								// System.out.println("y: " + (y + i));
								break;
							}
							else{
								System.out.println("VALID");
								// System.out.println("x: " + (x + j));
								// System.out.println("y: " + (y + i));
								_infected_neighbours += grid[y + i][x + j];
							}
							count++;
					}
				}
				System.out.println("Count: " + count);
			}
		}
		
		
		
		
		
		
		
		
		
		
		// for(int i = 0; i < _squared; i++){
		// 	_infected_neighbours = 0;
		// 	_infected_neighbours += top(grid, i) + side(grid, i) + bot(grid, i);
		// 	if (grid[i] == 0 && _infected_neighbours > conf._infection_threshold){
		// 		grid[i] = 2;
		// 	}
		// 	else if(grid[i] == 1 && _infected_neighbours > conf._recovery_threshold){
		// 		grid[i] = 3;
		// 	}

		// }
	}

}











	// public int top(int grid[], int i){
	// 	int n = 0;
	// 	if (i < _size){
	// 		return (0);
	// 	}
	// 	if (i % _size > 0 && grid[i - (_size + 1)] == 1){
	// 		n++;
	// 	}
	// 	if (i % _size < _size - 1 && grid[i - (_size - 1)] == 1){
	// 		n++;
	// 	}
	// 	if (grid[i - _size] == 1){
	// 		n++;
	// 	}
	// 	return (n);
	// }

	// public int side(int grid[], int i){
	// 	int n = 0;
	// 	if (i % _size > 0 && grid[i - 1] == 1)
	// 	{
	// 		n++;
	// 	}
	// 	if (i % _size < _size - 1 && grid[i + 1] == 1)
	// 	{
	// 		n++;
	// 	}
	// 	return (n);
	// }

	// public int bot(int grid[], int i){
	// 	int n = 0;
	// 	if (i >= _squared - _size){
	// 		return (0);
	// 	}
	// 	if (i % _size > 0 && grid[i + (_size - 1)] == 1){
	// 		n++;
	// 	}
	// 	if (i % _size < _size -1 && grid[i + (_size + 1)] == 1){
	// 		n++;
	// 	}
	// 	if (grid[i + _size] == 1)
	// 	{
	// 		n++;
	// 	}
	// 	return (n);
	// }