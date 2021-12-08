public class cell {
	int neighbours;
	boolean infected;
	Point position;
	int index;
	cell next;

	public cell(Point position, int neighbours, boolean infected){
		this.position = position;
		this.neighbours = neighbours;
		this.infected = infected;
	}

	public cell(Point position, int neighbours){
		this (position, neighbours, false);
	}

	void inc(){
		++neighbours;
	}

	void dec(){
		if (neighbours > 0)
			--neighbours;
	}

	void set(){
		live = true;
	}

	void reset(){
		live = false;
	}
}
