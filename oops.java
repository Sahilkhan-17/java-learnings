
public class oops {
    public static void main(String[] args) {
        Pen goldex = new Pen();
        goldex.setColor("Green");
        goldex.printColor();
    }
}

class Pen{ 
    String name;
    String color;
    String type; //ball-pen/ jel-pen

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printColor(){
        System.out.println(this.color);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public void setColor(String color){
        this.color = color;
    }
}

