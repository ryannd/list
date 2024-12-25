package com.ryannd.list_api.domain;

public class MediaRequest {
    private String source;
    private String id;
    private String type;

    public MediaRequest() {}

    public MediaRequest(String source, String id, String type) {
        this.source = source;
        this.id = id;
        this.type = type;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
