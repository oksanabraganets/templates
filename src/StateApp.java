public class StateApp {
    public static void main(String[] args){
        Station station = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(station);
        for (int i = 0; i<10; i++ ){
            radio.play();
            radio.nextStation();
        }
    }
}

interface Station{
    void play();
}

class RadioDFM implements Station{
    public void play() {
        System.out.println("DFM is playing...");
    }
}

class Radio7 implements Station{
    public void play() {
        System.out.println("Radio 7 is playing...");
    }
}

class VestiFM implements Station{

    public void play() {
        System.out.println("Vesti FM is paying...");
    }
}

class Radio{
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }
    void play(){
        station.play();
    }
    void nextStation(){
        if (station instanceof RadioDFM){
            setStation(new Radio7());
        }else if (station instanceof Radio7){
            setStation(new VestiFM());
        }else{
            setStation(new RadioDFM());
        }
    }
}