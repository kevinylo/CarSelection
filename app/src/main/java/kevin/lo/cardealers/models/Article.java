
package kevin.lo.cardealers.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("niceNamedTags")
    @Expose
    private List<String> niceNamedTags = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("introduction")
    @Expose
    private String introduction;
    @SerializedName("link")
    @Expose
    private Link link;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;
    @SerializedName("style")
    @Expose
    private Style style;
    @SerializedName("contentPath")
    @Expose
    private String contentPath;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("publishedDate")
    @Expose
    private Long publishedDate;
    @SerializedName("lastModifiedDate")
    @Expose
    private Long lastModifiedDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getNiceNamedTags() {
        return niceNamedTags;
    }

    public void setNiceNamedTags(List<String> niceNamedTags) {
        this.niceNamedTags = niceNamedTags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
