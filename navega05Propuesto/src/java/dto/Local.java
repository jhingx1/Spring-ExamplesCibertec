package dto;
public class Local {
    
    private Integer localId;
    private String local;

    public Local(Integer localId, String local) {
        this.localId = localId;
        this.local = local;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
}
