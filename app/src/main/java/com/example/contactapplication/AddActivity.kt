package com.example.contactapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class AddActivity : AppCompatActivity() {
//ndhiiiifa sans fautes

    private lateinit var nom: EditText
    private lateinit var telephone: EditText
    private lateinit var email: EditText
    private lateinit var ville: EditText
    private lateinit var code_postale: EditText
    private lateinit var add_contact: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Ajout Contact"


        nom =findViewById(R.id.editTextNom);
        telephone =findViewById(R.id.editTextTelephone);
        email =findViewById(R.id.editTextEmail);
        ville =findViewById(R.id.editTextVille);
        code_postale =findViewById(R.id.editTextCodePostal);
        add_contact =findViewById(R.id.add_contact);

        add_contact.setOnClickListener {
            val myDB = MyDataBase(this@AddActivity)
            myDB.addContact(
                nom.text.toString().trim(),
                telephone.text.toString().trim(),
                email.text.toString().trim(),
                ville.text.toString().trim(),
                code_postale.text.toString().trim()
            )
            //pour reloader la page et afficher la list d'affichage

        }




            }
        }









