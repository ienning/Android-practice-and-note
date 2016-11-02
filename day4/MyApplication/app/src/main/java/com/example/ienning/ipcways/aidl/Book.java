package com.example.ienning.ipcways.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ienning on 16-11-2.
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

    // 下面两个方式是实现Parcelable接口的
    public int describeContents() {
        return 0;
    }

    // falgs有两种值，0和1，如果是１则标识当前对象需要作为返回值返回
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(bookId);
        out.writeString(bookName);
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        // 对序列化对象当中创建和原来对象一样的对象
        public Book createFromParcel(Parcel data) {
            return new Book(data);
        }
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    private Book(Parcel data) {
        bookId = data.readInt();
        bookName = data.readString();
    }
    @Override
    public String toString() {
        return String.format("[bookId:%s, bookName:%s", bookId, bookName);
    }
}
