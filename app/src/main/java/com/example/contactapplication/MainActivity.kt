package com.example.contactapplication

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {



    private lateinit var recyclerView: RecyclerView ;
    private lateinit var add_button: FloatingActionButton;


    private lateinit var myDB: MyDataBase;
    private lateinit var Contact_Name: ArrayList<String>
    private lateinit var Contact_Telephone: ArrayList<String>
    private lateinit var Contact_Email: ArrayList<String>
    private lateinit var Contact_Ville: ArrayList<String>
    private lateinit var Contact_CodePostale: ArrayList<String>


    private lateinit var customAdapter: CustomAdapter ;







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar?.title = "Contact Page"

//add Fonction
        recyclerView =findViewById(R.id.recyclerView);
        add_button =findViewById(R.id.add_button);
        add_button.setOnClickListener {
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)

        }





//recuperation operation
        myDB = MyDataBase(this@MainActivity)
        Contact_Name = ArrayList()
        Contact_Telephone = ArrayList()
        Contact_Email = ArrayList()
        Contact_Ville = ArrayList()
        Contact_CodePostale = ArrayList()

        StoreNameFromData();


        customAdapter = CustomAdapter(this@MainActivity,this,
            Contact_Name  ,
            Contact_Email,
            Contact_Telephone,
            Contact_Ville,
            Contact_CodePostale )

        recyclerView.setAdapter(customAdapter);
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity);


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            recreate()
        }
    }



    private fun StoreNameFromData() {
        val cursor = myDB.readAllData()

        if (cursor.count == 0) {
            Toast.makeText(this@MainActivity, "No Data.", Toast.LENGTH_LONG).show()
        } else {
            while (cursor.moveToNext()) {
                Contact_Name.add(cursor.getString(0))
                Contact_Email.add(cursor.getString(1))
                Contact_Telephone.add(cursor.getString(2))
                Contact_Ville.add(cursor.getString(3))
                Contact_CodePostale.add(cursor.getString(4))
            }
        }    }

}

