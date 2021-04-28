import java.util.Scanner;

public class GameEngine {
    boolean stop = false;
    Scanner sc = new Scanner(System.in);
    Player player;
    NPC blacksmith;
    Mobs goblin, goblinRider;
    BossField GoblinKing;
    Weapon sword, spear, bow;
    Armor armor1, armor2;
    Place firstPlace;

    public GameEngine(){
        player = new Player();
        player.setName("Player");
        player.setLevel(1);
        player.setHp(500);
        player.setMaxHp(500);
        player.setMp(100);
        player.setMaxMp(100);
        player.setExp(0);
        player.setMaxExp(10);
        player.setAtk(50);
        player.setDef(20);
        player.setMdef(10);

//        blacksmith = new NPC();
//        blacksmith.setName("Gandalf");
//        blacksmith.setLevel(20);
//        blacksmith.setHp(10500);
//        blacksmith.setMaxHp(10500);
//        blacksmith.setMp(500);
//        blacksmith.setMaxMp(500);
//        blacksmith.setExp(500);
//        blacksmith.setMaxExp(1000);
//        blacksmith.setAtk(250);
//        blacksmith.setDef(200);
//        blacksmith.setMdef(150);

        goblin = new Mobs();
        goblin.setName("Goblin");
        goblin.setLevel(1);
        goblin.setHp(100);
        goblin.setMaxHp(100);
        goblin.setMp(10);
        goblin.setMaxMp(10);
        goblin.setExp(15);
        goblin.setAtk(5);
        goblin.setDef(2);
        goblin.setMdef(1);

        goblinRider = new Mobs();
        goblinRider.setName("Goblin Rider");
        goblinRider.setLevel(1);
        goblinRider.setHp(150);
        goblinRider.setMaxHp(150);
        goblinRider.setMp(20);
        goblinRider.setMaxMp(20);
        goblinRider.setExp(25);
        goblinRider.setAtk(10);
        goblinRider.setDef(5);
        goblinRider.setMdef(2);

        GoblinKing = new BossField();
        GoblinKing.setName("Goblin");
        GoblinKing.setLevel(10);
        GoblinKing.setHp(1000);
        GoblinKing.setMaxHp(1000);
        GoblinKing.setMp(100);
        GoblinKing.setMaxMp(100);
        GoblinKing.setExp(150);
        GoblinKing.setAtk(50);
        GoblinKing.setDef(20);
        GoblinKing.setMdef(10);

        sword = new Weapon();
        sword.setName("Excalibur");
        sword.setDesc("Pedang suci excalibur, menambahkan 15% atk");
        sword.setGrade("S");
        sword.setAtkPower(100);
        sword.setEffect(15/100 * player.getAtk());

        spear = new Weapon();
        spear.setName("Spear of Homa");
        spear.setDesc("Tombak yang dibuat di kota Homa, menambahkan 5% HP");
        spear.setGrade("B");
        spear.setAtkPower(50);
        spear.setEffect(5/100 * player.getMaxHp());

        bow = new Weapon();
        bow.setName("Wooden bow");
        bow.setDesc("Busur dari kayu");
        bow.setGrade("D");
        bow.setAtkPower(10);
        bow.setEffect(0);

        Items goblinEar;
        goblinEar = new Items();
        goblinEar.setItemName("Goblin Ear");
        goblinEar.setDescItem("Didapat setelah mengalahkan goblin");

        Items copper;
        copper = new Items();
        copper.setItemName("Copper Ore");
        copper.setDescItem("Ore yang dapat digunakan untuk membuat senjata tingkat rendah");


        Place field1;
        field1 = new Place();
        field1.npc();
        field1.setDescPlace("Padang rumput di pinggiran hutan Jura");

        Place field2;
        field2 = new Place();
        field2.npc();
        field2.setDescPlace("Bagian timur di hutan Jura");

        Place field3;
        field3 = new Place();
        field3.npc();
        field3.setDescPlace("Camp goblin");


        goblin.dropItems.add(goblinEar);
//        goblin.setCharaPlace(field1);
        GoblinKing.setCharaPlace(field3);
//        goblin.setCharaPlace(field3);

        player.setEquipWeapon(sword);
        player.arrWeaponPlayer.add(spear);
        player.arrWeaponPlayer.add(bow);
//        player.setATK(player);
        player.setCharaPlace(field1);


        field1.arrPlaceItems.add(copper);
        field1.arrPlaceMobs.add(goblin);
        field1.subPlace.add(field2);
        field1.subPlace.add(field3);

        field3.arrPlaceMobs.add(goblin);
        field3.arrPlaceMobs.add(goblinRider);



    }

