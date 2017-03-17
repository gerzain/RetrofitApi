package com.example.irving.retrofitclientes.actividades;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.irving.retrofitclientes.R;
import com.example.irving.retrofitclientes.adaptadores.EmpleadoAdapter;
import com.example.irving.retrofitclientes.servicios.Api;
import com.example.irving.retrofitclientes.servicios.ResponseUsuarios;
import com.example.irving.retrofitclientes.servicios.EmpleadosResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewempleados;
    private ArrayList<EmpleadosResponse> empleadosResponseArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewempleados = (RecyclerView) findViewById(R.id.reciclador_empleado);
        recyclerViewempleados.setHasFixedSize(true);
        empleadosResponseArrayList = new ArrayList<>(0);
        recyclerViewempleados.setLayoutManager(new LinearLayoutManager(this));
        new PeticionPhp().execute();
    }




    public static class PeticionNodeJS extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            final String ulr = "http://192.168.1.68:3000/api/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ulr)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Api servicio = retrofit.create(Api.class);
            Call<List<ResponseUsuarios>> respuesta = servicio.getUsuarios();
            try {
                for (ResponseUsuarios usuario : respuesta.execute().body()) {
                    Log.e("Respuesta: ", usuario.getId() + "" + usuario.getEmail() + " " + usuario.getName());

                }


                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }




    public class PeticionPhp extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... voids)
        {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            final String sevice = "http://192.168.1.68/slim_app/public/empleados/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(sevice)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            Api consume = retrofit.create(Api.class);
            Call<List<EmpleadosResponse>> respuesta = consume.getUsers();

            try {
                for (EmpleadosResponse empleadosResponse : respuesta.execute().body())
                {

                    /*Log.e("Respuesta:", empleadosResponse.getNombre() + "  " +
                            empleadosResponse.getApellido() + " " + empleadosResponse.getCorreo()
                            + " " + empleadosResponse.getSueldo() + ""
                            + empleadosResponse.getNombreProfesion() + " "
                            + empleadosResponse.getFechaNacimiento() + " " + empleadosResponse.getFechaRegistro() );*/
                            empleadosResponseArrayList.add(empleadosResponse);
                  //  Log.d("ResId", String.valueOf(empleadosResponse.getId()));

                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            EmpleadoAdapter empleadoAdapter=new EmpleadoAdapter(empleadosResponseArrayList);
                            recyclerViewempleados.setAdapter(empleadoAdapter);
                        }
                    });



                }


                return null;
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            return null;
        }
    }// Finaliza Hilo en segunda plano


}//Termina la clase MainActivity
