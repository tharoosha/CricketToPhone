import java.util.ArrayList;
import java.util.List;

public class Fan implements CricketFan{
    private String name;
    private List<IMatch> matches;

    public Fan(String nm){
        this.name = nm;
        matches = new ArrayList<>();
    }

    @Override
    public void update() {
        for (IMatch match : matches) {
            String msg = (String) match.getUpdate(this);
            if (msg == null)
                System.out.println(name+ " :: No new message");
            else
                System.out.println(name+ " :: Consuming message::");
        }
    }

    @Override
    public void setMatch(IMatch match) {
        this.matches.add(match);
    }
}
