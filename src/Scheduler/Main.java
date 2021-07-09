package Scheduler;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner kb;
    private int capa = 10;

    public Event [] events = new Event[capa];
    public int n = 0;
    public void processCommand() {
        kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("일정추가") || command.equals("추가")) {
                System.out.print("$ ");
                String type = kb.next();
                if (type.equals("일일")) {
                    handleAddOneDayEvent();
                } else if (type.equals("기간")) {
                    handleAddDurationEvent();
                } else if (type.equals("마감")) {
                    handleAddDeadlinedEvent();
                } else if (type.equals("돌아가기")){
                    break;
                }
            } else if (command.equals("리스트") || command.equals("목록")) {
                handleList();
            } else if (command.equals("보기") || command.equals("일정")) {

            } else if (command.equals("삭제")) {

                break;
            }
        }
    }

    private void addEvent(OneDayEvent ev){
        if(n >= capa){
            reallocate();
        }
        events[n++] = ev;
    }

    private void reallocate() {
        Event [] tmp = new Event[capa*2];
        for (int i =0; i<n; i++){
         tmp[i] = events[i];
            events = tmp;
        }
        capa*=2;
    }

    private void handleList() {
        for (int i = 0; i<n; i++){
            System.out.println("   " + events[i].toString());
        }
    }
    //해당 메서드에서 events 배열에 3가지 클래스 객체의 toString을 동시에 활용할 수 있기 때문에 for문이
    //3줄 들어갈 것을 1줄로 줄일수 있게 된다.(event배열에 데드라인, 듀레이션, 원데이 데이터가 모두 들어갈 수 있는것)

    private void handleAddDeadlinedEvent() {

    }

    private void handleAddDurationEvent() {

    }

    private void handleAddOneDayEvent() {


        System.out.print("  일자: ");
        String dateString = kb.next();
        MyDate date = parseDateString(dateString);
        kb.nextLine();
        System.out.print("  제목: ");
        String title = kb.nextLine();

        OneDayEvent ev = new OneDayEvent(title,date);
        addEvent(ev);
    }

    private MyDate parseDateString(String dateString) {
        String [] tokens = dateString.split("/");

        int year = Integer.parseInt(tokens[0]); //문자열을 정수형으로 바꿔주는 클래스 메서드
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);

        MyDate d = new MyDate(year,month,day);
        return d;

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.processCommand();
    }
}
