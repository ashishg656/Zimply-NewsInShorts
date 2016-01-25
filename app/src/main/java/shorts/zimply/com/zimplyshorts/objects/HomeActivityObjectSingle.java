package shorts.zimply.com.zimplyshorts.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ashish Goel on 1/24/2016.
 */
public class HomeActivityObjectSingle implements Parcelable {

    String desc, slug, img, title;
    boolean isZimplyPage;

    public HomeActivityObjectSingle(Parcel in) {
        desc = in.readString();
        slug = in.readString();
        img = in.readString();
        title = in.readString();
        isZimplyPage = in.readByte() != 0;
    }

    public static final Creator<HomeActivityObjectSingle> CREATOR = new Creator<HomeActivityObjectSingle>() {
        @Override
        public HomeActivityObjectSingle createFromParcel(Parcel in) {
            return new HomeActivityObjectSingle(in);
        }

        @Override
        public HomeActivityObjectSingle[] newArray(int size) {
            return new HomeActivityObjectSingle[size];
        }
    };

    public HomeActivityObjectSingle() {

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isZimplyPage() {
        return isZimplyPage;
    }

    public void setZimplyPage(boolean zimplyPage) {
        isZimplyPage = zimplyPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(desc);
        dest.writeString(slug);
        dest.writeString(img);
        dest.writeString(title);
        dest.writeByte((byte) (isZimplyPage ? 1 : 0));
    }
}
