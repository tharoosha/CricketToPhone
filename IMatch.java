public interface IMatch {

    //method to register and unregister abservers
    public void register(CricketFan fan);
    public void unregister(CricketFan fan);

    //method to notify observers of change
    public void notifyfans();

    //method to get updates from subject
    public Object getUpdate(CricketFan fan);
}
