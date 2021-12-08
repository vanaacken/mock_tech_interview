public class pandemic{
	static int grid[][];
	static config conf;
	public static void main(String[] args){
		if (args.length < 5 || args.length > 6)
		{
			System.out.println("Invalid Configuration");
			System.exit(1);
		}
		parser(args);
		printLoop();
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
		if (conf._verbose == true){
		printer.print();
		}
		for(int i = 0; i < conf.getRounds(); i++)
		{
			infect.loop();
			if (conf._verbose == true){
				printer.print();
			}
		}
		infect.cleanUp();
		printer.print();
	}
}