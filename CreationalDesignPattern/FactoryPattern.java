interface Shape{
  void draw();
}

class Circle implements Shape{
  public void draw(){
    System.out.println("This is a circle.");
  }
}

class Rectangle implements Shape{
  public void draw(){
    System.out.println("This is a rectangle.");
  }
}

class Square implements Shape{
  public void draw(){
    System.out.println("This is a square.");
  }
}

class ShapeFactory{
  public Shape getShape(String shapeType){
    if(shapeType == null){
      return null;
    }
    else if(shapeType.equalsIgnoreCase("Circle")){
      return new Circle();
    }
    else if(shapeType.equalsIgnoreCase("Rectangle")){
      return new Rectangle();
    }
    else if(shapeType.equalsIgnoreCase("Square")){
      return new Square();
    }
    else return null;
  }
}
public class FactoryPattern{
  public static void main(String [] args){
    ShapeFactory sf = new ShapeFactory();
    Shape s1 = sf.getShape("Circle");
    s1.draw();
    s1 = sf.getShape("Rectangle");
    s1.draw();

    s1 = sf.getShape("Square");
    s1.draw();
    s1 = sf.getShape("Cube");
    s1.draw();
  }
}