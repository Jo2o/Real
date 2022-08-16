package unittesting.auditsystem;

public class Main {

    public static void main(String[] args) {
        String absolutePath = "C:\\Work\\projects\\Real\\src\\main\\resources\\AuditManager";
        
        AuditManager1.builder()
            .directoryName(absolutePath)
            .maxEntriesPerFile(6)
            .build()
            .addRecord("Jozo", absolutePath);
    }
    
}
