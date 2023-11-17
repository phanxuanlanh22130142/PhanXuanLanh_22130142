package lab9_Task2;

class Magazine extends Publication {
    private String magazineName;

    public Magazine(String title, int numberOfPages, int yearPublished, String author, double price, String magazineName) {
        super(title, numberOfPages, yearPublished, author, price);
        this.magazineName = magazineName;
    }

    @Override
    public boolean isMagazine() {
        return true;
    }

    public String getMagazineName() {
        return magazineName;
    }
}