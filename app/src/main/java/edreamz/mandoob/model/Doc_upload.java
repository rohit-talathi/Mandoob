package edreamz.mandoob.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Doc_upload implements Parcelable {

    private String id;
    private String doc_name;
    private String required;
    private String document_type;

    public Doc_upload() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public static Creator<Doc_upload> getCREATOR() {
        return CREATOR;
    }


    public Doc_upload(Parcel in) {
        id = in.readString();
        doc_name = in.readString();
        required = in.readString();
        document_type = in.readString();

    }

    public static final Creator<Doc_upload> CREATOR = new Creator<Doc_upload>() {
        @Override
        public Doc_upload createFromParcel(Parcel in) {
            return new Doc_upload(in);
        }

        @Override
        public Doc_upload[] newArray(int size) {
            return new Doc_upload[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(doc_name);
        parcel.writeString(required);
        parcel.writeString(document_type);

    }
}
