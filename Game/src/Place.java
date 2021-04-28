import java.util.ArrayList;


public class Place {
    private String descPlace;
    public ArrayList<Items> arrPlaceItems = new ArrayList();
    public ArrayList<Place> subPlace = new ArrayList();
    public ArrayList<Mobs> arrPlaceMobs = new ArrayList();
//    private BossField bossField;

    public void npc(){
        Items a = new Items();
        NPC objNPC = new NPC(subPlace, "Halo! Selamat berjelajah", a.getItemName());
    }

    public void CreatePlace(){
        System.out.println(descPlace);
        if(arrPlaceItems.size()==0){
            System.out.println("Tempat ini kosong, tidak ada item satupun di dalamnya");
        }else {
            System.out.println("Item yang tersedia :");
            int no=0;
            for (Items a:arrPlaceItems){
                no++;
                System.out.println(no+"."+a.getItemName());
            }
        }

        System.out.println("===============================================================");
        if(arrPlaceMobs.size()==0){
            System.out.println("tidak ada monster di sekitar sini");
        }else {
            System.out.println("Monster terdeteksi !!");
            System.out.println("Monster di sekitar :");
            int no=0;
            for (Mobs a:arrPlaceMobs){
                no++;
                System.out.println(no+"."+a.getName());
            }
        }
//        System.out.println("===============================================================");
//        if (bossField.getCharaPlace()!=null){
//            System.out.println("Boss Field terdeteksi !!");
//
//
//        }

    }


    public String getDescPlace() {
        return descPlace;
    }

    public void setDescPlace(String descPlace) {
        this.descPlace = descPlace;
    }

}
