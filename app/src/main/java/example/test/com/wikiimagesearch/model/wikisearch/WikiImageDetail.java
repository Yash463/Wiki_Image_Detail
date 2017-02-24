package example.test.com.wikiimagesearch.model.wikisearch;

/**
 * Created by root on 24/2/17.
 */
public class WikiImageDetail {
    private String pageId;
    private int ns;
    private String title;
    private int index;
    private ThumbNail thumbNail;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ThumbNail getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(ThumbNail thumbNail) {
        this.thumbNail = thumbNail;
    }
}
