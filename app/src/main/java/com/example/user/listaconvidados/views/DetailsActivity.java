package com.example.user.listaconvidados.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.user.listaconvidados.R;
import com.example.user.listaconvidados.constants.EventoConstants;
import com.example.user.listaconvidados.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);

        this.mViewHolder.checkParticipate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.check_participate) {
            // Lógica para salvar a resposta
            if (this.mViewHolder.checkParticipate.isChecked()) {
                this.mSecurityPreferences.storeString(EventoConstants.PRESENCE, EventoConstants.CONFIRMED_WILL_GO);
            } else {
                this.mSecurityPreferences.storeString(EventoConstants.PRESENCE, EventoConstants.CONFIRMED_WONT_GO);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
