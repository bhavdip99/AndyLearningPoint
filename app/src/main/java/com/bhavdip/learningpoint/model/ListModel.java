package com.bhavdip.learningpoint.model;


public class ListModel {
    private String CompanyName = "";
    private String Image = "";
    private String Url = "";

    /**
     * ******** Get Methods ***************
     */
    public String getCompanyName() {
        return this.CompanyName;
    }

    /**
     * ******** Set Methods *****************
     */
    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getImage() {
        return this.Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getUrl() {
        return this.Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
}
