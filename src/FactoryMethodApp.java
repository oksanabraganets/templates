import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args){

        WatchMaker maker = getWatchMakerByName("Digital");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getWatchMakerByName(String maker){
        if (maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
            return new RomeWatchMaker();
        throw new RuntimeException("There is no such watchmaker:" + maker);
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{
    public void showTime() {
        System.out.println("XX-IV");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new RomeWatch();
    }
}

