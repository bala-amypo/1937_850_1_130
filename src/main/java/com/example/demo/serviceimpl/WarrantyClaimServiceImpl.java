@Service  // if not already annotated
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    // other methods & injected repositories

    public void checkWarranty(DeviceOwnershipRecord device) {
        // assume warrantyExpiration is stored as "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate warrantyDate = LocalDate.parse(device.getWarrantyExpiration(), formatter);

        if (warrantyDate.isBefore(LocalDate.now())) {
            // warranty expired
            System.out.println("Warranty expired");
            // handle your logic here
            device.setStatus("Expired");
        } else {
            // warranty still valid
            System.out.println("Warranty valid");
            device.setStatus("Valid");
        }
    }
    
    // other methods
}
