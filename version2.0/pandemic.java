public class pandemic{
	static long _startTime;
	static int grid[][];
	static config conf;
	public static void main(String[] args){
		_startTime = System.nanoTime();
		if (args.length != 5)
		{
			System.out.println("Invalid Configuration");
			System.exit(1);
		}
		parser(args);
		printLoop();
		printEndTime();
	}
	
	static public void parser(String[] args)
	{
		conf = new config(args);
		grid = new int[conf.getSize()][conf.getSize()];
		conf.parseCoordinates(grid);
	}
	
	static public void printLoop()
	{
		printGrid printer = new printGrid(grid, conf);
		infection infect = new infection(grid, conf);
		printer.print();
		for(int i = 0; i < conf.getRounds(); i++)
		{
			infect.loop();
			printer.print();
		}
		infect.cleanUp();
		printer.print();

	}

	static public void printEndTime()
	{
		long endTime   = System.nanoTime();
		long totalTime = endTime - _startTime;
		System.out.println(totalTime / 1000000000 + "." + totalTime/1000000);
	}
}