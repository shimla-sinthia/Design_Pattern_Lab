// Step 1 - Bridge Implementer Interface
interface DrawAPI {
  public void drawCircle(int radius, int x, int y);
}

// Step 2 - Concrete Implementations of DrawAPI
class RedCircle implements DrawAPI {
  @Override
  public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", y: " + y + "]");
  }
}

class GreenCircle implements DrawAPI {
  @Override
  public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", y: " + y + "]");
  }
}

// Step 3 - Abstract Class Shape
abstract class Shape {
  protected DrawAPI drawAPI;

  protected Shape(DrawAPI drawAPI) {
      this.drawAPI = drawAPI;
  }

  public abstract void draw();
}

// Step 4 - Concrete Class Circle
class Circle extends Shape {
  private int x, y, radius;

  public Circle(int x, int y, int radius, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;
      this.y = y;
      this.radius = radius;
  }

  @Override
  public void draw() {
      drawAPI.drawCircle(radius, x, y);
  }
}

// Step 5 - Demo Class
public class BridgePattern {
  public static void main(String[] args) {
      Shape redCircle = new Circle(100, 100, 10, new RedCircle());
      Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

      redCircle.draw();
      greenCircle.draw();
  }
}
