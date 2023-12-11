package com.example.contactapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailsPage : AppCompatActivity() {


    private lateinit var nom_input: EditText
    private lateinit var telephone_input: EditText
    private lateinit var email_input: EditText
    private lateinit var ville_input: EditText
    private lateinit var code_postale_input: EditText
    private lateinit var update_contact: Button
    private lateinit var delete_contact: Button

    private lateinit var name: String;
    private lateinit var telephone: String;
    private lateinit var email: String;
    private lateinit var ville:String;
    private lateinit var codePostale: String;







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)

        nom_input = findViewById(R.id.editTextNom2)
        telephone_input = findViewById(R.id.editTextTelephone2)
        email_input = findViewById(R.id.editTextEmail2)
        ville_input = findViewById(R.id.editTextVille2)
        code_postale_input = findViewById(R.id.editTextCodePostal2)
        update_contact = findViewById(R.id.Update_contact)
        delete_contact = findViewById(R.id.Delete_contact)

        update_contact.setOnClickListener {
            val myDB = MyDataBase(this@DetailsPage)

            // Initialize variables with values from input fields
            val name = nom_input.text.toString()
            val email = email_input.text.toString()
            val telephone = telephone_input.text.toString()
            val ville = ville_input.text.toString()
            val codePostale = code_postale_input.text.toString()

            myDB.updateData(name, email, telephone, ville, codePostale)
        }

        delete_contact.setOnClickListener{

            val myDB = MyDataBase(this@DetailsPage)
            val name = nom_input.text.toString()

            myDB.deleteData(name);


        }

        getAndSetIntentData();

    }


//confirmDialog here

    private fun getAndSetIntentData() {

        if (getIntent().hasExtra("name") && getIntent().hasExtra("email") && getIntent().hasExtra("telephone")
            && getIntent().hasExtra("ville") &&getIntent().hasExtra("codepostale")) {

            name = getIntent().getStringExtra("name").toString();
            email = getIntent().getStringExtra("email").toString();
            telephone = getIntent().getStringExtra("telephone").toString();
            ville = getIntent().getStringExtra("ville").toString();
            codePostale = getIntent().getStringExtra("codepostale").toString();

            nom_input.setText(name);
            email_input.setText(email);
            telephone_input.setText(telephone);
            ville_input.setText(ville);
            code_postale_input.setText(codePostale);

        } else {
            Toast.makeText(this, "Data invalid ", Toast.LENGTH_SHORT).show()
        }


    }


}
