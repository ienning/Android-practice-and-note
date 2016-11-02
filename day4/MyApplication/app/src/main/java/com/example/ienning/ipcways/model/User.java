package com.example.ienning.ipcways.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.ienning.ipcways.aidl.Book;

import java.io.Serializable;

/**
 * Created by ienning on 16-11-2.
 */

public class User implements Parcelable, Serializable{
    private static final long serialVersionUID = 610311508931208707L;

    public int userId;
    public String name;
    public boolean isMale;

    public Book book;

    public User() {

    }
    public User(int userId, String name, boolean isMale) {
        this.userId = userId;
        this.name = name;
        this.isMale = isMale;
    }

    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(userId);
        out.writeString(name);
        out.writeInt(isMale ? 1 : 0);
        out.writeParcelable(book, 0);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        userId = in.readInt();
        name = in.readString();
        isMale = in.readInt() == 1;
        // 由于book是另外一个可序列化对象，它的反序列化过程需要传递当前线程的上下文类加载器。否则会报无法找到类的错误,
        // 至于为什么，现在还不清楚。。。
        book = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }
    @Override
    public String toString() {
        return String.format("User:{userId %s, userName %s, isMale:%s}, with book:{%s}", userId, name, isMale, book);
    }
}
