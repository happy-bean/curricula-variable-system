package edu.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_num
     *
     * @mbggenerated
     */
    private Integer uNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_passwd
     *
     * @mbggenerated
     */
    private String uPasswd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_type
     *
     * @mbggenerated
     */
    private Integer uType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_name
     *
     * @mbggenerated
     */
    private String uName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_gender
     *
     * @mbggenerated
     */
    private Integer uGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_grade
     *
     * @mbggenerated
     */
    private Integer uGrade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_major
     *
     * @mbggenerated
     */
    private String uMajor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.u_key
     *
     * @mbggenerated
     */
    private String uKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_num
     *
     * @return the value of user.u_num
     *
     * @mbggenerated
     */
    public Integer getuNum() {
        return uNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_num
     *
     * @param uNum the value for user.u_num
     *
     * @mbggenerated
     */
    public void setuNum(Integer uNum) {
        this.uNum = uNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_passwd
     *
     * @return the value of user.u_passwd
     *
     * @mbggenerated
     */
    public String getuPasswd() {
        return uPasswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_passwd
     *
     * @param uPasswd the value for user.u_passwd
     *
     * @mbggenerated
     */
    public void setuPasswd(String uPasswd) {
        this.uPasswd = uPasswd == null ? null : uPasswd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_type
     *
     * @return the value of user.u_type
     *
     * @mbggenerated
     */
    public Integer getuType() {
        return uType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_type
     *
     * @param uType the value for user.u_type
     *
     * @mbggenerated
     */
    public void setuType(Integer uType) {
        this.uType = uType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_name
     *
     * @return the value of user.u_name
     *
     * @mbggenerated
     */
    public String getuName() {
        return uName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_name
     *
     * @param uName the value for user.u_name
     *
     * @mbggenerated
     */
    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_gender
     *
     * @return the value of user.u_gender
     *
     * @mbggenerated
     */
    public Integer getuGender() {
        return uGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_gender
     *
     * @param uGender the value for user.u_gender
     *
     * @mbggenerated
     */
    public void setuGender(Integer uGender) {
        this.uGender = uGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_grade
     *
     * @return the value of user.u_grade
     *
     * @mbggenerated
     */
    public Integer getuGrade() {
        return uGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_grade
     *
     * @param uGrade the value for user.u_grade
     *
     * @mbggenerated
     */
    public void setuGrade(Integer uGrade) {
        this.uGrade = uGrade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_major
     *
     * @return the value of user.u_major
     *
     * @mbggenerated
     */
    public String getuMajor() {
        return uMajor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_major
     *
     * @param uMajor the value for user.u_major
     *
     * @mbggenerated
     */
    public void setuMajor(String uMajor) {
        this.uMajor = uMajor == null ? null : uMajor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.u_key
     *
     * @return the value of user.u_key
     *
     * @mbggenerated
     */
    public String getuKey() {
        return uKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.u_key
     *
     * @param uKey the value for user.u_key
     *
     * @mbggenerated
     */
    public void setuKey(String uKey) {
        this.uKey = uKey == null ? null : uKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getuNum() == null ? other.getuNum() == null : this.getuNum().equals(other.getuNum()))
            && (this.getuPasswd() == null ? other.getuPasswd() == null : this.getuPasswd().equals(other.getuPasswd()))
            && (this.getuType() == null ? other.getuType() == null : this.getuType().equals(other.getuType()))
            && (this.getuName() == null ? other.getuName() == null : this.getuName().equals(other.getuName()))
            && (this.getuGender() == null ? other.getuGender() == null : this.getuGender().equals(other.getuGender()))
            && (this.getuGrade() == null ? other.getuGrade() == null : this.getuGrade().equals(other.getuGrade()))
            && (this.getuMajor() == null ? other.getuMajor() == null : this.getuMajor().equals(other.getuMajor()))
            && (this.getuKey() == null ? other.getuKey() == null : this.getuKey().equals(other.getuKey()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getuNum() == null) ? 0 : getuNum().hashCode());
        result = prime * result + ((getuPasswd() == null) ? 0 : getuPasswd().hashCode());
        result = prime * result + ((getuType() == null) ? 0 : getuType().hashCode());
        result = prime * result + ((getuName() == null) ? 0 : getuName().hashCode());
        result = prime * result + ((getuGender() == null) ? 0 : getuGender().hashCode());
        result = prime * result + ((getuGrade() == null) ? 0 : getuGrade().hashCode());
        result = prime * result + ((getuMajor() == null) ? 0 : getuMajor().hashCode());
        result = prime * result + ((getuKey() == null) ? 0 : getuKey().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uNum=").append(uNum);
        sb.append(", uPasswd=").append(uPasswd);
        sb.append(", uType=").append(uType);
        sb.append(", uName=").append(uName);
        sb.append(", uGender=").append(uGender);
        sb.append(", uGrade=").append(uGrade);
        sb.append(", uMajor=").append(uMajor);
        sb.append(", uKey=").append(uKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}