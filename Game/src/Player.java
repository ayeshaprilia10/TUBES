import java.util.ArrayList;

public class Player extends Character{

    private Skill skillPlayer;
    private Weapon EquipWeapon;
    public ArrayList<Items> arrItemsPlayer = new ArrayList();
    public ArrayList<Weapon> arrWeaponPlayer = new ArrayList();
    public ArrayList<Armor> arrArmorPlayer = new ArrayList();

    void setATK(Player x){
        x.setAtk(x.getAtk()+x.getEquipWeapon().getAtkPower()+x.getEquipWeapon().getEffect());
    }

    void levelUP(Character x){
        while (x.getExp()>= x.getMaxExp()){
            x.setLevel(x.getLevel()+1);
            x.setMaxExp(x.getMaxExp()+10);
            x.setExp(0);
            x.setMaxHp(x.getMaxHp()+50);
            x.setHp(x.getMaxHp());
            x.setAtk(x.getAtk()+15);
            x.setDef(x.getDef()+10);
            x.setMdef(x.getMdef()+10);
            x.setMaxMp(x.getMaxMp()+20);
            x.setMp(x.getMaxMp());




            System.out.println("Anda naik Level!!");
            System.out.println((x.getLevel()-1) + "->" + x.getLevel());

        }
    }

    public void Status(Character c){
        System.out.println("===== Status =====");
        System.out.println("Name    : "+ c.getName());
        System.out.println("Level   : "+ c.getLevel());
        System.out.println("HP      : "+ c.getHp()+"/"+c.getMaxHp());
        System.out.println("MP      : "+ c.getMp()+"/"+c.getMaxMp());
        System.out.println("ATK     : "+ c.getAtk());
        System.out.println("DEF     : "+ c.getDef());
        System.out.println("MDEF    : "+ c.getMdef());

        System.out.println("exp     : "+ c.getExp()+"/"+c.getMaxExp());
    }

    public void itemP(){
        if (arrItemsPlayer.size()==0){
            System.out.println("Item kosong!");
        }else {
            System.out.println("    Item Player    ");
            System.out.println("===================");
//            itemPlayer.buatItem();
            int no =0;
            for (Items a : arrItemsPlayer ){
                no++;
                System.out.println(no+"."+a.getItemName());
            }

        }
    }

    public void weapP(){
        if (arrWeaponPlayer.size()==0){
            System.out.println("Item kosong!");
        }else {
            System.out.println("    Item Player    ");
            System.out.println("===================");
//            itemPlayer.buatItem();
            int no =0;
            for (Weapon a : arrWeaponPlayer ){
                no++;
                System.out.println(no+"."+a.getName());
            }

        }
    }

    public void armorP(){
        if (arrArmorPlayer.size()==0){
            System.out.println("Item kosong!");
        }else {
            System.out.println("    Item Player    ");
            System.out.println("===================");
//            itemPlayer.buatItem();
            int no =0;
            for (Armor a : arrArmorPlayer ){
                no++;
                System.out.println(no+"."+a.getName());
            }

        }
    }

    public void takeItems(Character x){

//        Item itemPlayer = tempatPlayer.getItemTempat();
        if (x.getCharaPlace().arrPlaceItems.size()==0){
            System.out.println("Tempat tidak ada item");
        }else {
            System.out.println(x.getName()+" mengambil Item dari Tempat");
            for (Items a:x.getCharaPlace().arrPlaceItems){
//                setItemPlayer(itemPlayer);
                arrItemsPlayer.add(a);
                System.out.println(a.getItemName()+" telah diambil");
//                tempatPlayer.arritemTempat.remove(a);
            }
            getCharaPlace().arrPlaceItems.clear();

        }
    }

    public Skill getSkillPlayer() {
        return skillPlayer;
    }

    public void setSkillPlayer(Skill skillPlayer) {
        this.skillPlayer = skillPlayer;
    }

    public Weapon getEquipWeapon() {
        return EquipWeapon;
    }

    public void setEquipWeapon(Weapon equipWeapon) {
        EquipWeapon = equipWeapon;
    }
}
