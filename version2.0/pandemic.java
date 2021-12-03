import java.util.Arrays;
import java.util.Scanner;

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

		int grid[][] = new int[conf.getSize()][conf.getSize()];
		try {
			conf.parseCoordinates(grid);
		} catch (Exception e) {
			System.out.println("Parsing Error: " + e);
			System.exit(1);
		}
		new printGrid(grid, conf);
		// Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < conf.getRounds(); i++)
		{
			// String s = scanner.nextLine();
			new infected(grid, conf);
			new printGrid(grid, conf);
		}
	}
}