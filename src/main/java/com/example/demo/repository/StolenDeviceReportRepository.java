public interface StolenDeviceReportRepository {
    boolean existsBySerialNumber(String s);
    List<StolenDeviceReport> findBySerialNumber(String s);
    List<StolenDeviceReport> findAll();
    StolenDeviceReport save(StolenDeviceReport r);
}
