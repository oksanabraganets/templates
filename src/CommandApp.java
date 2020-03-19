public class CommandApp {
    public static void main(String[] args){
        Comp c = new Comp();
        User user = new User(new StartCommand(c), new ResetCommand(c), new StopCommand(c));
        user.startComputer();
        user.resetComputer();
        user.stopComputer();
    }
}

class Comp{
    public void start(){
        System.out.println("Computer has started");
    }
    public void reset(){
        System.out.println("Computer is restarted");
    }
    public void stop(){
        System.out.println("Computer has stopped");
    }
}

interface Command{
    void execute();
}

class StartCommand implements Command{
    Comp comp;

    public StartCommand(Comp comp) {
        this.comp = comp;
    }

    public void execute() {
        comp.start();
    }
}

class StopCommand implements Command{
    Comp comp;

    public StopCommand(Comp comp) {
        this.comp = comp;
    }

    public void execute() {
        comp.stop();
    }
}

class ResetCommand implements Command{
    Comp comp;

    public ResetCommand(Comp comp) {
        this.comp = comp;
    }

    public void execute() {
        comp.reset();
    }
}

class User{
    private Command start;
    private Command reset;
    private Command stop;

    public User(Command start, Command reset, Command stop) {
        this.start = start;
        this.reset = reset;
        this.stop = stop;
    }

    public void startComputer(){
        start.execute();
    }
    public void resetComputer(){
        reset.execute();
    }
    public void stopComputer(){
        stop.execute();
    }
}