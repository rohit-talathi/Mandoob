package edreamz.mandoob.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Subofsubcategory implements Parcelable {

    private String id;
    private String category_id;
    private String subcategory_id;
    private String name;
    private String description;
    private String image;
    private String flag;

    private String Category;
      private String  application_fee;
    private String service_fee;
      private String duration;
    private String document_count;
    private ArrayList<Doc_upload> documentlist;

    public Subofsubcategory() {

    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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



    public static Creator<Subofsubcategory> getCREATOR() {
        return CREATOR;
    }


    public Subofsubcategory(Parcel in) {
        id = in.readString();
        category_id = in.readString();
        subcategory_id= in.readString();
        name = in.readString();
        description = in.readString();
        image = in.readString();
        Category = in.readString();
        application_fee = in.readString();
        service_fee = in.readString();
        duration = in.readString();
        document_count = in.readString();
        flag=in.readString();
    }

    public static final Creator<Subofsubcategory> CREATOR = new Creator<Subofsubcategory>() {
        @Override
        public Subofsubcategory createFromParcel(Parcel in) {
            return new Subofsubcategory(in);
        }

        @Override
        public Subofsubcategory[] newArray(int size) {
            return new Subofsubcategory[size];
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
        parcel.writeString(category_id);
        parcel.writeString(subcategory_id);
        parcel.writeString(Category);
        parcel.writeString(application_fee);
        parcel.writeString(service_fee);
        parcel.writeString(duration);
        parcel.writeString(document_count);
        parcel.writeString(flag);
    }
}
