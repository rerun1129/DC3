package Shaper;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {

    private int capa = 10;
    private Shape [] shapes = new Shape[capa];
    private int n = 0;
    private Scanner kb = new Scanner(System.in);

    public void processCommand(){
        while (true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("추가"))
                handleAdd();
            else if(command.equals("보기")||command.equals("상세보기"))
                handleShow(command.equals("상세보기"));
            else if(command.equals("정렬"))
                Arrays.sort(shapes,0, n);
            else if(command.equals("나가기")){
                break;
            }
        }
    }



    private void handleShow(boolean detailed) {
        for(int i = 0; i<n; i++){
            System.out.println(i+1+". " + shapes[i].toString());
            if(detailed){
                System.out.println("    The area is " + shapes[i].computerArea());
                System.out.println("    The perimeter is " + shapes[i].computerPerimeter());
            }
        }
    }

    private void handleAdd() {
        String type = kb.next();
        switch (type){
            case "R" :
                addShape(new Rectangle(kb.nextInt(),kb.nextInt()));
                break;
            case "T" :
                //생략
            case "C" :
                addShape(new Circle(kb.nextInt()));
                break;
        }
    }

    private void addShape(Shape shape) {
        if(n >= capa)
            reallocate();
        shapes[n++] = shape;
    }

    private void reallocate() {
        capa *= 2;
        Shape [] tmp = new Shape[capa];
        System.arraycopy(shapes, 0, tmp ,0, shapes.length);
        shapes = tmp;
    }

    public static void main(String[] args) {
        ShapeApplication app = new ShapeApplication();
        app.processCommand();

    }
}
