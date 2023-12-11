package com.example.contactapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

     private Context context;
     Activity activity;
     private ArrayList contact_name;
    private ArrayList contact_telephone;
    private ArrayList contact_email;
    private ArrayList contact_ville;
    private ArrayList contact_codepostale;
    int position;


    CustomAdapter(Activity activity,Context context,
                  ArrayList contact_name ,
                 ArrayList contact_email,
                  ArrayList contact_telephone,
                  ArrayList contact_ville,
                  ArrayList contact_codepostale) {

        this.activity=activity;
         this.context = context;
         this.contact_name = contact_name;
         this.contact_email = contact_email;
         this.contact_telephone = contact_telephone;
         this.contact_ville = contact_ville;
         this.contact_codepostale = contact_codepostale;
     }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_contact,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        holder.name_txt.setText(String.valueOf(contact_name.get(position)));
        holder.email_txt.setText(String.valueOf(contact_email.get(position)));
        holder.telephone_txt.setText(String.valueOf(contact_telephone.get(position)));
        holder.ville_txt.setText(String.valueOf(contact_ville.get(position)));
        holder.codepostal_txt.setText(String.valueOf(contact_codepostale.get(position)));

//ken partie hedhi check it elli louta 7attta getItemCount()


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                int adapterPosition = holder.getAdapterPosition();*/

                Intent intent = new Intent(context, DetailsPage.class);

                   intent.putExtra("name",String.valueOf(contact_name.get(position)));
                   intent.putExtra("email",String.valueOf(contact_email.get(position)));
                   intent.putExtra("telephone",String.valueOf(contact_telephone.get(position)));
                   intent.putExtra("ville",String.valueOf(contact_ville.get(position)));
                   intent.putExtra("codepostale",String.valueOf(contact_codepostale.get(position)));

                   activity.startActivityForResult(intent,1);

            }
        });



    }

    @Override
    public int getItemCount() {
        return contact_email.size();
    }

public class MyViewHolder extends RecyclerView.ViewHolder{

         TextView name_txt,email_txt,telephone_txt,ville_txt,codepostal_txt ;
       LinearLayout mainLayout;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name_txt = itemView.findViewById(R.id.name_contact_txt);
        email_txt = itemView.findViewById(R.id.email_txt);
        telephone_txt = itemView.findViewById(R.id.telephone_txt);
        ville_txt = itemView.findViewById(R.id.ville_txt);
        codepostal_txt=itemView.findViewById(R.id.codepostale_txt);


mainLayout = itemView.findViewById(R.id.mainLayout);





    }
}
}
