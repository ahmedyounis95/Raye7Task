
package raye7.ayounis.com.raye7task.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import raye7.ayounis.com.raye7task.utils.AppConstants;

@Entity(tableName = AppConstants.ARTICLES_TABLE_NAME,indices = @Index(value = {"url"}, unique = true))


public class Articles {
    @PrimaryKey(autoGenerate =  true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @SerializedName("source")
    @Ignore
    private Source source;
    @SerializedName("author")
    @ColumnInfo(name = "author")
    private String author;
    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;
    @SerializedName("url")
    @ColumnInfo(name = "url")
    private String url;
    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    private String publishedAt;
    @SerializedName("content")
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "checked")
    private boolean checked;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
