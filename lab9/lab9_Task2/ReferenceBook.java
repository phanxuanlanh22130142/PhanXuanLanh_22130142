package lab9_Task2;
import java.util.List;

public class ReferenceBook extends Publication {
    private String field;
    private List<Chapter> chapters;

    public ReferenceBook(String title, int numberOfPages, int yearPublished, String author, double price, String field, List<Chapter> chapters) {
        super(title, numberOfPages, yearPublished, author, price);
        this.field = field;
        this.chapters = chapters;
    }

    public String getField() {
        return field;
    }

    public Chapter getLongestChapter() {
        Chapter longestChapter = chapters.get(0);
        for (Chapter chapter : chapters) {
            if (chapter.getNumberOfPages() > longestChapter.getNumberOfPages()) {
                longestChapter = chapter;
            }
        }
        return longestChapter;
    }

    @Override
    public boolean isMagazine() {
        return false;
    }
}
