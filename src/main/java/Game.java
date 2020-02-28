import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
    public TerminalScreen screen;
    private int x = 10;
    private int y = 10;

    public Game(){
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, new TextCharacter('X'));
        screen.refresh();
    }
    public void run() throws IOException {
        Game game = new Game();
        game.draw();
    }

   
}
