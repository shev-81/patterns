package patterns.structure.adapter2;

/**
 * Структурные
 * Используя паттерн, мы можем объединить два несовместимых объекта. Конвертер между двумя несовместимыми объектами.
 */
public class Example {

    public static void main(String[] args) {
        Balance pbank = new PBank();
        pbank.getBalance();
        Balance abank = new PBankAdapter(new ABank());
        abank.getBalance();
    }
}

interface Balance{
    void getBalance();
}

class PBank implements Balance{
    private int balance;

    public PBank() {
        balance = 100;
    }

    @Override
    public void getBalance() {
        System.out.println("PBank balance = " + balance);
    }
}

class ABank implements Balance{
    private int balance;

    public ABank() {
        balance = 200;
    }

    @Override
    public void getBalance() {
        System.out.println("ABank balance = " + balance);
    }
}

class PBankAdapter extends PBank {
    private ABank abank;

    public PBankAdapter(ABank abank) {
        this.abank = abank;
    }

    @Override
    public void getBalance() {
        abank.getBalance();
    }
}
