package made_in_abyss.carStore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

import io.realm.Realm

class AddCar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        val id = findViewById(R.id.idEditText) as EditText
        val name = findViewById(R.id.carTypeEditText) as EditText
        val model = findViewById(R.id.modelEditText) as EditText
        val status = findViewById(R.id.isNewcheckBox) as CheckBox

        val addCar = findViewById(R.id.addButton) as Button

        addCar.setOnClickListener {
            val car = Car()

            car.id = id.text.toString()
            car.name = name.text.toString()
            car.model = model.text.toString()
            car.status = status.isChecked

            // Initialize Realm
            Realm.init(applicationContext)
            // Get a Realm instance for this thread
            val realm = Realm.getDefaultInstance()

            realm.beginTransaction() // open connection
            realm.copyToRealmOrUpdate(car) // copy object
            realm.commitTransaction() // write it in DB

            Toast.makeText(this@AddCar, "تم إضافة السيارة", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
