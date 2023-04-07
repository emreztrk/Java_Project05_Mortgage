package Mortgage;

public class HousePrices extends Users {
    public HousePrices(String username, String whichCondition, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        super(username, whichCondition, houseType, roomCount, downPayment, longTerm, statesTax);
        this.roomCountToPrice();
        this.conditionToPrice();
        this.houseTypeToPrice();
        this.calculateTax();
    }
    private int price;

    public void roomCountToPrice() {
        if (getRoomCount() == 0) {
            this.price += 10000;
        } else if (getRoomCount() == 1) {
            this.price += 20000;
        } else if (getRoomCount() == 2) {
            this.price += 30000;
        } else if (getRoomCount() == 3) {
            this.price += 40000;
        } else if (getRoomCount() == 4) {
            this.price += 50000;
        } else if (getRoomCount() == 5) {
            this.price += 60000;
        }
    }

    public void conditionToPrice(){
        if (this.getWhichCondition().equalsIgnoreCase("new")){
            this.price+=50000;
        }
        if (this.getWhichCondition().equalsIgnoreCase("Like new")){
            this.price+=40000;
        }
        if (this.getWhichCondition().equalsIgnoreCase("old")){
            this.price+=30000;
        }
        if (this.getWhichCondition().equalsIgnoreCase("renew required")){
            this.price+=15000;
        }

    }

    public void houseTypeToPrice(){
        if (getHouseType().equalsIgnoreCase("apartment")){
            this.price+=20000;
        }
        else if (getHouseType().equalsIgnoreCase("condo")){
            this.price+=30000;
        }
        else if (getHouseType().equalsIgnoreCase("house")){
            this.price+=40000;
        }
    }

    public void calculateTax(){
        this.price+=(this.price*getStatesTax().getTax())/100;
    }

    public int getPriceTotal() {
        return price;
    }

    public int getPriceEachMonth(){
        return (this.price-getDownPayment())/getLongTerm();
    }

}




