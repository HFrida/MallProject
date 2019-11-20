package com.company;

import java.util.*;

public class Game {
    private ATM atm;
    private Shop[][] map;
    private Player player;
    private Thief thief1;
    private Thief thief2;
    private Police police;
    private Shop currentShop;
    Scanner scan = new Scanner(System.in);

    public Game() {
        init();
    }

    public void init() {
        Item item1 = new Item("T-shirt", 99, "It's a white t-shirt in size S");
        Item item2 = new Item("Shorts", 150, "Dark blue shorts with white pockets, size 36");
        Item item3 = new Item("Dress", 399, "Long dress with flowers, size m");
        Item item4 = new Item("Pumps", 899, "Black pumps with high, thin heel, size 37");
        Item item5 = new Item("Boots", 1599, "Dark brown boots with zipper at the back, size 42");
        Item item6 = new Item("Slippers", 699, "Beige slippers with sheep wool inside, size 39");
        Item item7 = new Item("Earrings", 1999, "Beautiful pearl earrings");
        Item item8 = new Item("Necklace", 2649, "Long necklace in gold with a heart charm");
        Item item9 = new Item("Ring", 3549, "Silver ring with three small stones in the middle");
        Item item10 = new Item("World of Warcraft", 899, "Coolest fantasy-game ever");
        Item item11 = new Item("Fifa", 999, "Best football-game ever");
        Item item12 = new Item("The Sims", 499, "Sweetest whatever-game ever");
        Item item13 = new Item("Golden fish", 150, "Supercute little goldfish with big eyes");
        Item item14 = new Item("Guinea pig", 550, "Cutest guinea pig ever with black and white fur");
        Item item15 = new Item("Parrot", 990, "Green, red and blue nagging parrot");
        Item item16 = new Item("Blazer", 999, "Dark blue blazer");
        Item item17 = new Item("Jeans", 1299, "Black jeans, size 32");
        Item item18 = new Item("T-shirt", 299, "Black t-shirt with 'Carpe Diem' printed on it");
        Item item19 = new Item("Ipren", 65, "24 pills for different kind of aces");
        Item item20 = new Item("Nose spray", 28, "Nose spray for allergies");
        Item item21 = new Item("Mouth wash", 59, "Some mouthwash with flour");
        Item item22 = new Item("Running shoes", 1599, "Grey running shoes from Nike");
        Item item23 = new Item("Water bottle", 39, "50 cl plastic bottle");
        Item item24 = new Item("Football", 119, "Mostly white round ball");
        Item item25 = new Item("Apple", 7, "Green apple with a few brown spots");
        Item item26 = new Item("Energy drink", 35, "33 cl Red Bull");
        Item item27 = new Item("Chocolate cake", 19, "Mmmm Marabou");

        SalesPerson person1 = new SalesPerson("Andreas", "necklace made of human hair", 399);
        SalesPerson person2 = new SalesPerson("Birgit", "pair of sweaty old shorts", 499);

        Shop shop1 = new Shop("H&M", Map.of("EXIT", "E"), new ArrayList<Item>(Arrays.asList(item1, item2, item3)));
        Shop shop2 = new Shop("Hallway1", Map.of("H&M", "W", "SCORETT", "E", "N", "N"));
        Shop shop3 = new Shop("Scorett", Map.of("EXIT", "W"), new ArrayList<Item>(Arrays.asList(item4, item5, item6)));
        Shop shop4 = new Shop("Smycka", Map.of("EXIT", "E"), new ArrayList<Item>(Arrays.asList(item7, item8, item9)), person1);
        Shop shop5 = new Shop("Hallway2", Map.of("SMYCKA", "W", "ATM", "E", "N", "N", "S", "S"));
        Shop shop6 = new Shop("ATM", Map.of("EXIT", "W"));
        Shop shop7 = new Shop("Game Stop", Map.of("EXIT", "E"), new ArrayList<Item>(Arrays.asList(item10, item11, item12)));
        Shop shop8 = new Shop("Hallway3", Map.of("GAME STOP", "W", "ARKEN ZOO", "E", "N", "N", "S", "S"));
        Shop shop9 = new Shop("Arken Zoo", Map.of("EXIT", "W"), new ArrayList<Item>(Arrays.asList(item13, item14, item15)));
        Shop shop10 = new Shop("MQ", Map.of("EXIT", "E"), new ArrayList<Item>(Arrays.asList(item16, item17, item18)));
        Shop shop11 = new Shop("Hallway4", Map.of("MQ", "W", "APOTEKET", "E", "N", "N", "S", "S"));
        Shop shop12 = new Shop("Apoteket", Map.of("EXIT", "W"), new ArrayList<Item>(Arrays.asList(item19, item20, item21)));
        Shop shop13 = new Shop("Intersport", Map.of("EXIT", "E"), new ArrayList<Item>(Arrays.asList(item22, item23, item24)), person2);
        Shop shop14 = new Shop("Hallway5", Map.of("INTERSPORT", "W", "PRESSBYRÅN", "E", "S", "S"));
        Shop shop15 = new Shop("Pressbyrån", Map.of("EXIT", "W"), new ArrayList<Item>(Arrays.asList(item25, item26, item27)));

        atm = new ATM();
        map = new Shop[][]{
                {shop13, shop14, shop15},
                {shop10, shop11, shop12},
                {shop7, shop8, shop9},
                {shop4, shop5, shop6},
                {shop1, shop2, shop3}
        };
        player = new Player(4, 1);
    }

