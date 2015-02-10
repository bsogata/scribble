import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

/**
 * A simple applet that uses the Java 1.0 event handling model.
 *
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 *
 */

public class Scribble extends Applet {
  private int lastX;
  private int lastY;
  private Button clearButton;
  private Graphics g;

  /**
   * Initialize the button and the Graphics object.
   *
   */

  @Override
  public void init() {
    this.clearButton = new Button("Clear");
    this.add(this.clearButton);
    g = this.getGraphics();
  }

  /**
   * Respond to mouse clicks.
   *
   * @param e    The Event that recorded the mouse click.
   * @param x    The int equal to the x-coordinate of the click.
   * @param y    The int equal to the y-coordinate of the click.
   *
   * @return A boolean that is true.
   *
   */

  @Override
  public boolean mouseDown(Event e, int x, int y) {
    this.lastX = x;
    this.lastY = y;
    return true;
  }

  /**
   * Respond to mouse drags.
   *
   * @param e    The Event that recorded the mouse drag.
   * @param x    The int equal to the x-coordinate of the drag.
   * @param y    The int equal to the y-coordinate of the drag.
   *
   * @return A boolean that is true.
   *
   */

  @Override
  public boolean mouseDrag(Event e, int x, int y) {
    this.g.setColor(Color.black);
    this.g.drawLine(this.lastX, this.lastY, x, y);
    this.lastX = x;
    this.lastY = y;
    return true;
  }

  /**
   * Respond to key presses.
   *
   * @param e      The Event that recorded the key press.
   * @param key    The int equal to the character value of the key that was pressed.
   *
   * @return A boolean that is true if the C key was pressed,
   *                           false otherwise.
   *
   */

  @Override
  public boolean keyDown(Event e, int key) {
    if ((e.id == Event.KEY_PRESS) && (key == 'c')) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Respond to Button clicks.
   *
   * @param e      The Event that recorded the button click.
   * @param arg    Not used.
   *
   * @return A boolean that is true if the button clicked was the Clear button,
   *                           false otherwise.
   *
   */

  @Override
  public boolean action(Event e, Object arg) {
    if (e.target == this.clearButton) {
      clear();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * A convenience method to erase the scribble.
   *
   */

  public void clear() {
    this.g.setColor(this.getBackground());
    this.g.fillRect(0, 0, bounds().width, bounds().height);
  }
}