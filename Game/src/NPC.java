import java.util.ArrayList;

public class NPC{
    private Place objPlc;
    private String desc;
    private Items objItm;

//    public NPC(Place objPlc, String desc, Items objItm) {
//        this.objPlc = objPlc;
//        this.desc = desc;
//        this.objItm = objItm;
//    }

    public NPC(ArrayList<Place> subPlace, String desc, String itemName) {
    }

    public Place getObjPlc() {
        return objPlc;
    }

    public void setObjPlc(Place objPlc) {
        this.objPlc = objPlc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Items getObjItm() {
        return objItm;
    }

    public void setObjItm(Items objItm) {
        this.objItm = objItm;
    }
}