    public void run() {
        boolean mallInput = true;
        while (mallInput) {
            try {
                System.out.println("How much money do you have with you to the mall: ");
                player.setCash(Integer.parseInt(scan.nextLine()));
                mallInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Please use numbers");
            }
        }
        boolean bankInput = true;
        while (bankInput) {
            try {
                System.out.println("How much money do you have in the bank: ");
                int bankCash = Integer.parseInt(scan.nextLine());
                atm.userInputCash(bankCash);
                bankInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Please use numbers");
            }
        }

        while (true) {
            Random rand = new Random();
            thief1 = new Thief(rand.nextInt(5), rand.nextInt(3), 100);
            thief2 = new Thief(rand.nextInt(5), rand.nextInt(3), 200);
            police = new Police(rand.nextInt(5), rand.nextInt(3));
            currentShop = map[player.getyPos()][player.getxPos()];
            System.out.println();
            System.out.println("You're in: " + currentShop);
            System.out.println("You have " + player.getCash() + " kr");

            robbed(thief1);
            robbed(thief2);
            if (player.getxPos() == police.getxPos() && player.getyPos() == police.getyPos()) {
                System.out.println();
                System.out.println("So nice to see an officer here, now I feel safe");
            }

            existingSalesPerson();

            while (true) {
                try {
                    System.out.println();
                    System.out.println("What do you want to do? ");
                    String userChoice = scan.nextLine().toUpperCase();
                    if (choice(userChoice)) {
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("This is not a valid option");
                }
            }
        }
    }

    public boolean choice(String userChoice) {
        Shop shop = map[player.getyPos()][player.getxPos()];
        if (userChoice.startsWith("GO")) {
            String newDirection = userChoice.split("GO ")[1];
            return go(newDirection, shop);
        }
        if (userChoice.startsWith("ENTER")) {
            String newDirection = userChoice.split("ENTER ")[1];
            return enterShop(newDirection, shop);
        }
        if (userChoice.startsWith("EXIT")) {
            String exit = userChoice;
            return exitShop(exit, shop);
        }
        if (userChoice.startsWith("BUY")) {
            String pickItem = userChoice.split("BUY ")[1];
            return buy(pickItem, shop);
        }
        if (userChoice.startsWith("GET")) {
            String amount = (userChoice.split("GET ")[1]);
            return get(amount);
        }
        if (userChoice.startsWith("PICK UP")) {
            String pickUp = (userChoice.split("PICK UP ")[1]);
            return pickUp(pickUp);
        }
        if (userChoice.startsWith("QUIT")) {
            return quit();
    }
    return false;
}
        private boolean pickUp (String pickUp){
            Shop currentShop = map[player.getyPos()][player.getxPos()];
            Item item = null;
            for (Item i : currentShop.getItems()) {
                if (pickUp.equals(i.getName().toUpperCase())) {
                    item = i;
                    break;
                }
            }
            if (item != null) {
                System.out.println(item.getDescription());
                return true;
            } else {
                System.out.println();
                System.out.println("There is no " + pickUp + " here");
            }
            return false;
        }

        private boolean go (String newDirection, Room room){
            String direction = room.getDirection(newDirection);
            if (room.possibleExits(newDirection)) {
                player.move(direction);
                return true;
            } else {
                System.out.println();
                System.out.println("There's no exit to " + newDirection);
                return false;
            }
        }

        private boolean enterShop (String newDirection, Room room){
            if (room.possibleExits(newDirection)) {
                player.enter(newDirection);
                return true;
            } else {
                System.out.println();
                System.out.println("It's not possible to enter " + newDirection + " from where you are right now");
            }
            return false;
        }

        private boolean exitShop (String exit, Room room){
            if (room.possibleExits(exit)) {
                player.exit(exit);
                return true;
            } else {
                System.out.println();
                System.out.println("You can't exit this shop");
            }
            return false;
        }

        private boolean buy (String pickItem, Shop shop){
            Item item = shop.buyItem(pickItem);
            if (item != null) {
                if (player.getCash() > item.getPrice()) {
                    player.addInventory(item);
                    System.out.println();
                    System.out.println("You just bought " + pickItem.toLowerCase());
                    player.buyItem(item.getPrice());
                    System.out.println("You have " + player.getCash() + " kr left");
                    return true;
                } else {
                    System.out.println();
                    System.out.println("You don't have enough money to buy this item");
                }
            } else {
                System.out.println();
                System.out.println("You can't buy " + item + "  in this shop");
            }
            return false;
        }

        private boolean get (String amount){
            if (player.getxPos() == 2 && player.getyPos() == 3) {
                if (Integer.parseInt(amount) <= atm.getTotalBankCash()) {
                    atm.cashReduceMethod(Integer.parseInt(amount));
                    player.withdrawal(Integer.parseInt(amount));
                    System.out.println();
                    System.out.println("You have " + atm.getTotalBankCash() + " kr left at the bank");
                    return true;
                } else {
                    System.out.println();
                    System.out.println("You don't have " + amount + " kr at the bank");
                }
            } else {
                System.out.println();
                System.out.println("You can't make a withdrawal if you're not at the ATM");
            }
            return false;
        }
        private boolean quit () {
            System.out.println();
            System.out.println("Do you really want to quit? Y/N");
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                System.exit(0);
            }
            return false;
        }

