package lab9_Task2;
import java.util.*;
import java.util.stream.Collectors;

public class PublicationManagement {
    private List<Publication> publications;

    public PublicationManagement(List<Publication> publications) {
        this.publications = publications;
    }

    public double getTotalPrice() {
        return publications.stream().mapToDouble(Publication::getPrice).sum();
    }

    public ReferenceBook findLongestChapterReferenceBook() {
        return publications.stream()
  .filter(publication -> publication instanceof ReferenceBook).map(publication -> (ReferenceBook) publication)
 .max(Comparator.comparingInt(rb -> rb.getLongestChapter().getNumberOfPages())).orElse(null);
    }

    public List<Magazine> findMagazinesByYear(int year) {
        return publications.stream()
 .filter(publication -> publication instanceof Magazine && publication.getYearPublished() == year)
 .map(publication -> (Magazine) publication).collect(Collectors.toList());
    }

    public boolean containsMagazineByName(String magazineName) {
        return publications.stream()
                .anyMatch(publication -> publication instanceof Magazine && ((Magazine) publication).getMagazineName().equals(magazineName));
    }

    public List<Publication> sortPublicationsByTitleAndYear() {
        List<Publication> sortedPublications = new ArrayList<>(publications);
        sortedPublications.sort(Comparator.comparing(Publication::getTitle).thenComparing(Publication::getYearPublished));
        return sortedPublications;
    }

    public Map<Integer, Integer> countPublicationsByYear() {
        Map<Integer, Integer> publicationCountByYear = new HashMap<>();
        publications.forEach(publication -> publicationCountByYear.merge(publication.getYearPublished(), 1, Integer::sum));
        return publicationCountByYear;
    }
    
    	public static void main(String[] args) {
            
            List<Publication> publications = new ArrayList<>();
            publications.add(new Magazine("Magazine1", 50, 2021, "Author1", 10.0, "MagazineName1"));
            publications.add(new Magazine("Magazine2", 60, 2021, "Author2", 12.0, "MagazineName2"));
            
            List<Chapter> chapters1 = new ArrayList<>();
            chapters1.add(new Chapter("Chapter1", 30));
            chapters1.add(new Chapter("Chapter2", 25));
            
            ReferenceBook referenceBook1 = new ReferenceBook("ReferenceBook1", 200, 2020, "Author3", 40.0, "Field1", chapters1);
            List<Chapter> chapters2 = new ArrayList<>();
            chapters2.add(new Chapter("Chapter1", 40));
            chapters2.add(new Chapter("Chapter2", 35));
            
            ReferenceBook referenceBook2 = new ReferenceBook("ReferenceBook2", 250, 2019, "Author4", 45.0, "Field2", chapters2);
            publications.add(referenceBook1);
            publications.add(referenceBook2);
            
         
            PublicationManagement publicationManagement = new PublicationManagement(publications);
            
            double totalPrice = publicationManagement.getTotalPrice();
            System.out.println("Total price of all publications: " + totalPrice);
            
            ReferenceBook longestChapterReferenceBook = publicationManagement.findLongestChapterReferenceBook();
            if (longestChapterReferenceBook != null) {
                System.out.println("Reference book with the longest chapter: " + longestChapterReferenceBook.getTitle());
            }
            
            List<Magazine> magazines2021 = publicationManagement.findMagazinesByYear(2021);
            System.out.println("Magazines published in 2021: " + magazines2021.size());
            
            boolean containsMagazine = publicationManagement.containsMagazineByName("MagazineName1");
            System.out.println("Contains magazine with name 'MagazineName1': " + containsMagazine);
            
            List<Publication> sortedPublications = publicationManagement.sortPublicationsByTitleAndYear();
            System.out.println("Sorted publications: ");
            for (Publication publication : sortedPublications) {
                System.out.println(publication.getTitle() + " - " + publication.getYearPublished());
            }
            
            Map<Integer, Integer> publicationCountByYear = publicationManagement.countPublicationsByYear();
            System.out.println("Publication count by year: " + publicationCountByYear);
        }
}
