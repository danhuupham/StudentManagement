package dan.models;

public class Scoreboard {
    private final String name;
    private final String course;
    private final float score;

    public Scoreboard(String name, String course, float score) {
        this.name = name;
        this.course = course;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public float getScore() {
        return score;
    }
}
