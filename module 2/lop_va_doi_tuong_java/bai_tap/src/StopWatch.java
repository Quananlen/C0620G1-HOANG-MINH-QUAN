public class StopWatch {
    private long startTime;
    private long endTime;

    long getStartTime() {
    return this.startTime;
    }
    long getEndTime() {
        return this.endTime;
    }
    long setStartTime(){
        this.startTime = System.currentTimeMillis();
        return this.startTime;
    }
    void start(){
        this.startTime = System.currentTimeMillis();
    }
    void end(){
        this.endTime = System.currentTimeMillis();
    }
    long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}
