package com.open_open.mvpretrorxjava.entity;

/******************************************
 * 类名称：Bean
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/6
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class Bean {


    /**
     * code : 0
     * message : string
     * data : {"createTime":"2018-06-06T15:10:56.166Z","updateTime":"2018-06-06T15:10:56.166Z","userId":0,"password":"string","phone":"string","nickName":"string","ticket":"string","profileImageUrl":"string","status":0,"realName":"string","birth":"2018-06-06T15:10:56.166Z","balance":0}
     */

    private int code;
    private String message;
    private DataBean data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        /**
         * createTime : 2018-06-06T15:10:56.166Z
         * updateTime : 2018-06-06T15:10:56.166Z
         * userId : 0
         * password : string
         * phone : string
         * nickName : string
         * ticket : string
         * profileImageUrl : string
         * status : 0
         * realName : string
         * birth : 2018-06-06T15:10:56.166Z
         * balance : 0
         */

        private String createTime;
        private String updateTime;
        private int userId;
        private String password;
        private String phone;
        private String nickName;
        private String ticket;
        private String profileImageUrl;
        private int status;
        private String realName;
        private String birth;
        private int balance;

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public void setProfileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public int getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }

        public String getPhone() {
            return phone;
        }

        public String getNickName() {
            return nickName;
        }

        public String getTicket() {
            return ticket;
        }

        public String getProfileImageUrl() {
            return profileImageUrl;
        }

        public int getStatus() {
            return status;
        }

        public String getRealName() {
            return realName;
        }

        public String getBirth() {
            return birth;
        }

        public int getBalance() {
            return balance;
        }
    }
}
