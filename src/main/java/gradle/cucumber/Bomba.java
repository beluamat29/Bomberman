package gradle.cucumber;

public class Bomba {

    private Integer tick;
    private Boolean exploto;
    private Bomberman bomberman;

    public Bomba (int tick){
        this.tick = tick;
        this.exploto = false;
    }

    public void disminuirTick(){
        tick = getTick() - 1;
        if(tick == 0){
            setExploto(true);

        }
    }


    public Integer getTick() {
        return tick;
    }

    public void setTick(Integer tick) {
        this.tick = tick;
    }

    public Boolean getExploto() {
        return exploto;
    }

    public void setExploto(Boolean exploto) {
        this.exploto = exploto;
    }
}
