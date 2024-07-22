package com.artisan.model;

public class course {
    private String cname;

    public course() {
        super();
    }

    public course(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
