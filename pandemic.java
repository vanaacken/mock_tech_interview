import java.util.Arrays;
/* TODO
** Parser
** Loop
** Output
** Output per iteration
*/
public class pandemic{
	public static void main(String[] args){
		if (args.length != 5)
		{
			System.out.println("Invalid Configuration");
			System.exit(1);
		}
		config conf = new config(args);
		// conf.print();
		int grid[] = new int[conf.getSquared()];
		try {
			conf.parseCoordinates(grid);
		} catch (Exception e) {
			System.out.println("Parsing Error: " + e);
			System.exit(1);
		}
		new printGrid(grid, conf);
		for(int i = 0; i < 40; i++)
		{
			new infected(grid, conf);
			new printGrid(grid, conf);
		}
	}
}