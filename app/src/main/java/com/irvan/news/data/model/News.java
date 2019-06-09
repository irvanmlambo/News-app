package com.irvan.news.data.model;

/**
 * Created by Irvan on 06/06/2019.
 */
public class News {

    private String Headline;
    private int ID;
    private String Blurb;
    private String SmallImageName;
    private String SmallImageAlt;
    private String LargeImageName;
    private String LargeImageAlt;
    private String ExtraImageName;
    private String ExtraImageAlt;
    private String ImageUrlLocal;
    private String ImageUrlRemote;
    private String DateCreated;
    private String Category;
    private String CategoryDisplayName;
    private int CategoryId;
    private int SiteId;
    private String SiteName;
    private String Author;
    private String Credit;
    private String CreditImageUrl;
    private String CreditUrl;
    private String UrlName;
    private boolean LiveChat;
    private boolean WebOnly;
    private String UrlFriendlyHeadline;
    private String UrlFriendlyDate;
    private boolean IsMainStory;
    private String UpdatedDate;
    private String Keywords;
    private boolean Active;
    private String ValidFrom;
    private String ValidTo;
    private String relatedArticles;

    public String getHeadline() {
        return Headline;
    }

    public void setHeadline(String headline) {
        Headline = headline;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBlurb() {
        return Blurb;
    }

    public void setBlurb(String blurb) {
        Blurb = blurb;
    }

    public String getSmallImageName() {
        return SmallImageName;
    }

    public void setSmallImageName(String smallImageName) {
        SmallImageName = smallImageName;
    }

    public String getSmallImageAlt() {
        return SmallImageAlt;
    }

    public void setSmallImageAlt(String smallImageAlt) {
        SmallImageAlt = smallImageAlt;
    }

    public String getLargeImageName() {
        return LargeImageName;
    }

    public void setLargeImageName(String largeImageName) {
        LargeImageName = largeImageName;
    }

    public String getLargeImageAlt() {
        return LargeImageAlt;
    }

    public void setLargeImageAlt(String largeImageAlt) {
        LargeImageAlt = largeImageAlt;
    }

    public String getExtraImageName() {
        return ExtraImageName;
    }

    public void setExtraImageName(String extraImageName) {
        ExtraImageName = extraImageName;
    }

    public String getExtraImageAlt() {
        return ExtraImageAlt;
    }

    public void setExtraImageAlt(String extraImageAlt) {
        ExtraImageAlt = extraImageAlt;
    }

    public String getImageUrlLocal() {
        return ImageUrlLocal;
    }

    public void setImageUrlLocal(String imageUrlLocal) {
        ImageUrlLocal = imageUrlLocal;
    }

    public String getImageUrlRemote() {
        return ImageUrlRemote;
    }

    public void setImageUrlRemote(String imageUrlRemote) {
        ImageUrlRemote = imageUrlRemote;
    }

    public String getDateCreated() {
        return DateCreated.substring(DateCreated.indexOf("/Date(")+("/Date(").length(), DateCreated.indexOf("+"));
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCategoryDisplayName() {
        return CategoryDisplayName;
    }

    public void setCategoryDisplayName(String categoryDisplayName) {
        CategoryDisplayName = categoryDisplayName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getSiteId() {
        return SiteId;
    }

    public void setSiteId(int siteId) {
        SiteId = siteId;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String credit) {
        Credit = credit;
    }

    public String getCreditImageUrl() {
        return CreditImageUrl;
    }

    public void setCreditImageUrl(String creditImageUrl) {
        CreditImageUrl = creditImageUrl;
    }

    public String getCreditUrl() {
        return CreditUrl;
    }

    public void setCreditUrl(String creditUrl) {
        CreditUrl = creditUrl;
    }

    public String getUrlName() {
        return UrlName;
    }

    public void setUrlName(String urlName) {
        UrlName = urlName;
    }

    public boolean isLiveChat() {
        return LiveChat;
    }

    public void setLiveChat(boolean liveChat) {
        LiveChat = liveChat;
    }

    public boolean isWebOnly() {
        return WebOnly;
    }

    public void setWebOnly(boolean webOnly) {
        WebOnly = webOnly;
    }

    public String getUrlFriendlyHeadline() {
        return UrlFriendlyHeadline;
    }

    public void setUrlFriendlyHeadline(String urlFriendlyHeadline) {
        UrlFriendlyHeadline = urlFriendlyHeadline;
    }

    public String getUrlFriendlyDate() {
        return UrlFriendlyDate;
    }

    public void setUrlFriendlyDate(String urlFriendlyDate) {
        UrlFriendlyDate = urlFriendlyDate;
    }

    public boolean isMainStory() {
        return IsMainStory;
    }

    public void setMainStory(boolean mainStory) {
        IsMainStory = mainStory;
    }

    public String getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        UpdatedDate = updatedDate;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String keywords) {
        Keywords = keywords;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getValidFrom() {
        return ValidFrom;
    }

    public void setValidFrom(String validFrom) {
        ValidFrom = validFrom;
    }

    public String getValidTo() {
        return ValidTo;
    }

    public void setValidTo(String validTo) {
        ValidTo = validTo;
    }

    public String getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(String relatedArticles) {
        this.relatedArticles = relatedArticles;
    }
}
