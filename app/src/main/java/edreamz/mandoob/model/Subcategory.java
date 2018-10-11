package edreamz.mandoob.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Subcategory implements Parcelable {

    private String id;
    private String name;
    private String description;
    private String image;
    private int is_subcategory;
    private String info;
    private String category_id;
    private int is_subofsubcategory;
    private String Category;
    private String application_fee;
    private String service_fee;
    private String duration;
    private String document_count;
    private ArrayList<Doc_upload> documentlist;

    public Subcategory() {

    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getApplication_fee() {
        return application_fee;
    }

    public void setApplication_fee(String application_fee) {
        this.application_fee = application_fee;
    }

    public String getService_fee() {
        return service_fee;
    }

    public void setService_fee(String service_fee) {
        this.service_fee = service_fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDocument_count() {
        return document_count;
    }

    public void setDocument_count(String document_count) {
        this.document_count = document_count;
    }

    public ArrayList<Doc_upload> getDocumentlist() {
        return documentlist;
    }

    public void setDocumentlist(ArrayList<Doc_upload> documentlist) {
        this.documentlist = documentlist;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public int getIs_subofsubcategory() {
        return is_subofsubcategory;
    }

    public void setIs_subofsubcategory(int is_subofsubcategory) {
        this.is_subofsubcategory = is_subofsubcategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIs_subcategory() {
        return is_subcategory;
    }

    public void setIs_subcategory(int is_subcategory) {
        this.is_subcategory = is_subcategory;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static Creator<Subcategory> getCREATOR() {
        return CREATOR;
    }


    public Subcategory(Parcel in) {
        id = in.readString();
        name = in.readString();
        description = in.readString();
        image = in.readString();
        is_subcategory = in.readInt();
        info = in.readString();
        category_id = in.readString();
        is_subofsubcategory = in.readInt();
        Category = in.readString();
        application_fee = in.readString();
        service_fee = in.readString();
        duration = in.readString();
        document_count = in.readString();
    }

    public static final Creator<Subcategory> CREATOR = new Creator<Subcategory>() {
        @Override
        public Subcategory createFromParcel(Parcel in) {
            return new Subcategory(in);
        }

        @Override
        public Subcategory[] newArray(int size) {
            return new Subcategory[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(image);
        parcel.writeInt(is_subcategory);
        parcel.writeString(info);
        parcel.writeString(category_id);
        parcel.writeInt(is_subofsubcategory);
        parcel.writeString(Category);
        parcel.writeString(application_fee);
        parcel.writeString(service_fee);
        parcel.writeString(duration);
        parcel.writeString(document_count);
    }
}
