package dto;

public class RFIDScanDTO {
    private String uid;
    private String status;
    private String readerId;
    private String timestamp;

    public RFIDScanDTO() {
    }

    public RFIDScanDTO(String uid, String status, String readerId, String timestamp) {
        this.uid = uid;
        this.status = status;
        this.readerId = readerId;
        this.timestamp = timestamp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
