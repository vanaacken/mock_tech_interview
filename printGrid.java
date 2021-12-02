public class printGrid {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public printGrid(int grid[], config conf)
	{
		System.out.print("\033[H\033[2J");
		System.out.flush(); 
		String output = "";
		for(int i = 1; i <= conf.getSquared(); i++){
			if (grid[i - 1] == 1){
				output += ANSI_RED + ANSI_RED_BACKGROUND + grid[i-1];
			}
			else if (grid[i - 1] == 2){
				output += ANSI_BLACK + ANSI_BLACK_BACKGROUND + grid[i-1];
			}
			else if (grid[i - 1] == 3){
				output += ANSI_GREEN + ANSI_GREEN_BACKGROUND + grid[i-1];
			}
			else{
				output += ANSI_WHITE + ANSI_WHITE_BACKGROUND + grid[i-1];				
			}
			if (i % conf._size == 0){
				output +=  ANSI_RESET + "\n";
			}
			else{
				output += " ";
			}
		}
		System.out.print(output);

		try {
			Thread.sleep(500);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
