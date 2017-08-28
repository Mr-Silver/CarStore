package made_in_abyss.carStore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class AddCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        final EditText id             = (EditText) findViewById(R.id.idEditText);
        final EditText name           = (EditText) findViewById(R.id.carTypeEditText);
        final EditText model          = (EditText) findViewById(R.id.modelEditText);
        final CheckBox status         = (CheckBox) findViewById(R.id.isNewcheckBox);

        Button addCar           = (Button) findViewById(R.id.addButton);

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Car car = new Car();

                car.setId(id.getText().toString());
                car.setName(name.getText().toString());
                car.setModel(model.getText().toString());
                car.setStatus(status.isChecked());

                // Initialize Realm
                Realm.init(getApplicationContext());
                // Get a Realm instance for this thread
                Realm realm = Realm.getDefaultInstance();

                realm.beginTransaction(); // open connection
                realm.copyToRealmOrUpdate(car); // copy object
                realm.commitTransaction(); // write it in DB

                Toast.makeText(AddCar.this, "تم إضافة السيارة", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
