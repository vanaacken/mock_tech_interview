public class pandemic {

	static config conf;
	// static grid field;
	static infection generation;
	public static void main(String[] args)
	{
		parser(args);
		loop();
	}

	static void parser(String[] args)
	{
		conf = new config(args);
		// field = new grid(conf._squared);
		generation = new infection();
		for (point p : conf.points){
			generation.put(p.x, p.y);
		}
	}

	static void loop()
	{
		generation.print();
		// for(int i = 0; i < conf._rounds; i++){
		// 	generation.step();
		// }
	}

}
