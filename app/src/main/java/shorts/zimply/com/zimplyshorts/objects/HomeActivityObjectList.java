package shorts.zimply.com.zimplyshorts.objects;

import java.util.List;

/**
 * Created by Ashish Goel on 1/25/2016.
 */
public class HomeActivityObjectList {

    Integer next_page;
    List<HomeActivityObjectSingle> stories;

    public Integer getNext_page() {
        return next_page;
    }

    public void setNext_page(Integer next_page) {
        this.next_page = next_page;
    }

    public List<HomeActivityObjectSingle> getStories() {
        return stories;
    }

    public void setStories(List<HomeActivityObjectSingle> stories) {
        this.stories = stories;
    }
}
