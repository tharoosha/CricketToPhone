public interface CricketFan {
    //method to update the observer, used by subject
    public void update();

    //attach with subject to observer
    public void setMatch(IMatch match);

}
