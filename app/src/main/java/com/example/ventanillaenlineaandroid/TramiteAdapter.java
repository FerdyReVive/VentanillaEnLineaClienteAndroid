package com.example.ventanillaenlineaandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ventanillaenlineaandroid.databinding.TramiteListItemBinding;

public class TramiteAdapter extends ListAdapter<Tramite, TramiteAdapter.TramiteViewHolder> {
    protected TramiteAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public TramiteAdapter.TramiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TramiteListItemBinding binding =
                TramiteListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new TramiteViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull TramiteAdapter.TramiteViewHolder holder, int position) {
        Tramite tramite = getItem(position);
        holder.bind(tramite);

    }

    public class TramiteViewHolder extends RecyclerView.ViewHolder{
        private final TramiteListItemBinding binding;
        public TramiteViewHolder(@NonNull TramiteListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Tramite tramite) {

            binding.fechaText.setText(tramite.getFecha());
            binding.tipoTramiteText.setText(String.valueOf(tramite.getIdTipoTramite()));
            binding.estadoText.setText(String.valueOf(tramite.getEstado()));

            binding.executePendingBindings();
        }

    }

    public static final DiffUtil.ItemCallback<Tramite> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Tramite>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Tramite oldTramite, @NonNull Tramite newTramite) {

                    return oldTramite.getIdTramite()==newTramite.getIdTramite();
                }
                @Override
                public boolean areContentsTheSame(
                        @NonNull Tramite oldTramite, @NonNull Tramite newTramite) {
                    return oldTramite.equals(newTramite);
                }
            };



}
