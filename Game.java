import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game 
{
	private final JFrame window = new JFrame();
	private final ScreenFactory screenFactory;
	private final GameThread gameThread;
	private final Keyboardlistener keyboardlistener;
	private final MousepadListener mousepadListener;

	//Para crear la ventana del juego
	public Game(int windowX, int windowY, String title)
	{
		window.setSize(windowX, windowY);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setFocusable(true);
		window.setLocationRelativeTo(null);
		window.setTitle(title);
		window.setVisible(true);
		screenFactory = new ScreenFactory(this);

		gameThread = new GameThread(this);
		keyboardlistener = new Keyboardlistener();

		mousepadListener = new MousepadListener();

		window.add(gameThread);
		window.addKeyListener(keyboardlistener);

		window.addMouseListener(mousepadListener);

		new Thread(gameThread).start();
	}

	public MousepadListener getMouseListener()
	{
		return mousepadListener;
	}

	public Keyboardlistener getKeyboardListener()
	{
		return keyboardlistener;
	}

	public ScreenFactory getScreenFactory()
	{
		return screenFactory;
	}

	public JFrame getWindow()
	{
		return window;
	}
}