// AbstractFactoryPatternDemo.java

interface Shape {
  void draw();
}

class Rectangle implements Shape {
  @Override
  public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
  }
}

class Square implements Shape {
  @Override
  public void draw() {
      System.out.println("Inside Square::draw() method.");
  }
}

class RoundedRectangle implements Shape {
  @Override
  public void draw() {
      System.out.println("Inside RoundedRectangle::draw() method.");
  }
}

class RoundedSquare implements Shape {
  @Override
  public void draw() {
      System.out.println("Inside RoundedSquare::draw() method.");
  }
}

abstract class AbstractFactory {
  abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory {
  @Override
  public Shape getShape(String shapeType) {
      if(shapeType.equalsIgnoreCase("RECTANGLE")) {
          return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")) {
          return new Square();
      }
      return null;
  }
}

class RoundedShapeFactory extends AbstractFactory {
  @Override
  public Shape getShape(String shapeType) {
      if(shapeType.equalsIgnoreCase("RECTANGLE")) {
          return new RoundedRectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")) {
          return new RoundedSquare();
      }
      return null;
  }
}

class FactoryProducer {
  public static AbstractFactory getFactory(boolean rounded) {
      if(rounded) {
          return new RoundedShapeFactory();
      } else {
          return new ShapeFactory();
      }
  }
}

public class AbstractFactoryPattern {
  public static void main(String[] args) {
      // get shape factory
      AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

      // get an object of Shape Rectangle
      Shape shape1 = shapeFactory.getShape("RECTANGLE");
      shape1.draw();

      // get an object of Shape Square
      Shape shape2 = shapeFactory.getShape("SQUARE");
      shape2.draw();

      // get rounded shape factory
      AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);

      // get an object of Rounded Rectangle
      Shape shape3 = shapeFactory1.getShape("RECTANGLE");
      shape3.draw();

      // get an object of Rounded Square
      Shape shape4 = shapeFactory1.getShape("SQUARE");
      shape4.draw();
  }
}
