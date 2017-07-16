public class MyGame
{
	private Game game;

	public MyGame()
	{
		game = new Game(800, 600, "My game");
		game.getScreenFactory().showScreen(new MyScreen(game.getScreenFactory()));
	}

	public static void main(String[] arg)
	{
		new MyGame();
	}
}