        private void existingSalesPerson () {
            SalesPerson person = currentShop.getPerson();
            if (person != null) {
                player.cashReduceMethod(person.getCost());
                if (player.getCash() > person.getCost()) {
                    System.out.println();
                    System.out.println("Oh no, " + person.getName() + " just got you to buy a " + person.getItem() +
                            " that cost you " + person.getCost() + " kr");
                    System.out.println("Now you have " + player.getCash() + " kr");
                } else {
                    player.setCash(0);
                    System.out.println();
                    System.out.println("Oh no, " + person.getName() + " just got you to buy a " + person.getItem() +
                            " for all money that you had left");
                    System.out.println("Now you have " + player.getCash() + " kr");
                }
            }
        }

        private void robbed (Thief thief){
            if (player.getxPos() == thief.getxPos() && player.getyPos() == thief.getyPos()) {
                if (player.getxPos() == police.getxPos() && player.getyPos() == police.getyPos()) {
                    police.save(thief.getStealMoney());
                    System.out.println();
                    System.out.println("It's a thief here! Thank god there also was a policeman here so you didn't get robbed");
                } else {
                    if (player.getCash() > thief.getStealMoney()) {
                        player.cashReduceMethod(thief.getStealMoney());
                        System.out.println();
                        System.out.println("OMG, you just got robbed by a thief! Now you have " + player.getCash() + " kr");
                    } else {
                        player.setCash(0);
                        System.out.println();
                        System.out.println("OMG, you just got robbed by a thief who took all your money!");
                    }
                }
            }
        }
    }
