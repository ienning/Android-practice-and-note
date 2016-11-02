import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ienning on 16-11-1.
 */

public class Book implements Parcelable {
    public int bookId;
    public String bookName;

    public Book() {

    }

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }
    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    private Book(Parcel source) {
        bookId = source.readInt();
        bookName = source.readString();
    }

}
