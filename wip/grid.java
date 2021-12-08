public class grid {
	cell[] arr;
	int count = 0;

	public grid (int capacity)
	{
		arr = new cell[capacity];
	}

	void clear()
	{
		for(int i = 0; i < table.length; i++){
			table[i] = null;
		}
	}

	int hash(point p)
	{
		return p.hashCode();
	}

	int index (int hash)
	{
		return hash & (table.length - 1);
	}

	cell get (int key)
	{
		for(cell c = arr[index(hash(key))]; c!= null; c = c.table_next){
			if (c.position == key){
				return c;
			}
		}
		return null;
	}

	void put (cell c)
	{
		int index = cell.index = index (hash (c.position));
		c.next = arr[index];
		arr[index] = cell;
		++ count;
	}

	void remove(cell c)
	{
		int index = c.index;
		if (arr[index] == cell){
			arr[index] = c.next;
			-- count;
			return ;
		}
		for(cell tmp = arr[index]; tmp != null; tmp = c.next){
			if(tmp.next == c){
				tmp.next = c.table_next;
				-- count;
				return ;
			}
		}
	}

	void iterate()
	{

	}

}
