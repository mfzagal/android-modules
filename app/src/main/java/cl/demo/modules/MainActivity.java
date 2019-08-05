package cl.demo.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.demo.mylibrary.SaludaModulo;
import cl.demo.mylibraryflavor.MainModuleFlavorActivity;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Button button;
    private SaludaModulo saludador;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    mTextMessage.setText(saludador.saludame(getString(R.string.title_home)));
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    mTextMessage.setText(saludador.saludame(getString(R.string.title_dashboard)));
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    mTextMessage.setText(saludador.saludame(getString(R.string.title_notifications)));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainModuleFlavorActivity.class);
                startActivity(i);
            }
        });
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        saludador = new SaludaModulo();
    }

}
