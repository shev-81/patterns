package patterns.structure.adapter1;

public class AdapterCards implements USB{

    private Cards card;


    public AdapterCards() {
    }

    public AdapterCards(Cards card) {
        this.card = card;
    }


    @Override
    public void connectCart() {
        card.insert();
        card.copyData();
    }
}
