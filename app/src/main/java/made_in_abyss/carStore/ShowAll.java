package made_in_abyss.carStore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import io.realm.Realm;

public class ShowAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        Button addCar = (Button) findViewById(R.id.addButton);

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowAll.this, AddCar.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {     // we will write the code that summen the all the data
        super.onResume();
/*
        // Initialize Realm
        Realm.init(getApplicationContext());
        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        List<Car> cars =
*/

    }
}
