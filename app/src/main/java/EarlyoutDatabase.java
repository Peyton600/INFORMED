import java.lang.reflect.Array;

public class EarlyoutDatabase {
    private Array dates[], sport[], team[], excused[];

    public EarlyoutDatabase(Array[] dates, Array[] sport, Array[] team, Array[] excused) {
        this.dates = dates;
        this.sport = sport;
        this.team = team;
        this.excused = excused;
    }

    //this class will be used to fill the eary outs tab in a table like format.


    public Array[] getDates() {
        return dates;
    }

    public void setDates(Array[] dates) {
        this.dates = dates;
    }

    public Array[] getSport() {
        return sport;
    }

    public void setSport(Array[] sport) {
        this.sport = sport;
    }

    public Array[] getTeam() {
        return team;
    }

    public void setTeam(Array[] team) {
        this.team = team;
    }

    public Array[] getExcused() {
        return excused;
    }

    public void setExcused(Array[] excused) {
        this.excused = excused;
    }
}
