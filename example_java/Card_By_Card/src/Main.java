import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        Account[] account = new Account[number];

        for (int i = 0; i < number; i++) {
            if (account[i] == null)
                account[i] = new Account();

            input.nextLine();
            account[i].setSt_Bank(input.nextLine());
            account[i].setName_Person(input.nextLine());
            account[i].setAmount_price(input.nextInt());

            if (account[i].getAmount_price() < 1000)
                account[i] = null;

            int inventory = input.nextInt();
            for (int j = 0; j < inventory; j++) {
                int add = input.nextInt();
                if (account[i] != null)
                    account[i].add_inventory(add);
            }
            int Harvest = input.nextInt();
            for (int j = 0; j < Harvest; j++) {
                int Harv = input.nextInt();
                if (account[i] != null)
                    account[i].Harvest_price(Harv);
            }
        }

        int counter = input.nextInt();

        for (int i = 0; i < counter; i++) {
            String Card_Sender = input.next();
            String Card_Receiver = input.next();
            int amount_send = input.nextInt();

            Account seller = new Account();
            Account receiver = new Account();

            if (account[i] != null)
                for (int j = 0; j < number; j++) {
                    if (account[i].getNumber_account().equals(Card_Sender) && !account[i].getNumber_account().equals(Card_Receiver))
                        seller = account[i];
                    if (account[i].getNumber_account().equals(Card_Receiver) && !account[i].getNumber_account().equals(Card_Sender))
                        receiver = account[i];
                }

            seller.seller(amount_send);
            receiver.receiver(amount_send);
        }

        for (int i = 0; i < number; i++) {
            if (account[i] == null)
                System.out.println(2345);
            else System.out.println(account[i]);
        }


    }
}