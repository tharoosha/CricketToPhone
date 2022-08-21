import java.util.ArrayList;
import java.util.List;

public class Match implements IMatch {
    private int Identifier;
    private List<CricketFan> cricketFans;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public Match(int identifier) {
        Identifier = identifier;
        this.cricketFans = new ArrayList<>();
    }


    @Override
    public void register(CricketFan fan) {
        if (fan == null){
            throw new NullPointerException("fan is not found");
        }
        synchronized (MUTEX){
            if (!cricketFans.contains(fan))
                cricketFans.add(fan);
        }
    }

    @Override
    public void unregister(CricketFan fan) {
        synchronized (MUTEX){
            cricketFans.remove(fan);
        }
    }

    @Override
    public void notifyfans() {
        List<CricketFan> cricketFanslocal = null;
        synchronized (MUTEX){
            if (!changed)
                return;
            cricketFanslocal = new ArrayList<>(cricketFans);
            changed = false;
        }
        for (CricketFan cricketFan : cricketFanslocal)
            cricketFan.update();
    }

    @Override
    public Object getUpdate(CricketFan fan) {
        return message;
    }

    public void postMessage(String msg){
        System.out.println("Notification about match " +Identifier+ " send to the fans");
        this.message=msg;
        this.changed=true;
        notifyfans();
    }
}
