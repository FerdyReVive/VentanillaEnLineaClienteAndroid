// LogInActivity.java
package com.example.ventanillaenlineaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ventanillaenlineaandroid.api.ApiClient;
import com.example.ventanillaenlineaandroid.databinding.EstudianteLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    private EstudianteLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = EstudianteLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Listener para el botón usando View Binding
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener las credenciales ingresadas
                String username = binding.userName.getText().toString().trim();
                String password = binding.password.getText().toString().trim();

                // Validar que los campos no estén vacíos
                if (username.isEmpty() || password.isEmpty()) {
                    binding.txtOutput.setText("Por favor, ingresa tus credenciales.");
                    return;
                }

                // Crear objeto LogIn
                LogIn loginRequest = new LogIn(username, password);

                // Deshabilitar el botón para evitar múltiples clics
                binding.btnSend.setEnabled(false);
                binding.txtOutput.setText("Iniciando sesión...");
                // Si tienes un ProgressBar, descomenta la siguiente línea
                // binding.progressBar.setVisibility(View.VISIBLE);

                // Realizar la llamada a la API
                ApiClient.getInstance().getService().login(loginRequest).enqueue(new Callback<HttpResponse>() {
                    @Override
                    public void onResponse(Call<HttpResponse> call, Response<HttpResponse> response) {
                        binding.btnSend.setEnabled(true); // Rehabilitar el botón
                        // binding.progressBar.setVisibility(View.GONE); // Ocultar ProgressBar

                        if (response.isSuccessful() && response.body() != null) {
                            HttpResponse httpResponse = response.body();
                            if (httpResponse.getToken() != null && !httpResponse.getToken().isEmpty()) {
                                // Inicio de sesión exitoso, navegar a ConsultarTramitesActivity
                                Intent intent = new Intent(LogInActivity.this, ConsultarTramitesActivity.class);
                                // Opcional: Guardar el token para uso futuro
                                saveToken(httpResponse.getToken());
                                startActivity(intent);
                            } else {
                                // Token no recibido, mostrar mensaje de error
                                binding.txtOutput.setText("Error al generar el token.");
                                Toast.makeText(LogInActivity.this, "Error al generar el token.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Respuesta no exitosa (código de error)
                            binding.txtOutput.setText("Error en la autenticación. Intenta nuevamente.");
                            Toast.makeText(LogInActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<HttpResponse> call, Throwable t) {
                        binding.btnSend.setEnabled(true); // Rehabilitar el botón
                        // binding.progressBar.setVisibility(View.GONE); // Ocultar ProgressBar
                        // Error de red o conversión
                        binding.txtOutput.setText("Error de red. Verifica tu conexión.");
                        Toast.makeText(LogInActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // Configuración de WindowInsets (opcional)
        ViewCompat.setOnApplyWindowInsetsListener(binding.login, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * Método para guardar el token en SharedPreferences.
     * Esto es útil para mantener el estado de autenticación del usuario.
     */
    private void saveToken(String token) {
        getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                .edit()
                .putString("auth_token", token)
                .apply();
    }
}
