package com.example.irving.retrofitclientes.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.irving.retrofitclientes.R;
import com.example.irving.retrofitclientes.servicios.EmpleadosResponse;

import java.util.List;

/**
 * Created by Irving on 17/03/2017.
 */
public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.ViewHolder>
{

    private List<EmpleadosResponse> dataset;

    public EmpleadoAdapter(List<EmpleadosResponse> dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_empleado, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EmpleadosResponse empleado=dataset.get(position);
        holder.nombre.setText(empleado.getNombre());
        holder.apellido.setText(empleado.getApellido());
        holder.sueldo.setText(empleado.getSueldo());
        holder.fecha_nacimiento.setText(empleado.getFechaNacimiento());
        holder.fecha_registro.setText(empleado.getFechaRegistro());
        holder.email.setText(empleado.getCorreo());
    }

    public void setDataset(List<EmpleadosResponse> dataset)
    {
        this.dataset=dataset;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView nombre;
        public  TextView apellido;
        public  TextView sueldo;
        public  TextView fecha_nacimiento;
        public TextView fecha_registro;
        public TextView email;
        public TextView empleado_id;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tv_nombre);
            apellido=(TextView)itemView.findViewById(R.id.text_apellido);
            sueldo=(TextView)itemView.findViewById(R.id.text_medical_center);
            fecha_nacimiento=(TextView)itemView.findViewById(R.id.text_fecha_registro);
            fecha_registro=(TextView)itemView.findViewById(R.id.tv_fechanacimiento);
            email=(TextView)itemView.findViewById(R.id.tv_email);
            empleado_id=(TextView)itemView.findViewById(R.id.empleado_id);
        }
    }

}
