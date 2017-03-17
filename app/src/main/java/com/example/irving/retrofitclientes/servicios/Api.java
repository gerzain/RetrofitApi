package com.example.irving.retrofitclientes.servicios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Irving on 17/03/2017.
 */
public interface Api
{

    @GET("clients")
    Call< List <ResponseUsuarios> >getUsuarios();
    @GET("getAll")
    Call< List<EmpleadosResponse> > getUsers();
}

