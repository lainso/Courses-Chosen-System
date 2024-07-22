// 业勤：已完成

package com.artisan.model;

public class user {
        private int uid;
        private String uname;
        private String upass;
        private String uclass;
        private int utype;

    public user() {
        super();
    }

    public user(String uname) {
        super();
        this.uname = uname;
    }

    public user(String uname, String uclass) {
        super();
        this.uname = uname;
        this.uclass = uclass;
    }

    public user(int uid, String uname, String upass, String uclass, int utype) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.uclass = uclass;
        this.utype = utype;
    }


    public user(int uid, String upass) {
        super();
        this.uid = uid;
        this.upass = upass;
    }

    public user(int uid, String upass, int utype) {
        this.uid = uid;
        this.upass = upass;
        this.utype = utype;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public int getUtype() {
        return utype;
    }

    public void setUtype(int utype) {
        if(utype==1 || utype==0 || utype==2){
            this.utype = utype;
        }else {
            System.out.println("用户类型设置不合法");
        }

    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }
}
