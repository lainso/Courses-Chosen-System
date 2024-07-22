// 业勤：已完成

package com.artisan.model;

import java.util.Date;

public class records {
        private int rid;
        private String cname;
        private int uid;
        private String rtime;
        private String rcondition;

        public records(){
                super();
        }

        public records(String cname, int uid, String rtime) {
                this.cname = cname;
                this.uid = uid;
                this.rtime = rtime;
        }

        public records(String rcondition) {
                this.rcondition = rcondition;
        }

        public records(int rid, String cname, int uid, String rtime, String rcondition){
                super();
                this.rid = rid;
                this.cname = cname;
                this.uid = uid;
                this.rtime = rtime;
                this.rcondition = rcondition;
        }

    public records(String cname, int uid, String rtime, String rcondition) {
        this.cname = cname;
        this.uid = uid;
        this.rtime = rtime;
        this.rcondition = rcondition;
    }

    public records(int uid, String rtime) {
        this.uid = uid;
        this.rtime = rtime;
    }

    public int getRid() {
                return rid;
        }

        public void setRid(int rid) {
                this.rid = rid;
        }

        public String getCname() {
                return cname;
        }

        public void setCname(String cname) {
                this.cname = cname;
        }

        public int getUid() {
                return uid;
        }

        public void setUid(int uid) {
                this.uid = uid;
        }

        public String getRtime() {
                return rtime;
        }

        public void setRtime(String rtime) {
                this.rtime = rtime;
        }

        public String getRcondition() {
                return rcondition;
        }

        public void setRcondition(String rcondition){
                if (rcondition=="出勤" || rcondition=="迟到" || rcondition=="早退" || rcondition=="请假" || rcondition=="旷课"){
                        this.rcondition = rcondition;
                }
                else {
                        System.out.println("考勤状态输入不合法");
                }
        }
}
