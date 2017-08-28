package made_in_abyss.carStore;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by VOID on 8/2/2017.
 */

public class Car extends RealmObject{

    @PrimaryKey
    private String id;
    private String name;
    private String model;
    private boolean status;

    private RealmList<Car> cars; // Declare one-to-many relationships ?

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



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
