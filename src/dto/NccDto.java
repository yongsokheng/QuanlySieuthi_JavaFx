/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author YONGSOKHENG
 */
public class NccDto {
    
    private String maNcc;
    private String tenNcc;
    private String soDt;
    private String diaChi;

    public NccDto() {
    }

    
    
    public NccDto(String maNcc, String tenNcc, String soDt, String diaChi) {
        this.maNcc = maNcc;
        this.tenNcc = tenNcc;
        this.soDt = soDt;
        this.diaChi = diaChi;
    }

    /**
     * @return the maNcc
     */
    public String getMaNcc() {
        return maNcc;
    }

    /**
     * @param maNcc the maNcc to set
     */
    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    /**
     * @return the tenNcc
     */
    public String getTenNcc() {
        return tenNcc;
    }

    /**
     * @param tenNcc the tenNcc to set
     */
    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }

    /**
     * @return the soDt
     */
    public String getSoDt() {
        return soDt;
    }

    /**
     * @param soDt the soDt to set
     */
    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
