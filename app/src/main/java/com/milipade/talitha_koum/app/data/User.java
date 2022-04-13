package com.milipade.talitha_koum.app.data;


import android.os.Parcel;
import android.os.Parcelable;

public class User  implements Parcelable {
    private int id;
    private String name;
    private String realname;
    private String password;

    public User() {
    }

    public User(String name, String realname, String password) {
        this.name = name;
        this.realname = realname;
        this.password = password;
    }

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        realname = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(realname);
        dest.writeString(password);
    }
}
