package bancodedados;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.Date;

public class DBController {

    public static String URL_WEB_SERVICE = "http://10.21.80.174" +"/webservice_babbler/";

    public static JSONArray selectAllFromReadAtividadePadrao (Context context) throws JSONException, IOException{
        if (!checkNetworkConnection(context)) {
            Toast.makeText(context, "Falha na Conexão com a Internet!", Toast.LENGTH_LONG).show();
            return null;
        }
        checkThreadPolicy();
        URL url = new URL(URL_WEB_SERVICE + "ws_read/ws_read_atividade_padrao.php");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String json;
        while (((json=bufferedReader.readLine())) != null){
            sb.append(json+"\n");
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }

    public static int insertIntoResponsavel(Context context, String email, String senha) throws IOException {
        if (!checkNetworkConnection(context)) {
            Toast.makeText(context, "Falha na Conexão com a Internet!", Toast.LENGTH_LONG).show();
            return 0;
        }
        checkThreadPolicy();
        String values = "email="+email+"&"+"senha="+senha;
        URL url = new URL(URL_WEB_SERVICE + "ws_insert/ws_insert_responsavel.php?"+values);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = bufferedReader.readLine();
        if (response.equals("false")) {
            Toast.makeText(context, "Erro no Banco de Dados!", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }
    }

    public static JSONArray selectAllFromAtividadeByEmail(Context context, String email_resp) throws IOException, JSONException {
        if (!checkNetworkConnection(context)) {
            return null;
        }
        checkThreadPolicy();
        String values = "email_resp="+email_resp;
        URL url = new URL(URL_WEB_SERVICE + "ws_read/ws_read_atividade.php?"+values);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String json;
        while ((json = bufferedReader.readLine()) != null) {
            sb.append(json + "\n");
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }

    public static JSONArray selectAllFromResponsavel(Context context) throws JSONException, IOException {
        if (!checkNetworkConnection(context)) {
            return null;
        }
        checkThreadPolicy();
        URL url = new URL(URL_WEB_SERVICE + "ws_read/ws_read_responsavel.php");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String json;
        while ((json = bufferedReader.readLine()) != null) {
            sb.append(json + "\n");
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }

    public static int insertIntoDependente (Context context, int verdade, String apelido, String email, String senha) throws IOException {
        if (!checkNetworkConnection(context)) {
            Toast.makeText(context, "Falha na Conexão com a Internet!", Toast.LENGTH_LONG).show();
            return 0;
        }
        checkThreadPolicy();
        String values = "verdade="+verdade+"apelido="+apelido+"&"+"email="+email+"&"+"senha="+senha;
        URL url = new URL(URL_WEB_SERVICE + "ws_insert/ws_insert_dependente.php?"+values);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = bufferedReader.readLine();
        if (response.equals("false")) {
            Toast.makeText(context, "Erro no Banco de Dados!", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }
    }

    public static JSONArray selectAllFromDependente(Context context) throws JSONException, IOException {
        if (!checkNetworkConnection(context)) {
            return null;
        }
        checkThreadPolicy();
        URL url = new URL(URL_WEB_SERVICE + "ws_read/ws_read_dependente.php");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String json;
        while ((json = bufferedReader.readLine()) != null) {
            sb.append(json + "\n");
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }
    public static int insertIntoRelatorio (Context context, String botao, String data, String horario,
                                    String apelido, String email) throws IOException {
        if (!checkNetworkConnection(context)) {
            Toast.makeText(context, "Falha na Conexão com a Internet!", Toast.LENGTH_LONG).show();
            return 0;
        }
        checkThreadPolicy();
        apelido = apelido.replace(" ", "%20");
        String values = "botao="+botao+"&horario="+horario+"&data="+data+"&Dependente_apelido="+apelido+"&Dependente_Responsavel_email="+email;
        URL url = new URL(URL_WEB_SERVICE + "ws_insert/ws_insert_relatorio.php?"+values);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = bufferedReader.readLine();
        if (response.equals("false")) {
            Toast.makeText(context, "Erro no Banco de Dados!", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }
    }

    public static JSONArray selectAllFromRelatorio(Context context, String email_resp) throws JSONException, IOException {
        if (!checkNetworkConnection(context)) {
            return null;
        }
        checkThreadPolicy();
        URL url = new URL(URL_WEB_SERVICE + "ws_read/ws_read_relatorio.php?email_resp="+email_resp);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String json;
        while ((json = bufferedReader.readLine()) != null) {
            sb.append(json + "\n");
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }


    private static boolean checkNetworkConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    private static void checkThreadPolicy(){
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

}
