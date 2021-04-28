public class Character {

    private int hp, atk, def, mdef, mp;
    private int level, maxHp, maxMp, exp,maxExp;
    private String name;
    private Place CharaPlace;

    public void Status(Character c){
        System.out.println("===== Status =====");
        System.out.println("Name    : "+ c.getName());
        System.out.println("Level   : "+ c.getLevel());
        System.out.println("HP      : "+ c.getHp()+"/"+c.getMaxHp());
        System.out.println("MP      : "+ c.getMp()+"/"+c.getMaxMp());
        System.out.println("ATK     : "+ c.getAtk());
        System.out.println("DEF     : "+ c.getDef());
        System.out.println("MDEF    : "+ c.getMdef());
    }


    void battle (Character atk, Character musuh){
        musuh.setHp(musuh.getHp()-atk.getAtk());
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMdef() {
        return mdef;
    }

    public void setMdef(int mdef) {
        this.mdef = mdef;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public Place getCharaPlace() {
        return CharaPlace;
    }

    public void setCharaPlace(Place charaPlace) {
        CharaPlace = charaPlace;
    }
}
