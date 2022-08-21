public class ApplicationServer {

    public static void main(String[] args) {
        //creating matches
        Match match_1 = new Match(21873);
        Match match_2 = new Match(13768);
        Match match_3 = new Match(94521);

        //creating observers
        CricketFan fan1 = new Fan("Joel");
        CricketFan fan2 = new Fan("Sasmitha");
        CricketFan fan3 = new Fan("Malshan");
        CricketFan fan4 = new Fan("Kavidu");
        CricketFan fan5 = new Fan("Radith");

        //register observers to the subject
        match_1.register(fan1);
        match_1.register(fan3);
        match_3.register(fan2);
        match_2.register(fan4);
        match_3.register(fan5);

        //attach observer to subject
        fan1.setMatch(match_1);
        fan2.setMatch(match_3);
        fan3.setMatch(match_1);
        fan4.setMatch(match_2);
        fan5.setMatch(match_3);

        //check if any update is available
        fan1.update();
        fan2.update();
        fan3.update();
        fan4.update();
        fan5.update();

        //now send message to subject
        match_1.postMessage("match_1 is start");
        match_2.postMessage("match_2 is pause");
        match_3.postMessage("match_3 tea break");

        //unregister fans to match
        match_1.unregister(fan3);

        //now send message to subject
        match_1.postMessage("match_3 is over");

    }

}