    public void resultBattle(Player a, Mobs b, int p) {
        if (a.getHp() <= 0) {
            System.out.println("Kamu kalah!");
        } else if (b.getHp() <= 0) {
            System.out.println("Kamu menang!");
            a.getCharaPlace().arrPlaceMobs.remove(p);
//            a.getCharaPlace().arrPlaceMobs.remove(b);
//            b.setCharaPlace(null);
            a.setExp(a.getExp() + b.getExp());
            a.levelUP(a);
        }

        a.getCharaPlace().CreatePlace();
        action();

    }
    public void bertanding(Player a, Mobs b){
        System.out.println();
        System.out.println("Memulai Battle!");
        int turn = 1;
        while (true){
            System.out.println("--------------------");
            System.out.println("Turn : "+turn);
            System.out.println("--------------------");
            System.out.println("[1] Attack");
            System.out.println("[2] Run");
            System.out.println("--------------------");
            System.out.print("Choose :");
            int input = sc.nextInt();
            if (input == 1){
                System.out.println(a.getName()+" Menyerang");
                System.out.println("Memberikan "+a.getAtk()+" damage");
                a.battle(a,b);
                if (b.getHp()<=0){
                    b.setHp(0);
                    b.Status(b);
                    break;
                }
                b.Status(b);
                System.out.println("--------------------");
                System.out.println(b.getName()+" Menyerang");
                System.out.println("Memberikan "+b.getAtk()+" damage");
                b.battle(b,a);

                if (a.getHp()<=0){
                    a.setHp(0);
                    a.Status(a);
                    break;
                }
                a.Status(a);

                turn++;



            }else if(input == 2){
                System.out.println("Melarikan diri dari pertarungan");
                break;
            }

        }

    }

    public void action(){
        if (player.getCharaPlace().arrPlaceMobs.size() != 0) {
            System.out.println("============================");
            System.out.print("Apakah anda akan bertarung (y/n) ?  ");
            String pil = sc.next().toLowerCase();
            if (pil.equals("y")) {
                System.out.print("Pilih monster yang ingin diserang : ");
                int inp = sc.nextInt();
                bertanding(player, player.getCharaPlace().arrPlaceMobs.get(inp - 1));
                resultBattle(player, player.getCharaPlace().arrPlaceMobs.get(inp - 1), inp - 1);
            }
        }
    }


    public void bermain () {
        System.out.println("||----------------------------------------||");
        System.out.println("[1] Cek Status ");
        System.out.println("[2] Lihat Item");
        System.out.println("[3] Telusuri Tempat");
        System.out.println("[4] Ambil Item");
        System.out.println("[5] Keluar Game");
        System.out.print("Pilih Aksi :");
        int input = sc.nextInt();
        if (input == 1) {
            player.Status(player);
        } else if (input == 2) {
//            player1.itemP();
            System.out.println("Lihat Pilihan Item :");
            System.out.println("[1] Item");
            System.out.println("[2] Weapon");
            input = sc.nextInt();
            if (input==1){
                player.itemP();
            }else if(input==2){
                player.weapP();
            }
        } else if (input == 3) {

            player.getCharaPlace();
            firstPlace = player.getCharaPlace();
            if (player.getCharaPlace().subPlace.size()==0){
                player.getCharaPlace().CreatePlace();
            }else {
                player.getCharaPlace().CreatePlace();
                action();
                while (true) {
//                  player.getCharaPlace().CreatePlace();
                    System.out.println("============================");
                    System.out.println("    Telusuri Tempat Lain    ");
                    System.out.println("============================");
                    int no = 0;
                    for (Place a : player.getCharaPlace().subPlace) {
                        no++;
                        System.out.println(no + "." + a.getDescPlace());
                    }
                    System.out.println("0.Kembali");
                    System.out.println("============================");
                    System.out.print("Pilih :");
                    int inp = sc.nextInt();
                    if (inp == 0) {
                        player.setCharaPlace(firstPlace);
                        player.getCharaPlace().CreatePlace();
                        break;
                    } else {
                        player.setCharaPlace(player.getCharaPlace().subPlace.get(inp - 1));
                        player.getCharaPlace().CreatePlace();
                        action();
                    }

                }
                action();
            }
        } else if (input == 4) {
            player.takeItems(player);
        } else if (input == 5) {
            stop = true;
        }
    }

    public void play(){
        while (!stop){
            bermain();
        }
    }
}
