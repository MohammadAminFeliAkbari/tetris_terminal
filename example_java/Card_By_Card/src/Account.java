
public class Account {
    private String Name_Person;
    private int amount_price;
    private String st_Bank;
    private String number_account;
    private final int Tax = 1000;

    public void add_inventory(int new_inventory) {
        if (this.amount_price > Tax) {
            this.amount_price += new_inventory;
            this.amount_price -= Tax;
        }
    }

    public void Harvest_price(int new_harvest) {
        if (this.amount_price == Tax)
            this.amount_price = 0;

        if (new_harvest < this.amount_price)
            if (this.amount_price > Tax) {
                this.amount_price -= new_harvest;
                this.amount_price -= Tax;
            }
    }

    public void seller(int amount)
    {
        this.setAmount_price(this.getAmount_price() - amount - Tax);
    }

    public void receiver(int amount)
    {
        this.add_inventory(amount + Tax);
    }

    public void number_account() {
        this.number_account = "";

        this.number_account += String.valueOf((int) st_Bank.charAt(0));
        this.number_account += String.valueOf((int) st_Bank.charAt(1));
        this.number_account += String.valueOf((int) Name_Person.charAt(0));
        this.number_account += String.valueOf((int) Name_Person.charAt(1));

        for (int i = 0; i < Name_Person.length(); i++)
            if (Name_Person.charAt(i) == ' ') {
                this.number_account += String.valueOf((int) Name_Person.charAt(i + 1));
                this.number_account += String.valueOf((int) Name_Person.charAt(i + 2));
                break;
            }
    }

    public String toString() {
        return String.format("%s\n%s\n%s\n%d",
                this.st_Bank,
                this.Name_Person,
                this.number_account,
                this.amount_price);
    }

    //setter && getter
    public void setName_Person(String name_Person) {
        Name_Person = name_Person;
    }

    public void setAmount_price(int amount_price) {
        if (amount_price > Tax) {
            this.amount_price = amount_price;
            this.amount_price -= Tax;
        }
    }


    public void setSt_Bank(String st) {
        st_Bank = st;
    }

    public int getAmount_price() {
        return amount_price;
    }

    public String getNumber_account()
    {
        return this.number_account;
    }


}






